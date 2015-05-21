package org.geekhub.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PasswordLink")
public class PasswordLink extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "USER_ID")
    private int userId;

    @Column(name = "PASSWORD_LINK")
    private int passwordLink;

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

    public int getPasswordLink() {
        return passwordLink;
    }

    public void setPasswordLink(int passwordLink) {
        this.passwordLink = passwordLink;
    }
}
