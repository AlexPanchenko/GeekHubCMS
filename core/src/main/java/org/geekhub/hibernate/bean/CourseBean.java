package org.geekhub.hibernate.bean;


import org.geekhub.hibernate.entity.TestConfig;
import org.hibernate.validator.constraints.NotBlank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class CourseBean {

    private int id;

    @NotBlank(message = "Name should be not empty")
    private String name;

    @NotBlank(message = "Description should be not empty")
    private String description;



    List<TestConfigBeen> testConfigListBeens = new ArrayList<>();

    public CourseBean() {
    }

    public CourseBean(int id, String name, String description, List<TestConfigBeen> testConfigListBeens) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.testConfigListBeens = testConfigListBeens;
    }

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


    public List<TestConfigBeen> getTestConfigListBeens() {
        return testConfigListBeens;
    }

    public void setTestConfigListBeens(List<TestConfigBeen> testConfigListBeens) {
        this.testConfigListBeens = testConfigListBeens;
    }
}

