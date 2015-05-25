package org.geekhub.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "passwordlink")
public class PasswordLink extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "USER_ID")
    private int userId;

    @Column(name = "UNIQUE_LINK")
    private String passwordLink;

    public PasswordLink() {
    }

    public PasswordLink(int userId, String passwordLink) {
        this.userId = userId;
        this.passwordLink = passwordLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setPasswordLink(String passwordLink) {
        this.passwordLink = passwordLink;
    }

}
