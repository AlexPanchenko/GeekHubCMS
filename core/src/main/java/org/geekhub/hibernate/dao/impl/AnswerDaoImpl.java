package org.geekhub.hibernate.dao.impl;

import org.geekhub.hibernate.dao.AnswerDao;
import org.geekhub.hibernate.entity.Answer;
import org.geekhub.hibernate.entity.Question;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by helldes on 15.05.2015.
 */
@Repository("answerDao")
public class AnswerDaoImpl extends BaseDaoImpl implements AnswerDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Answer> getAnswersByQuestion(Question question) {
        return (List<Answer>)sessionFactory.getCurrentSession().createCriteria(Answer.class).add(Restrictions.eq("question", question)).list();
    }
}
