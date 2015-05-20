package org.geekhub.service.impl;

import org.geekhub.hibernate.bean.CourseBean;
import org.geekhub.hibernate.bean.Page;
import org.geekhub.hibernate.dao.CourseDao;
import org.geekhub.hibernate.dao.UserDao;
import org.geekhub.hibernate.dao.UsersCoursesDao;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.User;
import org.geekhub.hibernate.entity.UsersCourses;
import org.geekhub.hibernate.exceptions.CourseNotFoundException;
import org.geekhub.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private UsersCoursesDao usersCoursesDao;

    @Autowired
    private UserDao userDao;

    @Override
    public Page<CourseBean> getAll(int page, int recordsPerPage) {
        List<CourseBean> courses = convertToCourseBean(courseDao.getAll(page, recordsPerPage));
        int size = getAllBeans().size();
        int maxPages = (size % recordsPerPage == 0) ? (size / recordsPerPage) : (size / recordsPerPage) + 1;
        page = (page > maxPages) ? maxPages : page;
        int current = page;
        int begin = Math.max(1, current - recordsPerPage);
        int end = maxPages;
        Page<CourseBean> resultPage = new Page<>(courses, begin, current, size, maxPages, recordsPerPage, end);
        return resultPage;
    }

    @Override
    public List<CourseBean> getAllBeans() {
        List<Course> courses = courseDao.getAll();
        return convertToCourseBean(courses);
    }

    private List<CourseBean> convertToCourseBean(List<Course> courses) {
        List<CourseBean> courseBeans = new ArrayList<>(Collections.emptyList());
        courseBeans.addAll(courses.stream().map(course -> toBean(course)).collect(Collectors.toList()));
        return courseBeans;
    }

    /**
     * Convert {@link org.geekhub.hibernate.entity.Course} to {@link org.geekhub.hibernate.bean.CourseBean}
     *
     * @param course object to convert
     * @return {@link }
     */
    private CourseBean toBean(Course course) {
        CourseBean courseBean = new CourseBean(course.getId(), course.getName(), course.getDescription());
        return courseBean;
    }

    private Course toEntity(CourseBean courseBean) {
        Course course = new Course();
        course.setId(courseBean.getId());
        course.setName(courseBean.getName());
        course.setDescription(courseBean.getDescription());
        return course;
    }

    @Override
    public void create(String courseName, String courseDescription) {
        Course course = new Course();
        course.setName(courseName);
        course.setDescription(courseDescription);
        courseDao.create(course);
    }

    @Override
    public CourseBean getById(int id) throws CourseNotFoundException {
        Course course = (Course) courseDao.read(id, Course.class);
        if (null == course) throw new CourseNotFoundException();
        return toBean(course);
    }

    @Override
    public void update(CourseBean courseBean) throws CourseNotFoundException {
        CourseBean course = getById(courseBean.getId());
        course.setName(courseBean.getName());
        course.setDescription(courseBean.getDescription());
        courseDao.update(toEntity(course));
    }

    @Override
    public void delete(int courseId) throws CourseNotFoundException {
        courseDao.deleteCourseById(courseId);
    }

    public void unRegisterCourse (int id) {
           Course course = (Course) courseDao.read(id, Course.class);
        org.springframework.security.core.userdetails.User principal =
                (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        org.geekhub.hibernate.entity.User user = userDao.loadUserByUsername(principal.getUsername());
        List<UsersCourses> usersCoursesList = user.getUsersCourses();
        UsersCourses tmp = usersCoursesList.get(0);
        usersCoursesDao.delete(tmp);
    }

    @Override
    public List<CourseBean> getCourseBeenByUser() {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        org.geekhub.hibernate.entity.User user = userDao.loadUserByUsername(principal.getUsername());
        List<UsersCourses> usersCoursesList = user.getUsersCourses();
        List<CourseBean> courseList = usersCoursesList.stream().map(usersCourses -> new CourseBean(usersCourses.getCourse().getId(),
                usersCourses.getCourse().getName(),
                usersCourses.getCourse().getDescription())).collect(Collectors.toList());
        return courseList;
    }
}

