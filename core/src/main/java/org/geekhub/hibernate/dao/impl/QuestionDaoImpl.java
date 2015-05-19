package org.geekhub.hibernate.dao.impl;

import org.geekhub.hibernate.dao.QuestionDao;
import org.geekhub.hibernate.entity.Question;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by helldes on 15.05.2015.
 */
@Repository("questionDao")
public class QuestionDaoImpl extends BaseDaoImpl implements QuestionDao{

    @Override
    public List<Question> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(Question.class).list();
    }
}
