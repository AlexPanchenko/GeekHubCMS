package org.geekhub.controllers;

import org.geekhub.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class HomeController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/")
    public String defaultPage(ModelMap model) throws IOException {
        model.addAttribute("courses",courseService.getAllBeans());
        return "studentPage/index";
    }

}
