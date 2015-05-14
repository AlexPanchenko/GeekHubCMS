package org.geekhub.service;

import org.geekhub.dao.UserDao;
import org.geekhub.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(int userId) {
        return userDao.getUserById(userId);
    }

    public void addUser(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userDao.addUser(user);
    }

}
