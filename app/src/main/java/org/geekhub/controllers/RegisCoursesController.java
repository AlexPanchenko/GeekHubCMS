package org.geekhub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "ROLE_STUDENT")
public class RegisCoursesController {

    @RequestMapping(value = "/index")
    public String indexPage() {
        return "/index";
    }

    @RequestMapping(value = "/registrationCourses", method = RequestMethod.POST)
    public void registrationCourses(@RequestParam("courseId") List<Integer> id) {
        System.out.println(id);
    }
}
