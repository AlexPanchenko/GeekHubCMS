package org.geekhub.service;

import org.geekhub.hibernate.bean.Page;
import org.geekhub.hibernate.bean.RegistrationResponseBean;
import org.geekhub.hibernate.bean.UserBean;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.TestConfig;
import org.geekhub.hibernate.entity.User;
import org.geekhub.wrapper.UserTestResultWrapper;
import org.geekhub.wrapper.UserWrapper;

import java.text.ParseException;
import java.util.List;

public interface UserService  {
    public UserBean getUserBeanByEmail(String email);
    public void setFeedback(int Id, String feedBack);
    public User getUserById(int userId);
    public RegistrationResponseBean addUser(UserBean userBean) throws ParseException;
    public Long getUsersCount();
    public List<UserBean> getUsersOnOnePage(int page);
    public List<UserBean> getAllTeachers();
    Object getUserTestResultWrapperListByCourseName(String course);
    Page<UserTestResultWrapper> getPageUserTestResultWrapperListByCourseName(String course, int p, int i);
    public List<Course> getAllCoursesByUser(User user);
    public List<User> getAllUsersByCourse(Course course);
    public User getLogInUser();
    public List<UserWrapper> getUserWrapperListByCourse(Course course, TestConfig testConfig);
}
