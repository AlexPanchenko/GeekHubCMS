package org.geekhub.dao;

import org.geekhub.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by user on 13.05.2015.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUserById(int userId) {
        Transaction trn = sessionFactory.getCurrentSession().beginTransaction();
        User user = (User) sessionFactory.getCurrentSession().get(User.class, userId);
        trn.commit();

        return user;
    }
@Transactional
    public void addUser(User user) {
        Transaction trn = sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().save(user);
        trn.commit();

    }

    @Transactional
    public User loadUserByUsername(String userName) throws UsernameNotFoundException {
        Transaction trn = sessionFactory.getCurrentSession().beginTransaction();

        List<User> list = sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.like("U_LOGIN", userName)).list();
        trn.commit();

        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }

    }

    @Override
    public User getUserByEmail(String email) throws UsernameNotFoundException {
        Transaction trn = sessionFactory.getCurrentSession().beginTransaction();
        User user = (User)sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("email", email)).uniqueResult();
        trn.commit();

        return user;
    }

    @Override
    public User getUserByLogin(String login) throws UsernameNotFoundException {
        Transaction trn = sessionFactory.getCurrentSession().beginTransaction();
        User user = (User)sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("login", login)).uniqueResult();
        trn.commit();

        return user;
    }

}
