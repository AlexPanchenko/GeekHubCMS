package org.geekhub.hibernate.bean;

import org.geekhub.hibernate.entity.Question;

public class AnswerBean {

    private int id;

    private String answerText;

    private Boolean answerRight;

    private Question question;

    public AnswerBean(int id, String answerText, Boolean answerRight, Question question) {
        this.id = id;
        this.answerText = answerText;
        this.answerRight = answerRight;
        this.question = question;
    }

    public AnswerBean(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public Boolean getAnswerRight() {
        return answerRight;
    }

    public void setAnswerRight(Boolean answerRight) {
        this.answerRight = answerRight;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
