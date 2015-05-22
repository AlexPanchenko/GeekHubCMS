package org.geekhub.hibernate.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by helldes on 14.05.2015.
 */
@Entity
@Table(name = "ANSWERS")
public class Answer extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "ANSWER_ID", unique = true, nullable = false)
    private int id;

    @Column(name = "ANSWER_TEXT", unique = true, nullable = false)
    @NotBlank(message = "Answer text should be not empty")
    private String answerText;

    @Column(name = "ANSWER_RIGHT", nullable = false)
    @NotNull(message = "Right answer should be not empty")
    private Boolean answerRight;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    @OneToMany(mappedBy="answer",cascade = CascadeType.ALL)
    List<UserAnswers> userAnswers = new ArrayList<>();

    public Answer(){
    }

    public List<UserAnswers> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(List<UserAnswers> userAnswers) {
        this.userAnswers = userAnswers;
    }

    public Boolean getAnswerRight() {
        return answerRight;
    }

    public void setAnswerRight(Boolean answerRight) {
        this.answerRight = answerRight;
    }

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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
