package org.geekhub.service;

import org.geekhub.entity.User;

import java.util.Date;

/**
 * Created by user on 13.05.2015.
 */
public interface UserService {
    User getUserById(int userId);

    public void addUser(String login, String password, String firstName, String lastName,
                        String patronymic, String email, String skype, String phoneNumber, String confirmPassword, Date date, Date dataRegistration);
}
