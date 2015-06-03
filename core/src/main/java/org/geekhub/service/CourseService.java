package org.geekhub.service;

import org.geekhub.hibernate.bean.CourseBean;
import org.geekhub.hibernate.bean.Page;
import org.geekhub.hibernate.bean.TestConfigBeen;
import org.geekhub.hibernate.bean.UserBean;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.TestAssignment;
import org.geekhub.hibernate.entity.User;
import org.geekhub.hibernate.exceptions.CourseNotFoundException;

import java.util.List;


public interface CourseService {

    Page<CourseBean> getAll(int page, int recordsPerPage);

    public List<User> getUserFromCourse(int id);

    List<CourseBean> getAllBeans();

    void create(CourseBean courseBean, TestConfigBeen testConfigBeen);

    CourseBean getById(int id) throws CourseNotFoundException;

    void update(CourseBean courseBean) throws CourseNotFoundException;

    void delete(int courseId) throws CourseNotFoundException;

    void deleteCourse(int courseId) throws CourseNotFoundException;

     List<CourseBean> getCourseBeenByUser();

    public CourseBean toBean(Course course);

    public void unRegisterCourse (int id);

    public List<UserBean> getUsersByCourse(int courseId);

}
