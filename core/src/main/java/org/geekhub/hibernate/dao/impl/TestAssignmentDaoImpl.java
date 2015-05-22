package org.geekhub.hibernate.dao.impl;

import org.geekhub.hibernate.dao.TestAssignmentDao;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.TestAssignment;
import org.geekhub.hibernate.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by helldes on 21.05.2015.
 */
@Repository
public class TestAssignmentDaoImpl extends BaseDaoImpl implements TestAssignmentDao {

    @Override
    public List<TestAssignment> getTAByUserAndCourse(Course course, User user) {
        return null;
    }
}
