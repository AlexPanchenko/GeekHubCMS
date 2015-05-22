package org.geekhub.controllers;

import org.geekhub.service.RecoverPasswordService;
import org.geekhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RecoverPasswordController {

    @Autowired
    private RecoverPasswordService recoverPasswordService;

    @RequestMapping(value = "/forgotPassword",method = RequestMethod.GET)
    public String forgotPassword(){
        return "forgotPassword";
    }

    @RequestMapping(value = "/forgotPassword",method = RequestMethod.POST)
    public String forgotPasswordPost(@RequestParam("forgotMail")String forgotMail, ModelMap modelMap){
        recoverPasswordService.sendRecover(forgotMail);
        modelMap.addAttribute("mail",recoverPasswordService.getMail(forgotMail));
        return "redirectMail";
    }

    @RequestMapping(value = "/recoverPassword/{passwordId}/{Link}",method = RequestMethod.GET)
    public String recoverPassword(@PathVariable("passwordId")int passwordId,
                                  @PathVariable("Link")String link,
                                  ModelMap model){
        model.addAttribute("passwordId",passwordId);
        model.addAttribute("link",link);
        return "recoverPassword";
    }

    @RequestMapping(value = "/recoverPassword/{passwordId}/{Link}",method = RequestMethod.POST)
    public String recoverPasswordPost(@PathVariable("passwordId")int passwordId,
                                      @PathVariable("Link")String link,
                                      @RequestParam("recoverPassword") String recoverPassword,
                                      ModelMap model){
        recoverPasswordService.recoverPassword(recoverPassword,passwordId);
        return "login";
    }
}
