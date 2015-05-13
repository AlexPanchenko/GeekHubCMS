package org.geekhub.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

/**
 * Created by user on 13.05.2015.
 */
@Entity
@Table(name = "COURSES")
public class Course {

    @Id
    @GeneratedValue
    @Column(name = "COURSE_ID")
    private int id;

    @Column(name = "COURSE_NAME", unique = true, nullable = false)
    @NotBlank(message = "Name should be not empty")
    private String name;

    @ManyToMany(cascade = {CascadeType.REFRESH})
    @JoinTable(name = "USER_COURSES", joinColumns = {@JoinColumn(name = "UC_COURSE_ID")}, inverseJoinColumns = {@JoinColumn(name = "UC_USER_ID")})
    private List<User> users;

    private Course(){
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
