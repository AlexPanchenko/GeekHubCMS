package org.geekhub.hibernate.dao.impl;

import org.geekhub.hibernate.dao.QuestionDao;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.Question;
import org.geekhub.hibernate.entity.TestType;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by helldes on 15.05.2015.
 */
@Repository("questionDao")
public class QuestionDaoImpl extends BaseDaoImpl implements QuestionDao{

    @Override
    public List<Question> getByCourse(Course course) {
        return sessionFactory.getCurrentSession().createCriteria(Question.class).add(Restrictions.eq("course", course)).list();
    }

    @Override
    public List<Question> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(Question.class).list();
    }

    @Override
    public List<Question> getByTestType(TestType testType) {
        return sessionFactory.getCurrentSession().createCriteria(Question.class).add(Restrictions.eq("testType", testType)).list();
    }

    @Override
    public List<Question> getByCourseWithoutTestType(Course course) {
        return sessionFactory.getCurrentSession().createCriteria(Question.class)
                .add(Restrictions.eq("course", course))
                .add(Restrictions.isNull("testType")).list();
    }
}
