package org.geekhub.service.impl;

import org.geekhub.hibernate.bean.CourseBean;
import org.geekhub.hibernate.bean.TestConfigBeen;
import org.geekhub.hibernate.dao.CourseDao;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.TestConfig;

import org.geekhub.service.CourseService;

import org.geekhub.hibernate.entity.TestStatus;

import org.geekhub.service.TestConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestConfigServiceImpl implements TestConfigService {
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private CourseService courseService;

    public List<TestConfigBeen> getTestConfigBeens (int courseId) {
            Course course = (Course)courseDao.read(courseId,Course.class);
            CourseBean courseBean = courseService.toBean(course);
            List<TestConfig> testConfigList = course.getTestConfig();
            List<TestConfigBeen> testConfigBeenList = new ArrayList<>();
        for (TestConfig testConfig : testConfigList) {
            testConfigBeenList.add(new TestConfigBeen(testConfig.getQuestionCount(),testConfig.getDueDate(),testConfig.getDateTimeToTest(),testConfig.getStatus(),courseBean));
        }
        return testConfigBeenList;
    }

    public List<TestConfigBeen> getTestConfigBeensEnable (int courseId) {
        Course course = (Course)courseDao.read(courseId,Course.class);
        CourseBean courseBean = courseService.toBean(course);
        List<TestConfig> testConfigList = course.getTestConfig();
        List<TestConfigBeen> testConfigBeenList = new ArrayList<>();
        for (TestConfig testConfig : testConfigList) {
            if (testConfig.getStatus().equals(TestStatus.ENABLED)){
                testConfigBeenList.add(new TestConfigBeen(testConfig.getQuestionCount(),testConfig.getDueDate(),testConfig.getDateTimeToTest(),testConfig.getStatus(),courseBean));
            }
        }
        return testConfigBeenList;
    }



}
