package org.geekhub.hibernate.bean;


import org.hibernate.validator.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;


public class CourseBean {

    private int id;

    @NotBlank(message = "Name should be not empty")
    private String name;

    @NotBlank(message = "Description should be not empty")
    private String description;

    TestConfigBeen testConfigBeen;

    public CourseBean() {
    }

    public CourseBean(int id, String name, String description, TestConfigBeen testConfigBeen) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.testConfigBeen = testConfigBeen;
    }

    public CourseBean(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public CourseBean(int id) {
        this.id = id;
    }

    public CourseBean(String name, String description) {
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

    public TestConfigBeen getTestConfigBeen() {
        return testConfigBeen;
    }

    public void setTestConfigBeen(TestConfigBeen testConfigBeen) {
        this.testConfigBeen = testConfigBeen;
    }
}

