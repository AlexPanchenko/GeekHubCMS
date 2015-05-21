package org.geekhub.hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TEST_ASSIGNMENT")
public class TestAssignment {
    @GeneratedValue
    @Id
    @Column(name = "TEST_ASSIGNMENT_ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "TA_USER_ID")
    private User user;

    @OneToOne
    @JoinColumn(name = "TA_TEST_CONFIG_ID")
    private TestConfig testConfig;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "testAssignment")
    List<UserResults> userResults = new ArrayList<>();

    @Column(name = "TA_DUE_DATE")
    private Date DueDate;

    @Column(name = "TA_TEST_START")
    private Date testStart;

    @Column(name = "TA_TEST_FINISH")
    private Date testFinish;
    @Column(name = "TA_PASSED")
    private boolean passed;
    @Enumerated(EnumType.STRING)
    @Column(name = "TA_TEST_STATUS_ASSIGNMENT")
    private TestStatusAssignment testStatusAssignment;

    public List<UserResults> getUserResults() {
        return userResults;
    }

    public void setUserResults(List<UserResults> userResults) {
        this.userResults = userResults;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TestConfig getTestConfig() {
        return testConfig;
    }

    public void setTestConfig(TestConfig testConfig) {
        this.testConfig = testConfig;
    }

    public Date getDueDate() {
        return DueDate;
    }

    public void setDueDate(Date dueDate) {
        DueDate = dueDate;
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
