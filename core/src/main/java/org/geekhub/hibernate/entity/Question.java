package org.geekhub.hibernate.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by helldes on 14.05.2015.
 */

@Entity
@Table(name = "QUESTIONS")
public class Question extends BaseEntity implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "QUESTION_ID", unique = true, nullable = false)
    private int id;

    @Column(name = "QUESTION_TEXT", unique = true, nullable = false)
    @NotBlank(message = "Question text should be not empty")
    private String questionText;

    @Column(name = "QUESTION_WEIGTH", nullable = false)
    @NotNull(message = "Question weight should be not empty")
    private Byte questionWeight;

    @Column(name = "COURSE_ID", nullable = false)
    @NotNull(message = "COURSE ID should be not empty")
    private int courseId;

    @OneToMany(mappedBy="question")
    private Set<Answer> answers;

    public Question() {
    }

    public Byte getQuestionWeight() {
        return questionWeight;
    }

    public void setQuestionWeight(Byte questionWeight) {
        this.questionWeight = questionWeight;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
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
}
