package org.geekhub.service;

import org.geekhub.hibernate.bean.RegistrationResponseBean;
import org.geekhub.hibernate.bean.UserBean;
import org.geekhub.hibernate.entity.User;

import java.text.ParseException;
import java.util.Date;

public interface UserService  {
    User getUserById(int userId);
    public RegistrationResponseBean addUser(UserBean userBean) throws ParseException;

}
