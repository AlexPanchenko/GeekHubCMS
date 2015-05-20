package org.geekhub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by helldes on 20.05.2015.
 */@Controller
   @RequestMapping(value = "/student")
    public class StudentController {

    @RequestMapping(value = "/users/test", method = RequestMethod.GET)
    public String selectTest( ModelMap model){

        return "testPage";
    }
}
