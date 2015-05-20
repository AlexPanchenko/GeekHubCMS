package org.geekhub.service;

import org.geekhub.hibernate.entity.User;

import java.text.ParseException;
import java.util.Date;

public interface UserService  {
    public User getUserById(int userId);
    public String addUser(String login, String password, String firstName, String lastName,
                          String patronymic, String email, String skype, String phoneNumber, String confirmPassword, String date, Date dataRegistration) throws ParseException;
}
