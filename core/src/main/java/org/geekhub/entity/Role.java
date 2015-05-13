package org.geekhub.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

/**
 * Created by odahovskiy on 13.05.2015.
 * @Author Odahovskiy V.(Odahovskiy@gmail.com)
 */
@Entity
@Table(name = "ROLES")
public class Role {

    @Id
    @GeneratedValue
    @Column(name = "ROLE_ID", unique = true, nullable = false)
    private int id;

    @Column(name = "ROLE_NAME", unique = true, nullable = false)
    @NotBlank(message = "Name should be not empty")
    private String name;

    @ManyToMany(cascade = {CascadeType.REFRESH})
    @JoinTable(name = "USER_ROLES", joinColumns = {@JoinColumn(name = "UR_ROLE_ID")}, inverseJoinColumns = {@JoinColumn(name = "UR_USER_ID")})
    private List<User> users;

    public Role() {
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
