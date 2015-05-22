package org.geekhub.controllers;

import org.geekhub.hibernate.bean.CourseBean;
import org.geekhub.hibernate.bean.TestConfigBeen;
import org.geekhub.service.CourseService;
import org.geekhub.service.TestConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by helldes on 21.05.2015.
 */
@Controller
@RequestMapping(value = "/student/test")
public class TestController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private TestConfigService testConfigService;

    @RequestMapping(value = "/selectCourse", method = RequestMethod.GET)
    public String selectCourse(ModelMap model) {
        List<CourseBean> courseBeanList = courseService.getCourseBeenByUser();
        model.addAttribute("coursesList", courseBeanList);
        return "test-page/selectCourse";
    }

    @RequestMapping(value = "/selectCourse", method = RequestMethod.POST)
    public String selectCourse(@RequestParam("courseId")String courseId) {
        return "redirect:/student/test/course/" + courseId;
    }

    @RequestMapping(value = "/course/{courseId}/selectTest", method = RequestMethod.GET)
    public String selectTest( @PathVariable("courseId") int courseId,
                            ModelMap model) {
        List<TestConfigBeen> listTestConfigBeen = testConfigService.getTestConfigBeensEnable(courseId);
        model.addAttribute("testList", listTestConfigBeen);
        return "test-page/selectTest";
    }

    @RequestMapping(value = "/course/{courseId}/selectTest/{testId}", method = RequestMethod.POST)
    public String selectTest(@RequestParam("courseId")String courseId,
                             @RequestParam("testId")String testId) {
        return "redirect:/student/test/course/" + courseId + "/test/" + testId;
    }

}
