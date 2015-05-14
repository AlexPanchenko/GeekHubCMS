package org.geekhub.controllers;


import org.geekhub.entity.User;
import org.geekhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    public static final SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");

//    @RequestMapping(value = "/registration", method = RequestMethod.POST)
//    public String registration() {
//
//        return "registration";
//    }

    @RequestMapping("/login")
    public String loginForm() {
        return "welcome";
    }

    @RequestMapping("/index")
    public String indexForm() {
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView addNewUser(
            @RequestParam("login") String login,
            @RequestParam("password") String password,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("patronymic") String patronymic,
            @RequestParam("email") String email,
            @RequestParam("skype") String skype,
//                            @RequestParam("icq") String icq,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("confirmPassword") String confirmPassword,
            @RequestParam("birthday") String birthDay) throws ParseException {
        System.out.println(birthDay);

        Date date = dt.parse(birthDay);
        ModelAndView model = new ModelAndView();
        Date date1 = new Date();
        System.out.println(date1.getTime());
        userService.addUser(login,password, firstName, lastName, patronymic, email, skype, phoneNumber, confirmPassword, date, new Date());
        return new ModelAndView("logReg");
    }

    @ResponseBody
    @RequestMapping(value = "/logReg", method = RequestMethod.GET)
    public ModelAndView getLogRegForm(){
        return new ModelAndView("logReg");
    }
}
