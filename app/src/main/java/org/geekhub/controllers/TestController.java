package org.geekhub.controllers;

import com.google.gson.Gson;
import org.geekhub.hibernate.bean.CourseBean;
import org.geekhub.hibernate.bean.TestConfigBeen;
import org.geekhub.hibernate.bean.TestInfo;
import org.geekhub.service.CourseService;
import org.geekhub.service.GeneratorRandomQuestions;
import org.geekhub.service.TestConfigService;
import org.geekhub.service.TestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by helldes on 21.05.2015.
 */
@Controller
@RequestMapping(value = "/student/testing")
public class TestController {

    @Autowired
    private GeneratorRandomQuestions generatorRandomQuestions;

    @Autowired
    private CourseService courseService;

    @Autowired
    private TestConfigService testConfigService;

    @Autowired
    private TestResultService testResultService;

    @RequestMapping(value = "/selectCourse", method = RequestMethod.GET)
    public String selectCourse(ModelMap model) {
        List<CourseBean> courseBeanList = courseService.getCourseBeenByUser();
        model.addAttribute("coursesList", courseBeanList);
        return "test-page/selectCourse";
    }

    @RequestMapping(value = "/selectCourse", method = RequestMethod.POST)
    public String selectCourse(@RequestParam("courseId")String courseId) {
        return "redirect:/student/testing/course/" + courseId;
    }

    @RequestMapping(value = "/course/{courseId}/selectTest", method = RequestMethod.GET)
    public String selectTest( @PathVariable("courseId") int courseId,
                            ModelMap model) {
        TestConfigBeen testConfigBeen = testConfigService.getTestConfigBeenEnable(courseId);
        model.addAttribute("courseId",courseId);
        model.addAttribute("testConfig", testConfigBeen);
        return "test-page/selectTest";
    }

    @RequestMapping(value = "/course/{courseId}/selectTest/{testId}", method = RequestMethod.POST)
    public String selectTest(@PathVariable("courseId")int courseId,
                             @PathVariable("testId")int testId) {
        return "redirect:/student/testing/course/" + courseId + "/test/" + testId;
    }

    @RequestMapping(value = "/course/{courseId}/test/{testId}", method = RequestMethod.GET)
    public String selectTest(@PathVariable("courseId") int courseId,
                             @PathVariable("testId") int testId,
                             ModelMap model) {
        TestConfigBeen testConfigBeen = testConfigService.getTestConfigById(testId);
        model.addAttribute("questions", generatorRandomQuestions.generatorRandomQuestionsAll(testConfigBeen.getQuestionCount(), courseId));
        model.addAttribute("testId", testId);
        return "test-page/testPage";
    }

    @RequestMapping(value = "/course/comletetest/{testId}", method = RequestMethod.POST)
    public String completeTest(
                             @PathVariable("testId") int testId,
                             @RequestBody String jsonStr) {
        Gson gson = new Gson();
        TestInfo[] results = gson.fromJson(jsonStr, TestInfo[].class);
        testResultService.parseResult(results, testId);

        return "test-page/testPage";
    }

    @RequestMapping(value = "/endOfTest", method = RequestMethod.GET)
    public String endOfTest() {
        return "test-page/endOfTesting";
    }
}
