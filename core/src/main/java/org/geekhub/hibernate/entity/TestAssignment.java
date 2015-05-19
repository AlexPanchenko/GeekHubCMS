package org.geekhub.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "TEST_ASSIGNMENT")
public class TestAssignment {
    @GeneratedValue
    @Id
    @Column(name = "TEST_ASSIGNMENT_ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "TA_USER_ID")
    private User user;

    @OneToOne
    @JoinColumn(name = "TA_TEST_CONFIG_ID")
    private TestConfig testConfig;

    @Column(name = "DATE_REGISTRATION")
    private Date dateRegistration;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TestConfig getTestConfig() {
        return testConfig;
    }

    public void setTestConfig(TestConfig testConfig) {
        this.testConfig = testConfig;
    }

    public Date getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(Date dateRegistration) {
        this.dateRegistration = dateRegistration;
    }
}
