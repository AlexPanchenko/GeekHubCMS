package org.geekhub.controllers;

import org.geekhub.hibernate.entity.Course;
import org.geekhub.service.RegistrationCoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller(value = "/student/")
public class RegistrationCoursesController {

    @Autowired
    private RegistrationCoursesService registrationCoursesService;

    @RequestMapping(value = "/registrationCourses", method = RequestMethod.GET)
    public ModelAndView coursesRegistration() {
        ModelAndView modelAndView = new ModelAndView("registrationCourses");
        modelAndView.addObject("listCourses", registrationCoursesService.getListCourseBeans());
        return modelAndView;
    }


    @RequestMapping(value = "/registrationCourses", method = RequestMethod.POST)
    public void registrationCourses(@RequestParam("courseId") List<Integer> id) {
     registrationCoursesService.getRegistrationUserByCourses(id);
        System.out.println(id);
    }

}
