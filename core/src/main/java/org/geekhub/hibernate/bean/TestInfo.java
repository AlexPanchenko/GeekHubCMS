package org.geekhub.hibernate.bean;

/**
 * Created by admin on 25.05.2015.
 */
public class TestInfo {
    private int questionId;
    private String customAnswer;
    private int[] answersArray;

    public int[] getAnswersArray() {
        return answersArray;
    }

    public void setAnswersArray(int[] answersArray) {
        this.answersArray = answersArray;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getCustomAnswer() {
        return customAnswer;
    }

    public void setCustomAnswer(String customAnswer) {
        this.customAnswer = customAnswer;
    }
}
