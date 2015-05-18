package org.geekhub.service;

import org.geekhub.hibernate.bean.CourseBean;
import org.geekhub.hibernate.bean.Page;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.exceptions.CourseNotFoundException;

import java.util.List;

/**
 * Created by user on 18.05.2015.
 */
public interface CourseService extends GenericService<Course> {

    Page<CourseBean> getAll(int page, int recordsPerPage);

    List<CourseBean> getAll();

    void createCourse(String courseName, String courseDescription);

    CourseBean getById(int id) throws CourseNotFoundException;

    void update(CourseBean courseBean) throws CourseNotFoundException;

    void deleteCourse(int courseId) throws CourseNotFoundException;
}
