package org.geekhub.controllers;

import org.geekhub.service.CourseService;
import org.geekhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by helldes on 20.05.2015.
 */@Controller
   @RequestMapping(value = "/student")
    public class StudentController {

    @Autowired
    UserService userService;

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/student/selectTest", method = RequestMethod.GET)
    public String selectTest( ModelMap model){
  //      User user =
  //      model.addAttribute("courses", )
        return "selectTest";
    }
}
