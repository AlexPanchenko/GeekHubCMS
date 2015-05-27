package org.geekhub.hibernate.bean;

import java.util.ArrayList;
import java.util.List;

public class ClassRoomBean{
    private int id;
    private List<UserBean> users = new ArrayList<>();
    private CourseBean courseId;

    public ClassRoomBean() {
    }

    public ClassRoomBean(int id, List<UserBean> users, CourseBean courseId) {
        this.id = id;
        this.users = users;
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public List<UserBean> getUsers() {
        return users;
    }

    public void setUsers(List<UserBean> users) {
        this.users = users;
    }

    public CourseBean getCourseId() {
        return courseId;
    }

    public void setCourseId(CourseBean courseId) {
        this.courseId = courseId;
    }
}
