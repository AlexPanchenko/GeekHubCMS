package org.geekhub.hibernate.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TEST_ASSIGNMENT")
public class TestAssignment {
    @GeneratedValue
    @Id
    @JoinColumn(name = "TEST_ASSIGNMENT_ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private int userId;

    @ManyToOne
    @JoinColumn(name = "TEST_CONFIG_ID")
    private int testConfigId;
    @JoinColumn(name = "DATE_REGISTRATION")
    private Date dateRegistration;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTestConfigId() {
        return testConfigId;
    }

    public void setTestConfigId(int testConfigId) {
        this.testConfigId = testConfigId;
    }

    public Date getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(Date dateRegistration) {
        this.dateRegistration = dateRegistration;
    }
}
