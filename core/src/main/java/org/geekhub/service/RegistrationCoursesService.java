package org.geekhub.service;


import org.geekhub.hibernate.bean.CourseBean;
import org.geekhub.hibernate.entity.Course;

import java.util.List;

public interface RegistrationCoursesService {
    List<CourseBean> getListCourseBeans();
    public List<Course> getRegistrationUserByCourses(List<Integer> listCourseId);

}
