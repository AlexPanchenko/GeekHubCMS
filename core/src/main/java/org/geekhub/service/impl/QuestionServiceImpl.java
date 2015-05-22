package org.geekhub.service.impl;

import org.geekhub.hibernate.dao.CourseDao;
import org.geekhub.hibernate.dao.QuestionDao;
import org.geekhub.hibernate.entity.Course;
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
    public Question create(String questionText, Byte questionWeight, Boolean questionStatus, Boolean myAnswer, Boolean manyAnswers, int courseId) {
        Question question = new Question();
        question.setQuestionWeight(questionWeight);
        question.setQuestionStatus(questionStatus);
       question.setMyAnswer(myAnswer);
        question.setManyAnswers(manyAnswers);
       question.setCourse((Course) courseDao.read(courseId, Course.class));
        questionDao.create(question);
        return question;
    }

    @Override
    public Object read(int questionId) {
        return questionDao.read(questionId, Question.class);
    }

    @Override
    public void update(int questionId, String questionText, byte questionWeight) {
        Question question = (Question) questionDao.read(questionId, Question.class);
        question.setQuestionText(questionText);
        question.setQuestionWeight(questionWeight);
        questionDao.update(question);
    }

    @Override
    public void delete(int questionId) {
        questionDao.delete(questionDao.read(questionId, Question.class));
    }

}
