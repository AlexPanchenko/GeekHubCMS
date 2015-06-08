package org.geekhub.hibernate.dao.impl;

import org.geekhub.hibernate.dao.TestTypeDao;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.TestAssignment;
import org.geekhub.hibernate.entity.TestType;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 27.05.2015.
 */
@Repository
public class TestTypeDaoImpl extends BaseDaoImpl implements TestTypeDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<TestType> getList() {
        return (List<TestType> )sessionFactory.getCurrentSession().createCriteria(TestType.class).list();
    }

    @Override
    public List<TestType> getListByCource(Course course) {
        return sessionFactory.getCurrentSession().createCriteria(TestType.class).add(Restrictions.eq("course", course)).list();
    }

    @Override
    public boolean isRemovable(TestType testType) {

        return sessionFactory.getCurrentSession().createCriteria(TestAssignment.class).createAlias("testConfig", "tC").createAlias("tC.testType", "tT")
                .add(Restrictions.eq("tT.id", testType.getId())).list().isEmpty();
    }
}
