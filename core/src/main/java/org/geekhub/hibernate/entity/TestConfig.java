package org.geekhub.hibernate.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TEST_CONFIG")
public class  TestConfig extends BaseEntity {

    @GeneratedValue
    @Id
    @Column(name = "TEST_CONFIG_ID")
    private int id;
    @Column(name = "TC_TITLE")
    private String title;
    @Column(name = "TC_QUESTION_COUNT")
    private int questionCount;
    @Column(name = "TC_DATE_START")
    private Date dateStart;
    @Column(name = "TC_DATE_FINISH")
    private Date dateFinish;
    @Column(name = "TC_TIME_TO_TEST")
    private int timeToTest;
    @Enumerated(EnumType.STRING)
    @Column(name = "TC_STATUS")
    private TestStatus status;
    @OneToOne
    @JoinColumn(name = "TC_COURSE_ID")
    private Course course;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String tittle) {
        this.title = tittle;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }

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

    public int getTimeToTest() {
        return timeToTest;
    }

    public void setTimeToTest(int dateTimeToTest) {
        this.timeToTest = dateTimeToTest;
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
}
