package org.geekhub.service.impl;

import org.geekhub.hibernate.bean.TestAssignmentBean;
import org.geekhub.hibernate.dao.TestAssignmentDao;
import org.geekhub.hibernate.dao.TestConfigDao;
import org.geekhub.hibernate.entity.TestAssignment;
import org.geekhub.hibernate.entity.TestConfig;
import org.geekhub.hibernate.entity.TestStatusAssignment;
import org.geekhub.hibernate.entity.User;
import org.geekhub.service.TestAssignmentService;
import org.geekhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by helldes on 21.05.2015.
 */
@Service
@Transactional
public class TestAssignmentServiceImpl implements TestAssignmentService {

    @Autowired
    private TestAssignmentDao testAssignmentDao;

    @Autowired
    TestConfigDao testConfigDao;

    @Autowired
    UserService userService;

    @Override
    public List<TestAssignmentBean> getTAByUserAndCourse(int courseId) {
        return null;
    }

    @Override
    public List<TestAssignment> getTestAsignByCourse(int courseId) {
        List<TestAssignment> testAssignments = testAssignmentDao.getTestAssignmentByCourse(courseId);
        List<TestAssignmentBean> testAssignmentBeans = new ArrayList<>();
        for (TestAssignment testAssignment: testAssignments){

        }
        return null;
    }

    @Override
    public TestAssignment getTestAssignmentByTestConfigAdnUser(TestConfig testConfig, User user) {
        return testAssignmentDao.getTestAssignmentByTestConfigAndUser(testConfig, user);
    }

    @Override
    public Object read(int testAssignmentId) {
        return testAssignmentDao.read(testAssignmentId, TestAssignment.class);
    }

    @Override
    public void delete(int testAssignmentId) {
        testAssignmentDao.delete(testAssignmentDao.read(testAssignmentId, TestAssignment.class));

    }

    @Override
    public int create(TestAssignmentBean testAssignmentBean) {
        TestAssignment testAssignment = new TestAssignment();
        testAssignment.setUser(testAssignmentBean.getUser());
        testAssignment.setTestConfig(testAssignmentBean.getTestConfig());
        testAssignment.setPassed(false);
        testAssignment.setDateStart(testAssignmentBean.getTestStart());
        testAssignment.setDateFinish(testAssignmentBean.getTestFinish());
        testAssignment.setTestStatusAssignment(TestStatusAssignment.NOT_YET_PASSING);
        testAssignmentDao.create(testAssignment);
        return testAssignment.getId();
    }

    @Override
    public void update(TestAssignmentBean testAssignmentBean) {

    }


    @Override
    public void setStatus(TestConfig testConfig, TestStatusAssignment testStatusAssignment) {
        TestAssignment testAssignment = testAssignmentDao.getTestAssignmentByTestConfigAndUser(testConfig, userService.getLogInUser());
        testAssignment.setTestStatusAssignment(testStatusAssignment);
    }


    public TestAssignment getTestAssignmentBeanByTestConfigAdnUser(int testConfigId) {
        TestConfig testConfig = (TestConfig)testConfigDao.read(testConfigId, TestConfig.class);
        TestAssignment testAssignment = testAssignmentDao.getTestAssignmentByTestConfigAndUser(testConfig, userService.getLogInUser());
        if(testConfig.getDateFinish().getTime() < new Date().getTime()){
            testAssignment.setTestStatusAssignment(TestStatusAssignment.OVERDUE);
        }
        return testAssignment;
    }

    @Override
    public void createTestAssignment(User user, TestConfig testConfig) {
        TestAssignment testAssignment = new TestAssignment();
        testAssignment.setTestConfig(testConfig);
        System.out.println();
        testAssignment.setUser(user);
        testAssignment.setDateStart(testConfig.getDateStart());
        testAssignment.setDateFinish(testConfig.getDateFinish());
        testAssignment.setTestStatusAssignment(TestStatusAssignment.NOT_YET_PASSING);
        testAssignmentDao.create(testAssignment);
    }

    @Override
     public void assignTestByUserListId(List<Integer> listId, TestConfig testConfig) {
        for(Integer id: listId){
            System.out.println(userService.getUserById(id.intValue()));
            createTestAssignment(userService.getUserById(id.intValue()), testConfig);
        }
    }

    @Override
    public void deleteTestAssignByUserAndTestConfig(User user, TestConfig testConfig) {
        testAssignmentDao.delete(testAssignmentDao.getTestAssignmentByTestConfigAndUser(testConfig, user));
    }


}
