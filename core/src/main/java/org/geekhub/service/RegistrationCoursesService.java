package org.geekhub.service;


import org.geekhub.hibernate.bean.CourseBean;
import org.geekhub.wrapper.CourseWrapper;

import java.util.List;

public interface RegistrationCoursesService {
    List<CourseBean> getListCourseBeans();
    List<CourseWrapper> getListCourseWrappers();
    public void getRegistrationUserByCourses(List<Integer> listCourseId);


}
