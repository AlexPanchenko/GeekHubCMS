package org.geekhub.hibernate.dao;

import org.geekhub.hibernate.entity.Course;

import java.util.List;

public interface CourseDao extends BaseDao {

    public List<Course> getAll ();

    public List<Course> getListCoursesById(List<Integer> listCourseId);


}
