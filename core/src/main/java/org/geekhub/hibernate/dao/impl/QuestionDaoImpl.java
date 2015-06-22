package org.geekhub.hibernate.dao.impl;

import org.geekhub.hibernate.dao.QuestionDao;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.Question;
import org.geekhub.hibernate.entity.TestType;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("questionDao")
@SuppressWarnings("unchecked")
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

    @Override
    public Question getQuestionWithId(Question question) {
        return (Question) sessionFactory.getCurrentSession().createCriteria(Question.class).add(Restrictions.eq("questionText", question.getQuestionText()))
                .add(Restrictions.eq("questionWeight", question.getQuestionWeight())).add(Restrictions.eq("questionStatus", question.getQuestionStatus()))
                .add(Restrictions.eq("myAnswer", question.getMyAnswer())).add(Restrictions.eq("questionCode", question.getQuestionCode())).uniqueResult();
    }

    @Override
    public Long getQuestionsCount() {
        Long questionCount = (Long) sessionFactory.getCurrentSession().createCriteria(Question.class)
                .setProjection(Projections.rowCount())
                .uniqueResult();
        return questionCount;
    }

    @Override
    public List<Question> getQuestionsOnOnePage(int pageIndex, int offset) {
        return sessionFactory.getCurrentSession().createCriteria(Question.class).setFirstResult((pageIndex - 1) * offset).setMaxResults(offset).list();
    }

    @Override
    public void saveOrUpdate(Question question) {
         sessionFactory.getCurrentSession().saveOrUpdate(question);
    }


}
