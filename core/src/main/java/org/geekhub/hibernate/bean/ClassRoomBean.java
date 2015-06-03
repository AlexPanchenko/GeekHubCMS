package org.geekhub.hibernate.bean;

import java.util.ArrayList;
import java.util.List;

public class ClassRoomBean{
    private int id;
    private List<UserBean> users = new ArrayList<>();
    private CourseBean courseId;
    private String name;
    private UserBean teacher;
    private String description;
    public ClassRoomBean() {
    }

    public ClassRoomBean(int id, List<UserBean> users, CourseBean courseId,String name) {
        this.id = id;
        this.users = users;
        this.courseId = courseId;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserBean getTeacher() {
        return teacher;
    }

    public void setTeacher(UserBean teacher) {
        this.teacher = teacher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
