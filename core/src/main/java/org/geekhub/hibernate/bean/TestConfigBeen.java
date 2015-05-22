package org.geekhub.hibernate.bean;

import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.TestStatus;

import java.util.Date;
import java.util.Timer;


public class TestConfigBeen {

    private int id;
    private int questionCount;
    private Date dueDate;
    private Date dateTimeToTest;
    private TestStatus status;
    private Course course;

    public TestConfigBeen() {
    }

    public TestConfigBeen(int questionCount, Date dueDate, Date dateTimeToTest, TestStatus status, Course course) {
        this.questionCount = questionCount;
        this.dueDate = dueDate;
        this.dateTimeToTest = dateTimeToTest;
        this.status = status;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public TestStatus getStatus() {
        return status;
    }

    public void setStatus(TestStatus status) {
        this.status = status;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getDateTimeToTest() {
        return dateTimeToTest;
    }

    public void setDateTimeToTest(Date dateTimeToTest) {
        this.dateTimeToTest = dateTimeToTest;
    }
}
