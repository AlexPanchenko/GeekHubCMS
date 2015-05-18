package org.geekhub.hibernate.dao.impl;

import org.geekhub.hibernate.dao.UsersCoursesDao;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.User;
import org.geekhub.hibernate.entity.UsersCourses;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by user on 18.05.2015.
 */
@Repository
public class UsersCoursesDaoImpl extends BaseDaoImpl implements UsersCoursesDao {
    @Override
    public List<UsersCourses> getAllCoursesByUser(User user) {
        return sessionFactory.getCurrentSession().createCriteria(UsersCourses.class).add(Restrictions.eq("user", user)).list();
    }
}
