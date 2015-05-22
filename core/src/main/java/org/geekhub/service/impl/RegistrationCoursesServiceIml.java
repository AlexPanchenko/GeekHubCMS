package org.geekhub.service.impl;

import org.geekhub.hibernate.bean.CourseBean;
import org.geekhub.hibernate.dao.CourseDao;
import org.geekhub.hibernate.dao.UserDao;
import org.geekhub.hibernate.dao.UsersCoursesDao;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.UsersCourses;
import org.geekhub.service.CourseService;
import org.geekhub.service.RegistrationCoursesService;
import org.geekhub.wrapper.CourseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class RegistrationCoursesServiceIml implements RegistrationCoursesService {

    @Autowired
    private CourseDao courseDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UsersCoursesDao usersCoursesDao;
    @Autowired
    private CourseService courseService;


    public List<CourseBean> getListCourseBeans() {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        org.geekhub.hibernate.entity.User user = userDao.loadUserByUsername(principal.getUsername());
        List<Course> listCourses = courseDao.getAll();
        List<CourseBean> listCourseBeans = new ArrayList<>();
        for (Course course : listCourses) {
            listCourseBeans.add(courseService.toBean(course));

        }
        return listCourseBeans;
    }

    @Override
    public List<CourseWrapper> getListCourseWrappers() {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        org.geekhub.hibernate.entity.User user = userDao.loadUserByUsername(principal.getUsername());

        List<Course> listCourses = courseDao.getAll();
        List<CourseWrapper> listCourseWrappers = new ArrayList<>();
        for (Course course : listCourses) {
            CourseWrapper courseWrapper = new CourseWrapper(course,false);
            if(usersCoursesDao.getAllCoursesByUser(user).contains(course)){
                courseWrapper.setIsRegistered(true);
            }
            listCourseWrappers.add(courseWrapper);
        }
        return listCourseWrappers;
    }


    public void getRegistrationUserByCourses(List<Integer> listCourseId) {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        org.geekhub.hibernate.entity.User user = userDao.loadUserByUsername(principal.getUsername());

        List<Course> coursesList = courseDao.getListCoursesById(listCourseId);
        for (Course course : coursesList) {
            UsersCourses usersCourses = new UsersCourses(user, course);
            usersCoursesDao.create(usersCourses);
        }
    }


}
