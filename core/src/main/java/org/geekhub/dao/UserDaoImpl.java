package org.geekhub.dao;

import org.geekhub.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 13.05.2015.
 */
@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUserById(int userId) {
        Transaction trn = sessionFactory.getCurrentSession().beginTransaction();
        User user = (User) sessionFactory.getCurrentSession().get(User.class, userId);
        trn.commit();
        return user;
    }
}
