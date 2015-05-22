package org.geekhub.hibernate.bean;

import org.geekhub.hibernate.entity.Question;
import org.geekhub.hibernate.entity.TestAssignment;
import org.geekhub.hibernate.entity.User;
import org.geekhub.hibernate.entity.UserAnswers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 22.05.2015.
 */
public class UserResultsBean {
    private int id;
    private UserBean userBean;
    List<UserAnswersBean> userAnswersesBean = new ArrayList<>();
    private QuestionBean questionBean;
    private TestAssignmentBean testAssignmentBean;

    public UserResultsBean() {
    }

    public UserResultsBean(int id, UserBean userBean, QuestionBean questionBean, TestAssignmentBean testAssignmentBean) {
        this.id = id;
        this.userBean = userBean;
        this.questionBean = questionBean;
        this.testAssignmentBean = testAssignmentBean;
    }

    public TestAssignmentBean getTestAssignmentBean() {
        return testAssignmentBean;
    }

    public void setTestAssignmentBean(TestAssignmentBean testAssignmentBean) {
        this.testAssignmentBean = testAssignmentBean;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public List<UserAnswersBean> getUserAnswersesBean() {
        return userAnswersesBean;
    }

    public void setUserAnswersesBean(List<UserAnswersBean> userAnswersesBean) {
        this.userAnswersesBean = userAnswersesBean;
    }

    public QuestionBean getQuestionBean() {
        return questionBean;
    }

    public void setQuestionBean(QuestionBean questionBean) {
        this.questionBean = questionBean;
    }
}
