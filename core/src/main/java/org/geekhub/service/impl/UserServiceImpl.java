package org.geekhub.service.impl;


import org.geekhub.hibernate.bean.UserBean;
import org.apache.commons.codec.digest.DigestUtils;
import org.geekhub.hibernate.bean.RegistrationResponseBean;
import org.geekhub.hibernate.bean.UserBean;
import org.geekhub.hibernate.dao.PasswordDao;
import org.geekhub.hibernate.dao.UserDao;
import org.geekhub.hibernate.dao.UsersCoursesDao;
import org.geekhub.hibernate.entity.PasswordLink;
import org.geekhub.hibernate.entity.Role;
import org.geekhub.hibernate.entity.User;
import org.geekhub.service.UserService;
import org.geekhub.util.FormValidator;
import org.geekhub.util.JavaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    /*Get user and set new feedback*/
    @Override
    public void setFeedback(int Id, String feedBack) {
        User user = userDao.getUserById(Id);
        user.setFeedBack(feedBack);
        userDao.update(user);
    }

    @Override
    public String addUser(String login, String password, String firstName, String lastName, String patronymic, String email, String skype, String phoneNumber, String confirmPassword, String date, Date dataRegistration) throws ParseException {
        return null;
    }

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
//        Date date = new Date();
//        if (!birthDay.equals("")) {
//            date = dt.parse(birthDay);
//        }
//        User user = new User();
//        user.setLogin(login);
//        user.setPassword(DigestUtils.md5Hex(password));
//        user.setFirstName(firstName);
//        user.setLastName(lastName);
//        user.setPatronymic(patronymic);
//        user.setEmail(email);
//        user.setSkype(skype);
//        user.setPhoneNumber(phoneNumber);
//        user.setRole(Role.ROLE_STUDENT);
//        user.setBirthDay(date);
//        user.setRegistrationDate(dataRegistration);
//        userDao.create(user);

        return registrationResponseBean;
    }
    @Override
    public List<UserBean> getUsersOnOnePage(int page){
        List<User> users = userDao.usersOnPage(page);
        List<UserBean> userBeans = new ArrayList<UserBean>();
        for(User u: users){
            UserBean userBean = new UserBean();
            userBean.setLastName(u.getLastName());
            userBean.setFirstName(u.getFirstName());
            userBean.setPatronymic(u.getPatronymic());
            userBean.setEmail(u.getEmail());
            userBean.setPhoneNumber(u.getPhoneNumber());
            userBean.setSkype(u.getSkype());
            userBeans.add(userBean);
        }
        return userBeans;
    }
    public Long getUsersCount(){
        return userDao.usersCount();
    }

    @Override
    public List<UserBean> getAllTeachers(){
        List<UserBean> allTeachers = new ArrayList<UserBean>();
        List<User> users = userDao.readAllUsers();
        for(User u: users){
            if(u.getRole().equals(Role.ROLE_TEACHER)) {
                UserBean teacher = new UserBean();
                teacher.setId(u.getId());
                teacher.setLastName(u.getLastName());
                teacher.setFirstName(u.getFirstName());
                teacher.setPatronymic(u.getPatronymic());
                teacher.setEmail(u.getEmail());
                teacher.setPhoneNumber(u.getPhoneNumber());
                teacher.setSkype(u.getSkype());
                allTeachers.add(teacher);
            }
        }
        return allTeachers;
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
}
