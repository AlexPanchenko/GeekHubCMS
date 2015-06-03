package org.geekhub.hibernate.entity;

import org.geekhub.hibernate.bean.CourseBean;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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

    @Column(name = "QUESTION_CODE")
    private String questionCode;

    @Column(name = "QUESTION_WEIGHT", nullable = false)
    @NotNull(message = "Question weight should be not empty")
    private Byte questionWeight;

    @Column(name = "QUESTION_STATUS")
    private Boolean questionStatus;

    @Column(name = "MY_ANSWER")
    private Boolean myAnswer;

    @Column(name = "MANY_ANSWERS")
    private Boolean manyAnswers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COURSE_ID", nullable = false)
    private Course course;

    @OneToMany(mappedBy="question",cascade = CascadeType.ALL)
    private Set<Answer> answers;

    @OneToMany(mappedBy="question",cascade = CascadeType.ALL)
    List<UserResults>  UserResults = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "TEST_TYPE_ID")
    private TestType testType;


    public Question(String questionText, Byte questionWeight, Boolean questionStatus, Boolean myAnswer, Boolean manyAnswers, Course course) {
        this.questionText = questionText;
        this.questionWeight = questionWeight;
        this.questionStatus = questionStatus;
        this.myAnswer = myAnswer;
        this.manyAnswers = manyAnswers;
        this.course = course;
    }

    public TestType getTestType() {
        return testType;
    }

    public void setTestType(TestType testType) {
        this.testType = testType;
    }

    public String getQuestionCode() {
        return questionCode;
    }

    public void setQuestionCode(String questionCode) {
        this.questionCode = questionCode;
    }

    public Boolean getMyAnswer() {
        return myAnswer;
    }

    public void setMyAnswer(Boolean myAnswer) {
        this.myAnswer = myAnswer;
    }

    public Boolean getManyAnswers() {
        return manyAnswers;
    }

    public void setManyAnswers(Boolean manyAnswers) {
        this.manyAnswers = manyAnswers;
    }

    public List<UserResults> getUserResults() {
        return UserResults;
    }

    public void setUserResults(List<org.geekhub.hibernate.entity.UserResults> userResults) {
        UserResults = userResults;
    }

    public Boolean getQuestionStatus() {
        return questionStatus;
    }

    public void setQuestionStatus(Boolean questionStatus) {
        this.questionStatus = questionStatus;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Question() {
    }

    public Byte getQuestionWeight() {
        return questionWeight;
    }

    public void setQuestionWeight(Byte questionWeight) {
        this.questionWeight = questionWeight;
    }

    public Course getCourse() {
        return course;
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
