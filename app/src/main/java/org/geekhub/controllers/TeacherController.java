package org.geekhub.controllers;

import org.geekhub.hibernate.bean.Page;
import org.geekhub.service.CourseService;
import org.geekhub.service.UserService;
import org.geekhub.wrapper.UserTestResultWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by admin on 21.05.2015.
 */
@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Autowired
    CourseService courseService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/userTestResult", method = RequestMethod.GET)
    public String getUserTestResult(Map<String, Object> model) throws Exception {
        //model.put("coursesList", courseService.getAllBeans());
        return "teacherpanel/userTestResult";
    }

    @RequestMapping(value = "/userTestResult/{course}", method = RequestMethod.GET)
    public String getUserTestResultWithCourse(@RequestParam(value = "p",required = true,defaultValue = "1")Integer p,
                                              @RequestParam(value = "results",defaultValue = "4",required = false) Integer recPerPage,
                                              @PathVariable String course, Map<String, Object> model) throws Exception {
        model.put("courseName", course);
        model.put("coursesList", courseService.getAllBeans());
        Page<UserTestResultWrapper> page = userService.getPageUserTestResultWrapperListByCourseName(course, p, recPerPage);
        model.put("page", page);
        return "teacherpanel/userTestResult";
    }

    @RequestMapping(value = "/checkUserAnswers/{}/{id}", method = RequestMethod.GET)
    public String checkUserAnswers(@PathVariable String id, Map<String, Object> model) throws Exception {

        return "teacherpanel/checkUserAnswers";
    }
}
