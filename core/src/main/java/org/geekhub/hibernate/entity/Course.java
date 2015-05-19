package org.geekhub.hibernate.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "COURSES")
public class Course extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "COURSE_ID")
    private int id;

    @Column(name = "COURSE_NAME", unique = true, nullable = false)
    @NotBlank(message = "Name should be not empty")
    private String name;

    @Column(name = "COURSE_DESCRIPTION")
    private String description;

    @OneToMany
    (fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "course")
    List<UsersCourses> usersCourses = new ArrayList<>();


    public Course() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
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

    public List<UsersCourses> getUsersCourses() {
        return usersCourses;
    }

    public void setUsersCourses(List<UsersCourses> usersCourses) {
        this.usersCourses = usersCourses;
    }
}
