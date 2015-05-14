package org.geekhub.service;

import org.geekhub.dao.UserDao;
import org.geekhub.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Override
    public void addUser(String login, String password, String firstName, String lastName, String patronymic,
                        String email, String skype, String phoneNumber, String confirmPassword, Date date, Date dataRegistration) {
    User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPatronymic(patronymic);
        user.setEmail(email);
        user.setSkype(skype);
        user.setPhoneNumber(phoneNumber);
        user.setBirthDay(date);
        user.setRegistrationDate(dataRegistration);
        userDao.addUser(user);
    }


}
