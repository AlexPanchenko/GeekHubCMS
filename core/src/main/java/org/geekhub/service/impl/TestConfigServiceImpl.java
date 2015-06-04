package org.geekhub.service.impl;

import org.geekhub.hibernate.bean.CourseBean;
import org.geekhub.hibernate.bean.TestConfigBeen;
import org.geekhub.hibernate.dao.CourseDao;
import org.geekhub.hibernate.dao.TestConfigDao;
import org.geekhub.hibernate.entity.*;
import org.geekhub.service.BeanService;
import org.geekhub.service.CourseService;
import org.geekhub.service.TestAssignmentService;
import org.geekhub.service.TestConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class TestConfigServiceImpl implements TestConfigService {
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private CourseService courseService;
    @Autowired
    private TestConfigDao testConfigDao;
    @Autowired
    private BeanService beanService;

    @Autowired
    private TestAssignmentService testAssignmentService;

    @Override
    public TestConfigBeen getTestConfigById(int testConfigId) {
        TestConfig testConfig = (TestConfig) testConfigDao.read(testConfigId, TestConfig.class);

        return toBeen(testConfig);
    }

    @Override
    public TestConfig getTestConfigByID(int testConfigId) {
        return (TestConfig) testConfigDao.read(testConfigId, TestConfig.class);
    }

    public TestConfigBeen toBeen(TestConfig testConfig) {
        TestConfigBeen testConfigBeen = new TestConfigBeen(testConfig.getId(),
                testConfig.getTitle(),
                testConfig.getQuestionCount(),
                testConfig.getDateStart(),
                testConfig.getDateFinish(),
                testConfig.getTimeToTest(),
                testConfig.getStatus());
        return testConfigBeen;
    }

    public TestConfigBeen getTestConfigBeen(int courseId) {
        Course course = (Course) courseDao.read(courseId, Course.class);
        CourseBean courseBean = courseService.toBean(course);
        TestConfig testConfig = course.getTestConfig();

        TestConfigBeen testConfigBeen = (new TestConfigBeen(testConfig.getTitle(),
                    testConfig.getQuestionCount(),
                    testConfig.getDateStart(),
                    testConfig.getDateFinish(),
                    testConfig.getTimeToTest(),
                    testConfig.getStatus(),
                    courseBean));
        return testConfigBeen;
    }

    @Override
    public void createTestConfig(TestConfigBeen testConfigBeen) {
        TestConfig testConfig = new TestConfig();
        testConfig.setTitle(testConfigBeen.getTittle());
        testConfig.setQuestionCount(testConfigBeen.getQuestionCount());
        testConfig.setDateStart(testConfigBeen.getDateStart());
        testConfig.setDateFinish(testConfigBeen.getDateFinish());
        testConfig.setTimeToTest(testConfigBeen.getTimeToTest());
        testConfig.setStatus(testConfigBeen.getStatus());
        Course course = (Course)courseDao.read(testConfigBeen.getCourseBean().getId(),Course.class);
        testConfig.setCourse(course);
        testConfigDao.create(testConfig);
        //course.getTestConfig().add(testConfig);
        courseDao.update(course);
    }

    @Override
    public void createTestConfig(TestConfig testConfig) {
        testConfig.setCourse(null);
        testConfigDao.create(testConfig);
    }

    @Override
    public void update(TestConfigBeen testConfigBeen) {
        TestConfig testConfig = (TestConfig) testConfigDao.read(testConfigBeen.getId(), TestConfig.class);
        testConfig.setQuestionCount(testConfigBeen.getQuestionCount());
        testConfig.setTimeToTest(testConfigBeen.getTimeToTest());
        testConfig.setDateStart(testConfigBeen.getDateStart());
        testConfig.setDateFinish(testConfigBeen.getDateFinish());
        testConfig.setTitle(testConfigBeen.getTittle());
        testConfig.setStatus(testConfig.getStatus());
        testConfigDao.update(testConfig);
    }

    @Override
    public void delete(TestConfigBeen testConfigBeen) {
        TestConfig testConfig = (TestConfig)testConfigDao.read(testConfigBeen.getId(), TestConfig.class);
        testConfigDao.delete(testConfig);
    }

    @Override
    public void deleteById(int id) {
        TestConfig testConfig = (TestConfig) testConfigDao.read(id, TestConfig.class);
        if(testConfig.getTestType() != null) {
            testConfig.getTestType().getTestConfigList().remove(testConfig);
        }
        List<TestAssignment> testAssignmentList = testAssignmentService.getTestAssignmentListByTestConfig(testConfig);
        if(testAssignmentList != null) {
                Iterator<TestAssignment> iterator = testAssignmentList.iterator();
                while (iterator.hasNext()){
                    TestAssignment testAssignment = iterator.next();
                    iterator.remove();
                    testAssignmentService.delete(testAssignment);
            }
        }
        testConfigDao.update(testConfig);
        testConfigDao.delete(testConfig);
    }

    public TestConfigBeen getTestConfigBeenEnable(int courseId) {
        Course course = (Course) courseDao.read(courseId, Course.class);
        CourseBean courseBean = courseService.toBean(course);
        TestConfig testConfig = course.getTestConfig();

        TestConfigBeen testConfigBeen = new TestConfigBeen();
        if (testConfig.getStatus().equals(TestStatus.ACTIVE)) {
            testConfigBeen= new TestConfigBeen(testConfig.getId(),
                        testConfig.getTitle(),
                        testConfig.getQuestionCount(),
                        testConfig.getDateStart(),
                        testConfig.getDateFinish(),
                        testConfig.getTimeToTest(),
                        testConfig.getStatus(),
                        courseBean);
        }
        return testConfigBeen;
    }

    @Override
    public TestConfigBeen getTestConfigBeensEnable(int courseId) {
        return null;
    }

    @Override
    public TestConfig getTestConfigByCource(Course course) {
        return testConfigDao.getTestConfigByCourse(course);
    }

    @Override
    public List<TestConfig> getAll() {
        return testConfigDao.getAll();
    }

    @Override
    public void updateByParams(int id, String title, int questionCount, Date dateStart, Date dateFinish, int timeToTest, TestStatus status, TestType testType) {
        TestConfig testConfig = (TestConfig) testConfigDao.read(id, TestConfig.class);
        testConfig.setTitle(title);
        testConfig.setQuestionCount(questionCount);
        testConfig.setDateFinish(dateFinish);
        testConfig.setDateStart(dateStart);
        testConfig.setTimeToTest(timeToTest);
        testConfig.setStatus(status);
        testConfig.setTestType(testType);
        testConfigDao.update(testConfig);
    }

}
