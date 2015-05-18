package org.geekhub.service.impl;

import org.geekhub.hibernate.bean.CourseBean;
import org.geekhub.hibernate.dao.CourseDao;
import org.geekhub.hibernate.dao.UserDao;
import org.geekhub.hibernate.dao.UsersCoursesDao;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.UsersCourses;
import org.geekhub.service.RegistrationCoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


@Service
@Transactional
public class RegistrationCoursesServiceIml  implements RegistrationCoursesService {

    @Autowired
    private CourseDao courseDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UsersCoursesDao usersCoursesDao;


    public List<CourseBean> getListCourseBeans() {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        org.geekhub.hibernate.entity.User user = userDao.loadUserByUsername(principal.getUsername());
        List<Course> listCourses = courseDao.getAll();
        List<CourseBean> listCourseBeans = new ArrayList<>();
        for (Course course : listCourses) {
                CourseBean courseBean = new CourseBean(course.getId(), course.getName(), course.getDescription());
                listCourseBeans.add(courseBean);
        }
        return listCourseBeans;
    }


    public void getRegistrationUserByCourses(List<Integer> listCourseId) {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        org.geekhub.hibernate.entity.User user = userDao.loadUserByUsername(principal.getUsername());

        List<Course> coursesList = courseDao.getListCoursesById(listCourseId);
        for (Course course : coursesList) {
          UsersCourses usersCourses = new UsersCourses(user,course);
            usersCoursesDao.create(usersCourses);
        }
        List<UsersCourses> test = user.getUsersCourses();
        List<UsersCourses> test4 = coursesList.get(0).getUsersCourses();
    }
}
