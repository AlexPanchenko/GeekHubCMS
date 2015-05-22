package org.geekhub.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TEST_ASSIGNMENT")
public class TestAssignment extends BaseEntity implements Serializable {
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

    @Column(name = "DATE_PASSED")
    private Date datePassed;

    @Column(name = "COUNT_RIGHT_ANSWERS")
    private int countTrueAnswers;

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

    public Date getDatePassed() {
        return datePassed;
    }

    public void setDatePassed(Date datePassed) {
        this.datePassed = datePassed;
    }

    public int getCountTrueAnswers() {
        return countTrueAnswers;
    }

    public void setCountTrueAnswers(int countTrueAnswers) {
        this.countTrueAnswers = countTrueAnswers;
    }
}
