package org.geekhub.hibernate.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private int id;

    @Column(name = "U_PASSWORD", unique = false, nullable = false, length = 100)
    private String password;

    @Temporal(TemporalType.DATE)
    @Column(name = "U_REG_DATE")
    @NotNull(message = "Registration date should be not null")
    private Date registrationDate;

    @Column(name = "FIRST_NAME", length = 25, nullable = false)
    @NotBlank(message = "Name should be not empty")
    private String firstName;

    @Column(name = "LAST_NAME", length = 25, nullable = false)
    @NotBlank(message = "Surname should be not empty")
    private String lastName;

    @Column(name = "E_MAIL", length = 40, nullable = false)
    private String email;

    @Column(name = "SKYPE", length = 40)
    private String skype;

    @Column(name = "PHONE_NUMBER", length = 40, nullable = false)
    private String phoneNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "B_DAY")
    private Date birthDay;

    @Column(name = "ENABLED", nullable = false)
    private byte enable;

    @Column(name = "USER_ROLE")
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "user")
    List<TestAssignment> testAssignments = new ArrayList<>();

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "user")
    List<UsersCourses> usersCourses = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    List<UserResults> userResults = new ArrayList<>();

    public List<UserResults> getUserResults() {
        return userResults;
    }

    public void setUserResults(List<UserResults> userResults) {
        this.userResults = userResults;
    }

    public User(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public byte getEnable() {
        return enable;
    }

    public void setEnable(byte enable) {
        this.enable = enable;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role roles) {
        this.role = roles;
    }

    public List<UsersCourses> getUsersCourses() {
        return usersCourses;
    }

    public void setUsersCourses(List<UsersCourses> usersCourses) {
        this.usersCourses = usersCourses;
    }

    public List<TestAssignment> getTestAssignments() {
        return testAssignments;
    }

    public void setTestAssignments(List<TestAssignment> testAssignments) {
        this.testAssignments = testAssignments;
    }
}
