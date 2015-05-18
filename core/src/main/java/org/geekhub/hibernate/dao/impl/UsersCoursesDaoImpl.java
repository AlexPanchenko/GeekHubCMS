package org.geekhub.hibernate.dao.impl;

import org.geekhub.hibernate.dao.UsersCoursesDao;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.User;
import org.geekhub.hibernate.entity.UsersCourses;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 18.05.2015.
 */
@Repository
public class UsersCoursesDaoImpl extends BaseDaoImpl implements UsersCoursesDao {
    @Override
    public List<Course> getAllCoursesByUser(User user) {
        List<UsersCourses> usersCoursesList = sessionFactory.getCurrentSession().createCriteria(UsersCourses.class).add(Restrictions.eq("user", user)).list();
        List<Course> courseList = new ArrayList<>();
        for(UsersCourses usersCourses: usersCoursesList){
            courseList.add(usersCourses.getCourse());
        }
        return courseList;
    }
}
