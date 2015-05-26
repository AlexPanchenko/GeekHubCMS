package org.geekhub.service.impl;

import org.geekhub.hibernate.bean.TestInfo;
import org.geekhub.hibernate.dao.AnswerDao;
import org.geekhub.hibernate.dao.TestConfigDao;
import org.geekhub.hibernate.entity.*;
import org.geekhub.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 26.05.2015.
 */
@Service
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
    private UserAnswersService userAnswersService;

    @Autowired
    private AnswerDao answerDao;

    @Override
    public void parseResult(TestInfo[] testInfos, int testConfigId) {
        User user = userService.getLogInUser();
        TestAssignment testAssignment = testAssignmentService.getTestAssignmentByTestConfigAdnUser((TestConfig) testConfigDao.read(testConfigId, TestConfig.class), user);
        for(TestInfo testInfo: testInfos){
            UserResults userResults = new UserResults();
            userResults.setQuestion((Question) questionService.read(testInfo.getQuestionId()));
            for(int i=0; i<testInfo.getAnswerArray().length; i++){
                UserAnswers userAnswers = new UserAnswers();
                userAnswers.setUserResults(userResults);
                userAnswers.setAnswer((Answer) answerDao.read(testInfo.getAnswerArray()[i], Answer.class));
                userResults.getUserAnswerses().add(userAnswers);
            }
            testAssignment.getUserResults().add(userResults);
        }
    }
}
