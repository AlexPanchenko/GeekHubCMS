package org.geekhub.service.impl;

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

    public List<Question> getAll() {
        return questionDao.getAll();
    }

    @Override
    public void create(Question question) {
        questionDao.create(question);
    }

    @Override
    public Object read(int questionId) {
        return questionDao.read(questionId, Question.class);
    }

    @Override
    public void update(Question question) {
        questionDao.update(question);
    }
}
