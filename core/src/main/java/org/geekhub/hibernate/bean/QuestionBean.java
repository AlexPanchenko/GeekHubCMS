package org.geekhub.hibernate.bean;

import org.geekhub.hibernate.entity.TestType;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by helldes on 19.05.2015.
 */
public class QuestionBean {

    private int id;
    private String questionText;
    private Byte questionWeight;
    private String questionCode;
    private String questionTitle;
    private Boolean questionStatus;
    private Boolean myAnswer;
    private Boolean manyAnswers;
    private Set<AnswerBean> answers = new HashSet<>();
    private int course;
    private TestType testType;

    public TestType getTestType() {
        return testType;
    }

    public void setTestType(TestType testType) {
        this.testType = testType;
    }

    public QuestionBean(int id, String questionText) {
        this.id = id;
        this.questionText = questionText;
    }

    public QuestionBean(int id, String questionText, Byte questionWeight, String questionTitle, Boolean questionStatus, Boolean myAnswer, Boolean manyAnswers, Set<AnswerBean> answers, int course) {
        this.id = id;
        this.questionText = questionText;
        this.questionWeight = questionWeight;
        this.questionTitle = questionTitle;
        this.questionStatus = questionStatus;
        this.myAnswer = myAnswer;
        this.manyAnswers = manyAnswers;
        this.answers = answers;
        this.course = course;
    }

    public QuestionBean(int id, String questionText, Byte questionWeight, Boolean questionStatus, Boolean myAnswer, int course, String questionCode) {
        this.id = id;
        this.questionText = questionText;
        this.questionCode = questionCode;
        this.questionWeight = questionWeight;
        this.questionStatus = questionStatus;
        this.myAnswer = myAnswer;
        this.course = course;
    }

    public QuestionBean(String questionText, byte questionWeight, boolean questionStatus, boolean myAnswer, int course) {
        this.questionText = questionText;
        this.questionStatus = questionStatus;
        this.questionWeight = questionWeight;
        this.myAnswer = myAnswer;
        this.course = course;
    }

    public String getQuestionCode() {
        return questionCode;
    }

    public void setQuestionCode(String questionCode) {
        this.questionCode = questionCode;
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

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }
}
