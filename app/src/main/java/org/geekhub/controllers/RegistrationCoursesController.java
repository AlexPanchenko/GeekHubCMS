package org.geekhub.controllers;

import org.geekhub.service.RegistrationCoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class RegistrationCoursesController {

    @Autowired
    private RegistrationCoursesService registrationCoursesService;

    @RequestMapping(value = "/student/registrationCourses", method = RequestMethod.GET)
    public String coursesRegistration(Map<String, Object> model) {
        model.put("listCourses", registrationCoursesService.getListCourseWrappers());
        return "registrationCourses";
    }


    @RequestMapping(value = "/student/registrationCourses", method = RequestMethod.POST)
    public String registrationCourses(@RequestParam("courseId") List<Integer> id) {
        registrationCoursesService.getRegistrationUserByCourses(id);
        return "redirect:/student/registrationCourses";
    }
}
