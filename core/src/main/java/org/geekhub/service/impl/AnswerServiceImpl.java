package org.geekhub.service.impl;

import org.geekhub.hibernate.dao.AnswerDao;
import org.geekhub.hibernate.entity.Answer;
import org.geekhub.hibernate.entity.Question;
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

    public List<Answer> getAnswersByQuestion(Question question){
        return answerDao.getAnswersByQuestion(question);
    }

    @Override
    public Object read(int answerId) {
        return answerDao.read(answerId,Answer.class);
    }

    @Override
    public void create(Answer obj) {
        answerDao.create(obj);
    }

    @Override
    public void delete(Object read) {

    }
}
