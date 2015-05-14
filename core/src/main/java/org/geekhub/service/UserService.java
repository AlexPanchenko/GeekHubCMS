package org.geekhub.service;

import org.geekhub.entity.User;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by user on 13.05.2015.
 */
public interface UserService {
    User getUserById(int userId);

    public String addUser(String login, String password, String firstName, String lastName,
                        String patronymic, String email, String skype, String phoneNumber, String confirmPassword, String date, Date dataRegistration)throws ParseException;
}
