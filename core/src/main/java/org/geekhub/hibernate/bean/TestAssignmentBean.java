package org.geekhub.hibernate.bean;

import org.geekhub.hibernate.entity.TestConfig;
import org.geekhub.hibernate.entity.TestStatusAssignment;
import org.geekhub.hibernate.entity.User;
import org.geekhub.hibernate.entity.UserResults;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by helldes on 21.05.2015.
 */
public class TestAssignmentBean {
    private int id;
    private User user;
    private TestConfig testConfig;
    private List<UserResults> userResults = new ArrayList<>();
    private Date dueDate;
    private Date testStart;
    private Date testFinish;
    private boolean passed;
    private TestStatusAssignment testStatusAssignment;

    public TestAssignmentBean(){
    };

    public TestAssignmentBean(int id, User user, TestConfig testConfig, List<UserResults> userResults, Date dueDate, Date testStart, Date testFinish, boolean passed, TestStatusAssignment testStatusAssignment) {
        this.id = id;
        this.user = user;
        this.testConfig = testConfig;
        this.userResults = userResults;
        this.dueDate = dueDate;
        this.testStart = testStart;
        this.testFinish = testFinish;
        this.passed = passed;
        this.testStatusAssignment = testStatusAssignment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TestConfig getTestConfig() {
        return testConfig;
    }

    public void setTestConfig(TestConfig testConfig) {
        this.testConfig = testConfig;
    }

    public List<UserResults> getUserResults() {
        return userResults;
    }

    public void setUserResults(List<UserResults> userResults) {
        this.userResults = userResults;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        dueDate = dueDate;
    }

    public Date getTestStart() {
        return testStart;
    }

    public void setTestStart(Date testStart) {
        this.testStart = testStart;
    }

    public Date getTestFinish() {
        return testFinish;
    }

    public void setTestFinish(Date testFinish) {
        this.testFinish = testFinish;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public TestStatusAssignment getTestStatusAssignment() {
        return testStatusAssignment;
    }

    public void setTestStatusAssignment(TestStatusAssignment testStatusAssignment) {
        this.testStatusAssignment = testStatusAssignment;
    }
}
