package org.geekhub.service.impl;

import org.geekhub.hibernate.dao.QuestionDao;
import org.geekhub.hibernate.dao.UserDao;
import org.geekhub.hibernate.dao.UserResultsDao;
import org.geekhub.hibernate.entity.Question;
import org.geekhub.hibernate.entity.User;
import org.geekhub.hibernate.entity.UserResults;
import org.geekhub.service.UserResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by user on 20.05.2015.
 */
@Service
@Transactional
public class UserResultsServiceImpl implements UserResultsService {

    @Autowired
    UserResultsDao userResultsDao;

    @Autowired
    UserDao userDao;

    @Autowired
    QuestionDao questionDao;

    @Override
    public Object read(int userResultId) {
        return userResultsDao.read(userResultId, UserResults.class);
    }

    @Override
    public void update(UserResults userResult) {
        userResultsDao.update(userResult);
    }

    @Override
    public void delete(int userResultId) {
        userResultsDao.delete(userResultsDao.read(userResultId, UserResults.class));
    }

    @Override
    public UserResults create(int userId, int questionId) {
        UserResults userResults = new UserResults();
        userResults.setUser((User)userDao.read(userId, User.class));
        userResults.setQuestion((Question)questionDao.read(questionId, Question.class));
        userResultsDao.create(userResults);
        return userResults;
    }
}
