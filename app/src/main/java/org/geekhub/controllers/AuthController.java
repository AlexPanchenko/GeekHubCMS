package org.geekhub.controllers;


import org.geekhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @RequestMapping("/auth")
    public String loginForm() {
        return "login";
    }

    @RequestMapping("/index")
     public String indexForm() {
        return "index";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Map<String, Object> model) {
        model.put("errorMessage", null);
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String addNewUser(
            Map<String, Object> model,
            @RequestParam("login") String login,
            @RequestParam("password") String password,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("patronymic") String patronymic,
            @RequestParam("email") String email,
            @RequestParam("skype") String skype,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("confirmPassword") String confirmPassword,
            @RequestParam("birthday") String birthDay) throws ParseException {

        String errorMessage = userService.addUser(login,password, firstName, lastName,
                patronymic, email, skype, phoneNumber, confirmPassword, birthDay, new Date());
        if(errorMessage == null){
            return "redirect:/index";
        } else{
            model.put("errorMessage", errorMessage);
            return "registration";
        }
    }
}
