package org.geekhub.service;

import org.geekhub.hibernate.bean.TestAssignmentBean;
import org.geekhub.hibernate.entity.TestAssignment;
import org.geekhub.hibernate.entity.TestConfig;
import org.geekhub.hibernate.entity.TestStatusAssignment;
import org.geekhub.hibernate.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by helldes on 21.05.2015.
 */
@Component
public interface TestAssignmentService {
    public List<TestAssignment> getTestAsignByCourse(int courseId);
    public List<TestAssignmentBean> getTAByUserAndCourse(int courseId);
    public TestAssignment getTestAssignmentByTestConfigAdnUser(TestConfig testConfig, User user);
    Object read(int testAssignmentId);
    void delete(int testAssignmentId);
    int create(TestAssignmentBean testAssignmentBean);
    void update(TestAssignmentBean testAssignmentBean);
    public void setStatus(TestConfig testConfig, TestStatusAssignment testStatusAssignment);
    TestAssignment getTestAssignmentBeanByTestConfigAdnUser(int testConfigId);
    public void createTestAssignment(User user, TestConfig testConfig);
    public void assignTestByUserListId(List<Integer> listId, TestConfig testConfig);
    public void deleteTestAssignByUserAndTestConfig(User user, TestConfig testConfig);
}
