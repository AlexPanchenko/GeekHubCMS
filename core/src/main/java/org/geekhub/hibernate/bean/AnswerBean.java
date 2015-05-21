package org.geekhub.hibernate.bean;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by helldes on 19.05.2015.
 */
public class AnswerBean {

    private int id;

    @NotBlank(message = "Text should be not empty")
    private String answerText;

    @NotNull(message = "Status should be not null")
    private Boolean answerRight;

    public AnswerBean(int id, String answerText, Boolean answerRight) {
        this.id = id;
        this.answerText = answerText;
        this.answerRight = answerRight;
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
}
