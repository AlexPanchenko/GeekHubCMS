package org.geekhub.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "TEST_CONFIG")
public class TestConfig {

    @GeneratedValue
    @Id
    @Column(name = "TEST_CONFIG_ID")
    private int id;
    @Column(name = "TC_QUESTION_COUNT")
    private int questionCount;
    @Column(name = "TC_DUE_DATE")
    private Date dueDate;
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

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }

    public Date getDate() {
        return dueDate;
    }

    public void setDate(Date duDate) {
        this.dueDate = duDate;
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
