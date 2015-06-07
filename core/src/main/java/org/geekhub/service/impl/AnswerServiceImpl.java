package org.geekhub.service.impl;

import org.geekhub.hibernate.dao.AnswerDao;
import org.geekhub.hibernate.dao.QuestionDao;
import org.geekhub.hibernate.entity.Answer;
import org.geekhub.hibernate.entity.Question;
import org.geekhub.hibernate.entity.UserAnswers;
import org.geekhub.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by helldes on 15.05.2015.
 */
@Service
@Transactional
public class AnswerServiceImpl implements AnswerService{

    @Autowired
    private AnswerDao answerDao;

    @Autowired
    private QuestionDao questionDao;

    public List<Answer> getAnswersByQuestion(int questionId){

        return answerDao.getAnswersByQuestion((Question)answerDao.read(questionId,Question.class));
    }

    @Override
    public UserAnswers getUserAnswerById(int answerId) {
        return (UserAnswers) answerDao.read(answerId,UserAnswers.class);
    }


    @Override
    public Object read(int answerId) {
        return answerDao.read(answerId,Answer.class);
    }

    @Override
    public void create(int questionId, String answerText, Boolean answerRight) {
        Answer answer = new Answer();
        answer.setAnswerText(answerText);
        answer.setAnswerRight(answerRight);
        answer.setQuestion((Question)questionDao.read(questionId, Question.class));
        answerDao.create(answer);
    }

    @Override
    public void delete(int answerId) {
        answerDao.delete((Answer)answerDao.read(answerId, Answer.class));
    }

    @Override
    public void update(int answerId, String answerText, Boolean answerRight) {
        Answer answer = (Answer)answerDao.read(answerId,Answer.class);
        answer.setAnswerText(answerText);
        answer.setAnswerRight(answerRight);
        answerDao.update(answer);
    }


}
