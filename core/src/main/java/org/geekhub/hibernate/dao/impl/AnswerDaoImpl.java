package org.geekhub.hibernate.dao.impl;

import org.geekhub.hibernate.dao.AnswerDao;
import org.geekhub.hibernate.entity.Answer;
import org.geekhub.hibernate.entity.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("answerDao")
public class AnswerDaoImpl extends BaseDaoImpl implements AnswerDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Answer> getAnswersByQuestion(Question question) {
        return (List<Answer>)sessionFactory.getCurrentSession().createCriteria(Answer.class).add(Restrictions.eq("question", question)).list();
    }

    @Override
    public void saveOrUpdate(Answer answer) {
        sessionFactory.getCurrentSession().saveOrUpdate(answer);
    }

    @Override
    public void delete(List<Integer> answerIdsToDelete) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        String hqlDelete = "delete Answer where id = :id";

        for(Integer each : answerIdsToDelete) {
            session.createQuery( hqlDelete )
                    .setInteger("id", each)
                    .executeUpdate();
        }
        tx.commit();
        session.close();
    }
}
