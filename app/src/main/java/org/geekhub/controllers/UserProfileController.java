package org.geekhub.controllers;

import org.geekhub.hibernate.bean.CourseBean;
import org.geekhub.service.CourseService;
import org.geekhub.service.TestConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class UserProfileController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private TestConfigService testConfigService;


    @RequestMapping(value = "/userProfile", method = RequestMethod.GET)
    public ModelAndView showUserOfCourses() {
        ModelAndView model = new ModelAndView("userProfile");
            List<CourseBean> courseBeanList = courseService.getCourseBeenByUser();
        model.addObject("coursesList", courseBeanList);
        return model;
    }
}
