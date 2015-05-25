package org.geekhub.service;

import org.geekhub.hibernate.bean.UserBean;
import org.geekhub.hibernate.bean.Page;
import org.geekhub.hibernate.bean.RegistrationResponseBean;
import org.geekhub.hibernate.bean.UserBean;
import org.geekhub.hibernate.entity.User;
import org.geekhub.wrapper.UserTestResultWrapper;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface UserService  {
    public void setFeedback(int Id, String feedBack);
//    public String addUser(String login, String password, String firstName, String lastName,
//                          String patronymic, String email, String skype, String phoneNumber, String confirmPassword, String date, Date dataRegistration) throws ParseException;

    public Long getUsersCount();
    public List<UserBean> getUsersOnOnePage(int page);
    public List<UserBean> getAllTeachers();

    public User getUserById(int userId);
    public RegistrationResponseBean addUser(UserBean userBean) throws ParseException;

    Object getUserTestResultWrapperListByCourseName(String course);

    Page<UserTestResultWrapper> getPageUserTestResultWrapperListByCourseName(String course, int p, int i);
}
