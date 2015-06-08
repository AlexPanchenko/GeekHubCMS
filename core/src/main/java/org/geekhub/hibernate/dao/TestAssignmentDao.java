package org.geekhub.hibernate.dao;

import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.TestAssignment;
import org.geekhub.hibernate.entity.TestConfig;
import org.geekhub.hibernate.entity.User;

import java.util.List;

/**
 * Created by helldes on 21.05.2015.
 */
public interface TestAssignmentDao extends BaseDao {
    public TestAssignment getTestAssignmentByUserId(int userId);
    List<TestAssignment> getTestAssignmentByUserAndCourse(Course course, User user);
    List<TestAssignment> getTestAssignmentByCourse(int courseId);
    TestAssignment getTestAssignmentByTestConfigAndUser(TestConfig testConfig, User user);
    public List<TestAssignment> getAvailableTestAssignmentByUser(User user);
    public List<TestAssignment> getTestAssignmentListByTestConfig(TestConfig testConfig);
    public List<TestAssignment> getAll();
    public List<TestAssignment> getOverdueTestAssignmentList();
}
