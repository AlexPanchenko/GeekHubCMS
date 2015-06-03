package org.geekhub.hibernate.dao.impl;

import org.geekhub.hibernate.bean.ClassRoomBean;
import org.geekhub.hibernate.dao.UserDao;
import org.geekhub.hibernate.dao.UsersCoursesDao;
import org.geekhub.hibernate.entity.ClassRoom;
import org.geekhub.hibernate.entity.User;
import org.geekhub.hibernate.entity.Page;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private UsersCoursesDao usersCourses;


    @Override
    public Long usersCount() throws UsernameNotFoundException {
        return  (Long) sessionFactory.getCurrentSession().createCriteria(User.class)
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }

    @Override
    public List<User> usersOnPage(int page) throws UsernameNotFoundException {
        return sessionFactory.getCurrentSession().createCriteria(User.class).setFirstResult(4 * (page - 1)).setMaxResults(4).list();
    }

    @Override
    public List<User> readAllUsers(){
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }


    @Override
    public User getUserById(int userId) {
        User user = (User) sessionFactory.getCurrentSession().get(User.class, userId);
        return user;
    }

    public void addUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {

        List<User> list = sessionFactory.getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq("email", email)).list();

        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public User getUserByEmail(String email) throws UsernameNotFoundException {
        User user = (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("email", email)).uniqueResult();
        return user;
    }

}
