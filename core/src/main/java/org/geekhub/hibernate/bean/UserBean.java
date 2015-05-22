package org.geekhub.hibernate.bean;

import org.geekhub.hibernate.entity.Role;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;


public class UserBean {
    private int id;
    private String password;
    @NotNull(message = "Registration date should be not null")
    private String confirmPassword;
    private Date registrationDate;
    @NotBlank(message = "Name should be not empty")
    private String firstName;
    @NotBlank(message = "Surname should be not empty")
    private String lastName;
    private String email;
    private String skype;
    private String phoneNumber;
    private Date birthDay;
    private byte enable;
    private Role role;

    public UserBean() {
    }

    public UserBean(String password, String firstName, String lastName, String email, String skype, String phoneNumber, Date birthDay, String confirmPassword) {

        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.skype = skype;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.confirmPassword = confirmPassword;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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

    public void setRole(Role role) {
        this.role = role;
    }
}
