package org.geekhub.hibernate.bean;

import org.hibernate.validator.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aleksander on 15.05.2015.
 *
 * @Author Aleksander
 * @Author odahovskiy
 */
public class CourseBean {

    private int id;

    @NotBlank(message = "Name should be not empty")
    private String name;

    @NotBlank(message = "Description should be not empty")
    private String description;

    private Set<UserBean> users = new HashSet<>();

    public CourseBean(){}

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

    public Set<UserBean> getUsers() {
        return users;
    }

    public void setUsers(Set<UserBean> users) {
        this.users = users;
    }
}
