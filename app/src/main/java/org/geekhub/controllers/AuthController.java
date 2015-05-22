package org.geekhub.controllers;


import org.geekhub.hibernate.bean.RegistrationResponseBean;
import org.geekhub.hibernate.bean.UserBean;
import org.geekhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String indexForm() {
        return "index";
    }

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public String loginForm() {
        return "login";
    }


//    @RequestMapping(value = "/UserSessionFilter")
//    public String login(ModelMap model, HttpSession session) {
//        org.springframework.security.core.userdetails.User principal =
//                (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        session.setAttribute(UserServiceImpl.USER_ATTRIBUTE_SESSION, userService.getUserByEmail(principal.getUsername()));
//
//        return  "index";
//    }


    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ModelAndView loginForm(@RequestParam(value = "error", required = false) String error,
                                  @RequestParam(required = false) String logout) {
        ModelAndView model = new ModelAndView("login");
        if (error != null) {
            model.addObject("error", error);
        }
        if (logout != null) {
            model.addObject("msg", logout);
        }
        return model;
    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Map<String, Object> model) {
        model.put("errorMessage", null);
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String addNewUser(
            HttpServletResponse response,
            Map<String, Object> model,
            @RequestParam("password") String password,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("skype") String skype,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("confirmPassword") String confirmPassword,
            @RequestParam("birthday") String birthDay) throws ParseException {

        SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");
        Date date = new Date();
        if (!birthDay.equals("")) {
            date = dt.parse(birthDay);
        }
        UserBean userBean = new UserBean(password, firstName, lastName, email, skype, phoneNumber, date, confirmPassword);
        RegistrationResponseBean registrationResponseBean = userService.addUser(userBean);
        if (registrationResponseBean.isSuccess()) {
            return "redirect:/auth";
        } else {
            model.put("errorMessage", registrationResponseBean.getErrorMessage());
            return "registration";
        }
    }
}

