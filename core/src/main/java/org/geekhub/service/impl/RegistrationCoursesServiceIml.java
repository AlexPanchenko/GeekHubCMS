package org.geekhub.service.impl;

import org.geekhub.hibernate.bean.CourseBean;
import org.geekhub.hibernate.dao.CourseDao;
import org.geekhub.hibernate.dao.UserDao;
import org.geekhub.hibernate.entity.Course;
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
public class RegistrationCoursesServiceIml extends GenericServiceImpl<Course> implements RegistrationCoursesService {

    @Autowired
    private CourseDao courseDao;
    @Autowired
    private UserDao userDao;


    public List<CourseBean> getListCourseBeans() {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        org.geekhub.hibernate.entity.User user = userDao.loadUserByUsername(principal.getUsername());
        List<Course> listCourses = courseDao.getAll();
        List<CourseBean> listCourseBeans = new ArrayList<>();
        for (Course course : listCourses) {
            if (course.getUsers().contains(user)) {
                break;
            } else {
                CourseBean courseBean = new CourseBean(course.getId(), course.getName(), course.getDescription());
                listCourseBeans.add(courseBean);
            }
        }
        return listCourseBeans;
    }


    public List<Course> getRegistrationUserByCourses(List<Integer> listCourseId) {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        org.geekhub.hibernate.entity.User user = userDao.loadUserByUsername(principal.getUsername());
        List<Course> list = courseDao.getListCoursesById(listCourseId);
        user.getCourses().addAll(list);


        for (Course course : list) {
            course.getUsers().add(user);
            courseDao.update(course);
        }

        userDao.addUser(user);
        return list;
    }
}
