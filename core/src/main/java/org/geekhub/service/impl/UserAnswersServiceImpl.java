package org.geekhub.service.impl;

import org.geekhub.hibernate.dao.AnswerDao;
import org.geekhub.hibernate.dao.UserAnswersDao;
import org.geekhub.hibernate.dao.UserResultsDao;
import org.geekhub.hibernate.entity.Answer;
import org.geekhub.hibernate.entity.UserAnswers;
import org.geekhub.hibernate.entity.UserResults;
import org.geekhub.service.UserAnswersService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by user on 20.05.2015.
 */
public class UserAnswersServiceImpl implements UserAnswersService {

    @Autowired
    UserAnswersDao userAnswersDao;

    @Autowired
    UserResultsDao userResultsDao;

    @Autowired
    AnswerDao answerDao;

    @Override
    public Object read(int userAnswersId) {
        return userAnswersDao.read(userAnswersId, UserAnswers.class);
    }

    @Override
    public void update(UserAnswers userAnswers) {
        userAnswersDao.update(userAnswers);

    }

    @Override
    public void delete(int userAnswersId) {
        userAnswersDao.delete(userAnswersDao.read(userAnswersId, UserAnswers.class));
    }

    @Override
    public UserAnswers create(int userResultId, int answerId) {
        UserAnswers userAnswers = new UserAnswers();
        userAnswers.setUserResults((UserResults)userResultsDao.read(userResultId, UserResults.class));
        userAnswersDao.create(userAnswers);
        return userAnswers;
    }
}
