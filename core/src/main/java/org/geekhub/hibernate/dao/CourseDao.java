package org.geekhub.hibernate.dao;

import org.geekhub.hibernate.entity.Course;

import java.util.List;

/**
 * Created by helldes on 15.05.2015.
 */
public interface CourseDao extends GenericDao<Course> {
    List<Course> getAll(int page, int recordsPerPage);
    void updateCourse(Course course);
    void deleteCourse(int courseId);
}
