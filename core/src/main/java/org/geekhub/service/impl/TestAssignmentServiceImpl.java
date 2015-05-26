package org.geekhub.service.impl;

import org.geekhub.hibernate.bean.TestAssignmentBean;
import org.geekhub.hibernate.dao.TestAssignmentDao;
import org.geekhub.hibernate.entity.TestAssignment;
import org.geekhub.hibernate.entity.TestConfig;
import org.geekhub.hibernate.entity.TestStatusAssignment;
import org.geekhub.hibernate.entity.User;
import org.geekhub.service.TestAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by helldes on 21.05.2015.
 */
@Service
@Transactional
public class TestAssignmentServiceImpl implements TestAssignmentService {

    @Autowired
    TestAssignmentDao testAssignmentDao;

    @Override
    public List<TestAssignmentBean> getTAByUserAndCourse(int courseId) {
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
}
