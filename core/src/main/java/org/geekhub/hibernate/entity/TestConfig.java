package org.geekhub.hibernate.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TEST_CONFIG")
public class TestConfig {
    @GeneratedValue
    @Id
    @Column(name = "TEST_CONFIG_ID")
    private int id;
    private int questionCount;
    private Date date;

    @OneToOne
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
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
