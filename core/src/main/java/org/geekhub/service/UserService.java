package org.geekhub.service;

import org.geekhub.hibernate.bean.RegistrationResponseBean;
import org.geekhub.hibernate.bean.UserBean;
import org.geekhub.hibernate.entity.User;

import java.text.ParseException;
import java.util.Date;

public interface UserService  {
    User getUserById(int userId);
    public RegistrationResponseBean addUser(UserBean userBean) throws ParseException;



    String addUser(String login, String password, String firstName, String lastName,
                          String patronymic, String email, String skype, String phoneNumber, String confirmPassword, String date, Date dataRegistration) throws ParseException;

    default User getUserByEmail(String email) { return null;}
}
