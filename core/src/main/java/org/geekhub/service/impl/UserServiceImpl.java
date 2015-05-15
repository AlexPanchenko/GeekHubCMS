package org.geekhub.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.geekhub.hibernate.dao.UserDao;
import org.geekhub.hibernate.entity.Role;
import org.geekhub.hibernate.entity.User;
import org.geekhub.service.UserService;
import org.geekhub.util.FormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Service
@Transactional
public class UserServiceImpl extends GenericServiceImpl<User> implements UserService {

 @Autowired
    UserDao userDao;


    public User getUserById(int userId) {
        return userDao.read(userId);
    }

    @Override
    public User getUserByEmail(String email) throws UsernameNotFoundException {
        return userDao.getUserByEmail(email);
    }

    @Override
    public User getUserByLogin(String login) throws UsernameNotFoundException {
        return getUserByLogin(login);
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
        user.setRoles(Role.ROLE_STUDENT);
        user.setBirthDay(date);
        user.setRegistrationDate(dataRegistration);
        userDao.create(user);

        return null;
    }
}
