package org.geekhub.hibernate.dao.impl;

import org.geekhub.hibernate.dao.TestAssignmentDao;
import org.geekhub.hibernate.dao.TestConfigDao;
import org.geekhub.hibernate.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
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

    @Override
    public List<TestAssignment> getAvailableTestAssignmentByUser(User user) {
        return sessionFactory.getCurrentSession().createCriteria(TestAssignment.class)
                .add(Restrictions.eq("user", user))
                .add(Restrictions.not(Restrictions.eq("testStatusAssignment", TestStatusAssignment.PASSED)))
                .add(Restrictions.not(Restrictions.eq("testStatusAssignment", TestStatusAssignment.OVERDUE))).list();
    }

    @Override
    public List<TestAssignment> getTestAssignmentListByTestConfig(TestConfig testConfig) {
        return sessionFactory.getCurrentSession().createCriteria(TestAssignment.class).add(Restrictions.eq("testConfig", testConfig)).list();
    }

    @Override
    public List<TestAssignment> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(TestAssignment.class).list();
    }

    @Override
    public List<TestAssignment> getOverdueTestAssignmentList() {
        return sessionFactory.getCurrentSession().createCriteria(TestAssignment.class)
                .add(Restrictions.not(Restrictions.eq("testStatusAssignment", TestStatusAssignment.PASSED)))
                .add(Restrictions.not(Restrictions.eq("testStatusAssignment", TestStatusAssignment.OVERDUE)))
                .add(Restrictions.lt("dateFinish", new Date())).list();
    }

}
