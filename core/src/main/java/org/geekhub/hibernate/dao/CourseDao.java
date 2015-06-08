package org.geekhub.hibernate.dao;

import org.geekhub.hibernate.entity.Course;

import java.util.List;

public interface CourseDao extends BaseDao {

    public List<Course> getListCoursesById(List<Integer> listCourseId);
    List<Course> getAll(int page, int recordsPerPage);
    List<Course> getAll();
    void updateCourse(Course course);
    void deleteCourseById(int courseId);
    public Course getCourseByName(String name);
    public boolean isRemovable(Course course);
}
