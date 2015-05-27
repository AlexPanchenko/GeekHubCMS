package org.geekhub.controllers;

import org.geekhub.hibernate.bean.CourseBean;
import org.geekhub.service.CourseService;
import org.geekhub.service.TestConfigService;
import org.geekhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class UserProfileController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private TestConfigService testConfigService;

    @Autowired
    private UserService userService;

    @RequestMapping(value ="/userProfile", method = RequestMethod.GET)
    public ModelAndView userProfile(Principal principal){
        ModelAndView model = new ModelAndView("studentPage/userProfile");
        model.addObject("user",userService.getUserBeanByEmail(principal.getName()));
        return model;
    }
}

