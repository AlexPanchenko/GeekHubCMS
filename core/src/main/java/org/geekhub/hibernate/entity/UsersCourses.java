package org.geekhub.hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS_COURSES")
public class UsersCourses extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "USERS_COURSES_ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "UC_USER_ID")
    private User user;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "UC_COURSE_ID")
    private Course course;

    public UsersCourses(){}

    public UsersCourses(User user, Course course) {
        this.user = user;
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
