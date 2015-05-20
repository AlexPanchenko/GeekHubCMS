package org.geekhub.service;

import org.geekhub.hibernate.bean.CourseBean;
import org.geekhub.hibernate.bean.Page;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.User;
import org.geekhub.hibernate.exceptions.CourseNotFoundException;

import java.util.List;


public interface CourseService {

    public Page<CourseBean> getAll(int page, int recordsPerPage);

    public List<CourseBean> getAllBeans();

    public void create(String courseName, String courseDescription);

    CourseBean getById(int id) throws CourseNotFoundException;

    public void update(CourseBean courseBean) throws CourseNotFoundException;

    public void delete(int courseId) throws CourseNotFoundException;

    public List<CourseBean> getCourseBeenByUser();

    public void unRegisterCourse (int id);
}
