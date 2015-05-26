package org.geekhub.service.impl;

import org.geekhub.hibernate.bean.TestInfo;
import org.geekhub.hibernate.dao.AnswerDao;
import org.geekhub.hibernate.dao.TestConfigDao;
import org.geekhub.hibernate.dao.UserAnswersDao;
import org.geekhub.hibernate.dao.UserResultsDao;
import org.geekhub.hibernate.entity.*;
import org.geekhub.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by admin on 26.05.2015.
 */
@Service
@Transactional
public class TestResultServiceImpl implements TestResultService {

    @Autowired
    private UserService userService;

    @Autowired
    private TestAssignmentService testAssignmentService;

    @Autowired
    private TestConfigDao testConfigDao;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerDao answerDao;

    @Autowired
    private UserResultsDao userResultsDao;

    @Autowired
    private UserAnswersDao userAnswersDao;

    @Override
    public void parseResult(TestInfo[] testInfos, int testConfigId) {
        User user = userService.getLogInUser();
        TestAssignment testAssignment = testAssignmentService.getTestAssignmentByTestConfigAdnUser((TestConfig) testConfigDao.read(testConfigId, TestConfig.class), user);
        testAssignment.setDatePassed(new Date());
        testAssignment.setTestStatusAssignment(TestStatusAssignment.PASSED);
        for(TestInfo testInfo: testInfos){
            UserResults userResults = new UserResults();
            userResults.setQuestion((Question) questionService.read(testInfo.getQuestionId()));
            userResults.setTestAssignment(testAssignment);
            userResults.setUser(user);
            user.getTestAssignments().add(testAssignment);
            for(int i=0; i<testInfo.getAnswerArray().length; i++){
                UserAnswers userAnswers = new UserAnswers();
                userAnswers.setUserResults(userResults);
                userAnswers.setAnswer((Answer) answerDao.read(testInfo.getAnswerArray()[i], Answer.class));
                userAnswersDao.create(userAnswers);
                userResults.getUserAnswerses().add(userAnswers);
            }
            userResultsDao.create(userResults);
            testAssignment.getUserResults().add(userResults);
        }
    }
}