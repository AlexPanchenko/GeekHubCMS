package org.geekhub.hibernate.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by odahovskiy on 13.05.2015.
 * @Author Odahovskiy V.(Odahovskiy@gmail.com)
 * @Author Palyvoda (jekainfinity@gmail.com)
 */
@Entity
@Table(name = "ROLES")
public class Role implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ROLE_ID", unique = true, nullable = false)
    private int id;

    @Column(name = "ROLE_NAME", unique = true, nullable = false)
    @NotBlank(message = "Name should be not empty")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private Set<User> users;

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
