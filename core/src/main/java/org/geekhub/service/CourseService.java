package org.geekhub.service;

import org.geekhub.hibernate.bean.CourseBean;
import org.geekhub.hibernate.bean.Page;
import org.geekhub.hibernate.exceptions.CourseNotFoundException;

import java.util.List;

/**
 * Created by user on 18.05.2015.
 */
public interface CourseService {

    Page<CourseBean> getAll(int page, int recordsPerPage);

    List<CourseBean> getAllBeans();

    void create(String courseName, String courseDescription);

    CourseBean getById(int id) throws CourseNotFoundException;

    void update(CourseBean courseBean) throws CourseNotFoundException;

    void delete(int courseId) throws CourseNotFoundException;
}
