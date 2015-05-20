package org.geekhub.controllers;


import org.geekhub.service.UserService;
import org.geekhub.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
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
    public String loginForm(){
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



    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Map<String, Object> model) {
        model.put("errorMessage", null);
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String addNewUser(
            HttpServletResponse response,
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

        String errorMessage = userService.addUser(login, password, firstName, lastName,
                patronymic, email, skype, phoneNumber, confirmPassword, birthDay, new Date());

            if(errorMessage == null) {
                return "redirect:/auth";
            } else{
            model.put("errorMessage", errorMessage);
            return "registration";
        }
    }
}



