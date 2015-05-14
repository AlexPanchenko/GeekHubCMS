package org.geekhub.controllers;



import org.geekhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration() {
        return "registration";
    }

    @RequestMapping("/login")
    public String loginForm () {
        return "welcome";
    }

    @RequestMapping("/index")
    public String indexForm () {
        return "index";
    }
//    @ResponseBody
//    @RequestMapping(value = "/registration", method = RequestMethod.GET)
//    public ModelAndView  addNewUser(
//                            @RequestParam("email") String email,
//                            @RequestParam("password") String password) {
//
//        ModelAndView model = new ModelAndView("registration");
//            userService.addUser(email, password);
//        return model;
//    }
}
