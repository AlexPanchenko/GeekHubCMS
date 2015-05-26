package org.geekhub.service;

import org.geekhub.hibernate.bean.TestAssignmentBean;
import org.geekhub.hibernate.entity.TestAssignment;
import org.geekhub.hibernate.entity.TestConfig;
import org.geekhub.hibernate.entity.User;

import java.util.List;

/**
 * Created by helldes on 21.05.2015.
 */
public interface TestAssignmentService {
    public List<TestAssignmentBean> getTAByUserAndCourse(int courseId);
    public TestAssignment getTestAssignmentByTestConfigAdnUser(TestConfig testConfig, User user);
    Object read(int testAssignmentId);
    void delete(int testAssignmentId);
    int create(TestAssignmentBean testAssignmentBean);
    void update(TestAssignmentBean testAssignmentBean);

    TestAssignment getTestAssignmentBeanByTestConfigAdnUser(int testConfigId);
}
