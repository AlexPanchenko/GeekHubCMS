package org.geekhub.wrapper;

import org.geekhub.hibernate.entity.Course;

/**
 * Created by admin on 18.05.2015.
 */
public class CourseWrapper {

    private Course course;
    private boolean isRegistered;

    public CourseWrapper(){}

    public CourseWrapper(Course course, boolean isRegistered) {
        this.course = course;
        this.isRegistered = isRegistered;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public boolean getIsRegistered() {
        return isRegistered;
    }

    public void setIsRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }
}
