package org.geekhub.hibernate.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by helldes on 19.05.2015.
 */
public class QuestionBean {

    private int id;
    private String questionText;
    private Byte questionWeight;
    private String questionTitle;
    private Boolean questionStatus;
    private Boolean myAnswer;
    private Boolean manyAnswers;
    private Set<AnswerBean> answers = new HashSet<>();
    private CourseBean courseBean;

    public CourseBean getCourseBean() {
        return courseBean;
    }

    public void setCourseBean(CourseBean courseBean) {
        this.courseBean = courseBean;
    }

    public QuestionBean(){}

    public QuestionBean(String questionText, Byte questionWeight, Boolean questionStatus, Boolean myAnswer, CourseBean courseBean) {
        this.questionText = questionText;
        this.questionWeight = questionWeight;
        this.questionStatus = questionStatus;
        this.myAnswer = myAnswer;
        this.courseBean = courseBean;
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

    public Set<AnswerBean> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<AnswerBean> answers) {
        this.answers = answers;
    }
}
