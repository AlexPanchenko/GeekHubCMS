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
    List<TestAssignment> getTestAssignmentByUserAndCourse(Course course, User user);
    TestAssignment getTestAssignmentByTestConfigAdnUser(TestConfig testConfig, User user);

}
