package org.geekhub.service;

import org.geekhub.hibernate.bean.UserBean;
import org.geekhub.hibernate.entity.User;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface UserService  {
    public void setFeedback(int Id, String feedBack);
    public String addUser(String login, String password, String firstName, String lastName,
                          String patronymic, String email, String skype, String phoneNumber, String confirmPassword, String date, Date dataRegistration) throws ParseException;

    public List<UserBean> getUsersOnOnePage();

}

