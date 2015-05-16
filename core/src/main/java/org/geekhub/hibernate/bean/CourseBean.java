package org.geekhub.hibernate.bean;


import org.geekhub.hibernate.entity.User;

import java.util.HashSet;
import java.util.Set;

public class CourseBean {
    private int id;
    private String name;
    private String description;
    private Set<User> users = new HashSet<User>();

    public CourseBean(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}