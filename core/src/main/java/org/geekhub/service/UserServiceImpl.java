package org.geekhub.service;

import org.geekhub.dao.UserDao;
import org.geekhub.entity.User;
import org.geekhub.util.FormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(int userId) {
        return userDao.getUserById(userId);
    }

    public static final SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");

    @Override
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
        user.setBirthDay(date);
        user.setRegistrationDate(dataRegistration);
        userDao.addUser(user);

        return null;
    }
}
