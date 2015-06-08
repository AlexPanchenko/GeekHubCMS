package org.geekhub.hibernate.bean;

import org.geekhub.hibernate.dao.QuestionDao;
import org.geekhub.hibernate.entity.Answer;
import org.geekhub.hibernate.entity.Question;
import org.geekhub.hibernate.entity.User;
import org.geekhub.hibernate.entity.UserAnswers;

import java.util.ArrayList;
import java.util.List;

public class TestResWrapper {
    private int testAssignmentId;
    private Question question;
    private List<UserAnswers> userAnswers;
    private boolean isRight;
    private int score;
    private boolean review;

    public boolean getReview() {
        return review;
    }

    public void setReview(boolean review) {
        this.review = review;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<UserAnswers> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(List<UserAnswers> userAnswers) {
        this.userAnswers = userAnswers;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean isRight) {
        this.isRight = isRight;
    }

    public int getTestAssignmentId() {
        return testAssignmentId;
    }

    public void setTestAssignmentId(int testAssignmentId) {
        this.testAssignmentId = testAssignmentId;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

}
