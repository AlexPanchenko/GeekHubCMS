package org.geekhub.hibernate.dao.impl;

import org.geekhub.hibernate.dao.UsersCoursesDao;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.User;
import org.geekhub.hibernate.entity.UsersCourses;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class UsersCoursesDaoImpl extends BaseDaoImpl implements UsersCoursesDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    @SuppressWarnings("unchecked")
    public List<Course> getAllCoursesByUser(User user) {
        List<UsersCourses> usersCoursesList = sessionFactory.getCurrentSession().createCriteria(UsersCourses.class).add(Restrictions.eq("user", user)).list();
        List<Course> courseList = new ArrayList<>();
        for(UsersCourses usersCourses: usersCoursesList){
            courseList.add(usersCourses.getCourse());
        }
        return courseList;
    }

    @Override
    public List<User> getAllUsersByCourse(Course course) {
        List<UsersCourses> usersCoursesList = sessionFactory.getCurrentSession().createCriteria(UsersCourses.class).add(Restrictions.eq("course", course)).list();
        List<User> userList = new ArrayList<>();
        for(UsersCourses usersCourses: usersCoursesList){
            userList.add(usersCourses.getUser());
        }
        return userList;
    }

    @Override
    public List<User> getAllUsersByCourse(Course course, int begin, int recordsPerPage) {
        List<UsersCourses> usersCoursesList = sessionFactory.getCurrentSession().createCriteria(UsersCourses.class).add(Restrictions.eq("course", course)).setFirstResult(begin-1)
                .setMaxResults(recordsPerPage).list();

        List<User> userList = new ArrayList<>();
        for(UsersCourses usersCourses: usersCoursesList){
            userList.add(usersCourses.getUser());
        }
        return userList;
    }
}
