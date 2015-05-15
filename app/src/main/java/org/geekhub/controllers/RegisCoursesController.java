package org.geekhub.controllers;

import org.geekhub.hibernate.entity.Course;
import org.geekhub.service.RegistrationCoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisCoursesController {

    @Autowired
    private RegistrationCoursesService registrationCoursesService;

    @RequestMapping(value = "/registrationCourses", method = RequestMethod.POST)
    public String registrationCourses( ) {


        return "registrationCourses";
    }
}
