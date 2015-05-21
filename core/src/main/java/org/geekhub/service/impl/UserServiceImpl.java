package org.geekhub.service.impl;


import org.apache.commons.codec.digest.DigestUtils;
import org.geekhub.hibernate.bean.RegistrationResponseBean;
import org.geekhub.hibernate.bean.UserBean;
import org.geekhub.hibernate.dao.CourseDao;
import org.geekhub.hibernate.dao.UserDao;
import org.geekhub.hibernate.dao.UsersCoursesDao;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.Role;
import org.geekhub.hibernate.entity.User;
import org.geekhub.service.UserService;
import org.geekhub.wrapper.UserTestResultWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl  implements UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    CourseDao courseDao;

    @Autowired
    UsersCoursesDao usersCoursesDao;


    public User getUserById(int userId) {
        return null;
    }



    public User getUserByEmail(String email) throws UsernameNotFoundException {
        return userDao.getUserByEmail(email);
    }

    public User getUserByLogin(String login) throws UsernameNotFoundException {
        return getUserByLogin(login);
    }

    public static final SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");

    @Override
    public RegistrationResponseBean addUser(UserBean userBean) throws ParseException {

        RegistrationResponseBean registrationResponseBean = validateForm(userBean);

        if(registrationResponseBean.isSuccess()) {
            User user = new User();
            user.setLogin(userBean.getLogin());
            user.setPassword(DigestUtils.md5Hex(userBean.getPassword()));
            user.setFirstName(userBean.getFirstName());
            user.setLastName(userBean.getLastName());
            user.setPatronymic(userBean.getPatronymic());
            user.setEmail(userBean.getEmail());
            user.setSkype(userBean.getSkype());
            user.setPhoneNumber(userBean.getPhoneNumber());
            user.setRole(Role.ROLE_STUDENT);
            user.setBirthDay(userBean.getBirthDay());
            user.setRegistrationDate(new Date());
            userDao.create(user);
        }
        return registrationResponseBean;
    }

    public RegistrationResponseBean validateForm(UserBean userBean){
        RegistrationResponseBean registrationResponseBean = new RegistrationResponseBean();

        System.out.println(userBean.getEmail());
        if (userDao.getUserByEmail(userBean.getEmail()) != null) {
            registrationResponseBean.setSuccess(false);
            registrationResponseBean.setErrorMessage("Email already in use");
            return registrationResponseBean;
        } else if (userDao.getUserByLogin(userBean.getLogin()) != null) {
            registrationResponseBean.setSuccess(false);
            registrationResponseBean.setErrorMessage("Login already in use");
            return registrationResponseBean;
        } else if(userBean.getEmail().equals("")){
            registrationResponseBean.setSuccess(false);
            registrationResponseBean.setErrorMessage("Email is empty");
            return registrationResponseBean;
        } else if(userBean.getFirstName().equals("")){
            registrationResponseBean.setSuccess(false);
            registrationResponseBean.setErrorMessage("First name is empty");
            return registrationResponseBean;
        } else if(userBean.getLastName().equals("")){
            registrationResponseBean.setSuccess(false);
            registrationResponseBean.setErrorMessage("Last name is empty");
            return registrationResponseBean;
        } else if(userBean.getPatronymic().equals("")) {
            registrationResponseBean.setSuccess(false);
            registrationResponseBean.setErrorMessage("Patronymic is empty");
            return registrationResponseBean;
        } else if(userBean.getLogin().equals("")) {
            registrationResponseBean.setSuccess(false);
            registrationResponseBean.setErrorMessage("Login is empty");
            return registrationResponseBean;
        }else if(userBean.getPassword().length()<6){
            registrationResponseBean.setSuccess(false);
            registrationResponseBean.setErrorMessage("Password length should be more than 6 characters");
            return registrationResponseBean;
        } else if(!userBean.getPassword().equals(userBean.getConfirmPassword())){
            registrationResponseBean.setSuccess(false);
            registrationResponseBean.setErrorMessage("Password doesn't match");
            return registrationResponseBean;
        } else {
            registrationResponseBean.setSuccess(true);
            return registrationResponseBean;
        }
    }

    public List<UserTestResultWrapper> getUserTestResultWrapperListByCourseName(String courseName){
        List<UserTestResultWrapper> userTestResultWrapperList = new ArrayList<>();
        Course course =  courseDao.getCourseByName(courseName);
        List<User> userList = usersCoursesDao.getAllUsersByCourse(course);

        for(User user: userList){
            userTestResultWrapperList.add(new UserTestResultWrapper(user, course));
        }
        return userTestResultWrapperList;
    }

}
