package org.geekhub.controllers;

import org.geekhub.hibernate.entity.PasswordLink;
import org.geekhub.service.RecoverPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
                                  ModelMap model,
                                  HttpServletResponse response) throws IOException {
        PasswordLink passwordLink = recoverPasswordService.getPasswordLinkById(passwordId);
        if (!link.equals(passwordLink.getPasswordLink())) {
            response.sendRedirect("/student/auth");
        }
        model.addAttribute("passwordId", passwordId);
        model.addAttribute("link", link);
        return "recoverPassword";
    }

    @RequestMapping(value = "/recoverPassword/{passwordId}/{Link}",method = RequestMethod.POST)
    public String recoverPasswordPost(@PathVariable("passwordId")int passwordId,
                                      @RequestParam("recoverPassword") String recoverPassword,
                                      @RequestParam("confirmRecoverPassword") String confirmRecoverPassword,
                                      @PathVariable("Link")String link,
                                      HttpServletResponse response) throws IOException {
        PasswordLink passwordLink = recoverPasswordService.getPasswordLinkById(passwordId);
        if (passwordLink.getPasswordLink().equals(link)) {
            if (recoverPassword.equals(confirmRecoverPassword)) {
                recoverPasswordService.recoverPassword(recoverPassword, passwordId);
                recoverPasswordService.deleteUniqueLink(passwordLink);
                //Залогинить.
                return "login";
            }
            response.getWriter().write("Password error: your password and confirmation password do not match.");
        }
        return "login";
    }
}

