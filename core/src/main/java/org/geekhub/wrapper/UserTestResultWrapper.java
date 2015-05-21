package org.geekhub.wrapper;

import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.User;

/**
 * Created by admin on 20.05.2015.
 */
public class UserTestResultWrapper {
    private User user;
    private Course course;

    public UserTestResultWrapper(User user, Course course) {
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
