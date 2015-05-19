package org.geekhub.hibernate.bean;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by helldes on 19.05.2015.
 */
public class QuestionBean {
    private int id;

    @NotBlank(message = "Text should be not empty")
    private String questionText;

    @NotNull(message = "Weight should be not empty")
    private Byte questionWeight;

    @NotBlank(message = "Title should be not empty")
    private String questionTitle;

    @NotNull(message = "Status should be not empty")
    private Boolean questionStatus;

    private Set<AnswerBean> answers = new HashSet<>();

    public QuestionBean(){}

    public QuestionBean(int id, String questionText, Byte questionWeight, String questionTitle, Boolean questionStatus) {
        this.id = id;
        this.questionText = questionText;
        this.questionWeight = questionWeight;
        this.questionTitle = questionTitle;
        this.questionStatus = questionStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Byte getQuestionWeight() {
        return questionWeight;
    }

    public void setQuestionWeight(Byte questionWeight) {
        this.questionWeight = questionWeight;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public Boolean getQuestionStatus() {
        return questionStatus;
    }

    public void setQuestionStatus(Boolean questionStatus) {
        this.questionStatus = questionStatus;
    }

    public Set<AnswerBean> getUsers() {
        return answers;
    }

    public void setUsers(Set<AnswerBean> users) {
        this.answers = answers;
    }
}
