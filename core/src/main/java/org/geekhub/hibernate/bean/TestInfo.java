package org.geekhub.hibernate.bean;

/**
 * Created by admin on 25.05.2015.
 */
public class TestInfo {
    private int questionId;
    private int[] answerArray;

    public int[] getAnswerArray() {
        return answerArray;
    }

    public void setAnswerArray(int[] answerArray) {
        this.answerArray = answerArray;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
}
