package org.geekhub.service.impl;


import org.geekhub.hibernate.bean.UserBean;
import org.apache.commons.codec.digest.DigestUtils;
import org.geekhub.hibernate.dao.UserDao;
import org.geekhub.hibernate.entity.Role;
import org.geekhub.hibernate.entity.User;
import org.geekhub.service.UserService;
import org.geekhub.util.FormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public void setFeedback(int Id, String feedBack) {
        User user = userDao.getUserById(Id);
        user.setFeedBack(feedBack);
        userDao.update(user);
    }

    public User getUserById(int userId) {
        return null;
    }

    public static final SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");


    public String addUser(String login, String password, String firstName, String lastName, String patronymic,
                          String email, String skype, String phoneNumber, String confirmPassword, String birthDay, Date dataRegistration) throws ParseException {
        if (userDao.getUserByEmail(email) != null) {
            return "Email already in use";
        } else if (userDao.getUserByLogin(login) != null) {
            return "Login already in use";
        } else {
            String errorMessage = new FormValidator().validateForm(password, firstName, lastName, patronymic,
                    email, confirmPassword, login);
            if (errorMessage != null) {
                return errorMessage;
            }
        }
        Date date = new Date();
        if (!birthDay.equals("")) {
            date = dt.parse(birthDay);
        }
        User user = new User();
        user.setLogin(login);
        user.setPassword(DigestUtils.md5Hex(password));
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPatronymic(patronymic);
        user.setEmail(email);
        user.setSkype(skype);
        user.setPhoneNumber(phoneNumber);
        user.setRole(Role.ROLE_STUDENT);
        user.setBirthDay(date);
        user.setRegistrationDate(dataRegistration);
        userDao.create(user);

        return null;
    }
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
}
