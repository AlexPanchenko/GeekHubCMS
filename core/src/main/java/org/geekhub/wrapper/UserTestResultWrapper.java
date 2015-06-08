package org.geekhub.wrapper;

import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.TestAssignment;
import org.geekhub.hibernate.entity.TestConfig;
import org.geekhub.hibernate.entity.User;

/**
 * Created by admin on 20.05.2015.
 */
public class UserTestResultWrapper {
    private User user;
    private Course course;
    private TestAssignment testAssignment;
    private TestConfig testConfig;
    private boolean review;
    private int score;

    public UserTestResultWrapper(User user, Course course) {
        this.user = user;
        this.course = course;
    }

    public UserTestResultWrapper(User user, Course course, TestAssignment testAssignment, TestConfig testConfig) {
        this.user = user;
        this.course = course;
        this.testAssignment = testAssignment;
        this.testConfig = testConfig;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isReview() {
        return review;
    }

    public void setReview(boolean review) {
        this.review = review;
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

    public TestConfig getTestConfig() {
        return testConfig;
    }

    public void setTestConfig(TestConfig testConfig) {
        this.testConfig = testConfig;
    }

    public TestAssignment getTestAssignment() {
        return testAssignment;
    }

    public void setTestAssignment(TestAssignment testAssignment) {
        this.testAssignment = testAssignment;
    }
}
