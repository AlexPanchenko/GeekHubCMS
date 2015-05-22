package org.geekhub.service;

import org.geekhub.hibernate.bean.Page;
import org.geekhub.hibernate.bean.RegistrationResponseBean;
import org.geekhub.hibernate.bean.UserBean;
import org.geekhub.hibernate.entity.User;
import org.geekhub.wrapper.UserTestResultWrapper;

import java.text.ParseException;

public interface UserService  {
    public void setFeedback(int Id, String feedBack);
    public User getUserById(int userId);
    public RegistrationResponseBean addUser(UserBean userBean) throws ParseException;

    Object getUserTestResultWrapperListByCourseName(String course);

    Page<UserTestResultWrapper> getPageUserTestResultWrapperListByCourseName(String course, int p, int i);
}
