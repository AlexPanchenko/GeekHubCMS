package org.geekhub.hibernate.dao.impl;

import org.geekhub.hibernate.dao.TestAssignmentDao;
import org.geekhub.hibernate.dao.TestConfigDao;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.TestAssignment;
import org.geekhub.hibernate.entity.TestConfig;
import org.geekhub.hibernate.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by helldes on 21.05.2015.
 */
@Repository
public class TestAssignmentDaoImpl extends BaseDaoImpl implements TestAssignmentDao {

    @Autowired
    private TestConfigDao testConfigDao;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public TestAssignment getTestAssignmentByUserId(int userId) {
        return (TestAssignment) sessionFactory.getCurrentSession().createCriteria(TestAssignment.class).createAlias("user","us").add(Restrictions.eq("us.id",userId)).list().get(0);
    }

    @Override
    public List<TestAssignment> getTestAssignmentByUserAndCourse(Course course, User user) {
        return null;
    }

    @Override
    public List<TestAssignment> getTestAssignmentByCourse(int courseId) {
        return sessionFactory.getCurrentSession().createCriteria(TestAssignment.class).createAlias("testConfig","tCon").
                createAlias("course","cour").add(Restrictions.eq("tCon.cour.id",courseId)).list();
    }

    @Override
    public TestAssignment getTestAssignmentByTestConfigAndUser(TestConfig testConfig, User user) {

        return (TestAssignment) sessionFactory.getCurrentSession().createCriteria(TestAssignment.class)
                .add(Restrictions.eq("testConfig", testConfig)).add(Restrictions.eq("user", user)).uniqueResult();
    }
}
