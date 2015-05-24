package org.geekhub.service.impl;

import org.geekhub.hibernate.bean.QuestionBean;
import org.geekhub.hibernate.dao.CourseDao;
import org.geekhub.hibernate.dao.QuestionDao;
import org.geekhub.hibernate.entity.Question;
import org.geekhub.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by helldes on 15.05.2015.
 */
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    QuestionDao questionDao;

    @Autowired
    CourseDao courseDao;

    public List<Question> getAll() {
        return (List<Question>)questionDao.getAll();
    }


    @Override
    public Question read(int questionId) {
        Question question = (Question)questionDao.read(questionId, Question.class);
        return question;
    }

    @Override
    public void update(QuestionBean questionBean) {
        Question question = (Question) questionDao.read(questionBean.getId(), Question.class);
        question.setQuestionText(questionBean.getQuestionText());
        question.setQuestionWeight(questionBean.getQuestionWeight());
        question.setCourse(courseDao.getCourseById(questionBean.getCourse()));
        question.setMyAnswer(questionBean.getMyAnswer());
        question.setQuestionStatus(questionBean.getQuestionStatus());
        questionDao.update(question);
    }

    @Override
    public void delete(int questionId) {
        questionDao.delete(questionDao.read(questionId, Question.class));
    }

    @Override
    public int create(QuestionBean questionBean) {
        Question question = new Question();
        question.setQuestionText(questionBean.getQuestionText());
        question.setQuestionWeight(questionBean.getQuestionWeight());
        question.setCourse(courseDao.getCourseById(questionBean.getCourse()));
        question.setMyAnswer(questionBean.getMyAnswer());
        question.setQuestionStatus(questionBean.getQuestionStatus());
        questionDao.create(question);
        return question.getId();
    }

}
