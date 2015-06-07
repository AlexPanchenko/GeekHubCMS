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

    @Column(name = "TA_DATE_PASSED")
    private Date datePassed;

    @Column(name = "TA_COUNT_RIGHT_ANSWERS")
    private int countTrueAnswers;

    @Column(name = "TA_PASSED")
    private boolean passed;

    @Column(name = "TA_DATE_START")
    private Date dateStart;

    @Column(name = "TA_DATE_FINISH")
    private Date dateFinish;

    @Enumerated(EnumType.STRING)
    @Column(name = "TA_TEST_STATUS_ASSIGNMENT")
    private TestStatusAssignment testStatusAssignment;

    @Column(name = "STATUS_REVIEW")
    private boolean statusReview ;

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }

    public boolean isStatusReview() {
        return statusReview;
    }

    public void setStatusReview(boolean statusReview) {
        this.statusReview = statusReview;
    }

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
