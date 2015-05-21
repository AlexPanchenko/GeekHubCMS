package org.geekhub.hibernate.dao.impl;

import org.geekhub.hibernate.dao.QuestionDao;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.Question;
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
        return (List<Question>)sessionFactory.getCurrentSession().createCriteria(Question.class).add(Restrictions.eq("course", course));
    }

    @Override
    public List<Question> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(Question.class).list();
    }
}
