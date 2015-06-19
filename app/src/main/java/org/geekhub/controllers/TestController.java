package org.geekhub.controllers;

import com.google.gson.Gson;
import org.geekhub.hibernate.bean.CourseBean;
import org.geekhub.hibernate.bean.TestConfigBeen;
import org.geekhub.hibernate.bean.TestInfo;
import org.geekhub.hibernate.entity.TestConfig;
import org.geekhub.hibernate.entity.TestStatusAssignment;
import org.geekhub.hibernate.entity.TestAssignment;

import org.geekhub.service.*;
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
    private  UserService userService;

    @Autowired
    private GeneratorRandomQuestions generatorRandomQuestions;

    @Autowired
    private CourseService courseService;

    @Autowired
    private TestConfigService testConfigService;

    @Autowired
    private TestResultService testResultService;

    @Autowired
    private TestAssignmentService testAssignmentService;

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
    public String selectTest(ModelMap model, @PathVariable("courseId") int courseId) {
        TestConfigBeen testConfigBeen = testConfigService.getTestConfigBeenEnable(courseId);
        model.addAttribute("courseId", courseId);
        TestAssignment testAssignment = testAssignmentService.getTestAssignmentBeanByTestConfigAdnUser(testConfigBeen.getId());
        if (testAssignment != null){

        }
        model.addAttribute("courseId",courseId);
        model.addAttribute("testConfig", testConfigBeen);
        model.addAttribute("testAssignment", testAssignment);
        model.addAttribute("passed", TestStatusAssignment.PASSED);
        model.addAttribute("overdue", TestStatusAssignment.OVERDUE);
        return "test-page/selectTest";
    }

    @RequestMapping(value = "/course/{courseId}/selectTest/{testId}", method = RequestMethod.POST)
    public String selectTest(@PathVariable("courseId")int courseId,
                             @PathVariable("testId")int testId) {
        return "redirect:/student/testing/course/" + courseId + "/test/" + testId;
    }

    @RequestMapping(value = "/test/{testAssignmentId}", method = RequestMethod.GET)
    public String selectTest(@PathVariable("testAssignmentId") int testAssignmentId,
                             ModelMap model) {
        TestAssignment testAssignment = testAssignmentService.getTestAssignmentById(testAssignmentId);
        if(testAssignment.getTestConfig().getQuestionCount() <= testAssignment.getTestConfig().getTestType().getQuestionList().size()) {
            if ((testAssignment.getTestStatusAssignment() != TestStatusAssignment.OVERDUE) && (testAssignment.getTestStatusAssignment() != TestStatusAssignment.PASSED)) {
                TestConfig testConfig = testAssignment.getTestConfig();
                TestConfigBeen testConfigBeen = testConfigService.getTestConfigById(testConfig.getId());
                model.addAttribute("questions", generatorRandomQuestions.generatorRandomQuestionsAll(testConfigBeen.getQuestionCount(), testAssignmentService.getTestAssignmentById(testAssignmentId).getTestConfig().getTestType()));
                model.addAttribute("testId", testConfig.getId());
                testAssignmentService.setStatus(testConfigService.getTestConfigByID(testConfig.getId()), TestStatusAssignment.IN_PROCESS);
                model.addAttribute("timeToTest", testConfigService.getTestConfigByID(testConfig.getId()).getTimeToTest());
                return "test-page/testPage";
            } else return "redirect:/";
        }else {
            return "warning/notEnoughQuestions";
        }
    }

    @RequestMapping(value = "/course/completetest/{testId}", method = RequestMethod.POST)
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

    @RequestMapping(value = "/assignmentTest", method = RequestMethod.GET)
    public String completeTest(ModelMap model) {
        model.addAttribute("testAssignmentList", testAssignmentService.getAvailableTestAssignmentByUser(userService.getLogInUser()));
        return "test-page/selectTest";
    }
}
