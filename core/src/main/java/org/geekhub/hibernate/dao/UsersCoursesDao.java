package org.geekhub.hibernate.dao;

import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.User;

import java.util.List;

/**
 * Created by user on 18.05.2015.
 */
public interface UsersCoursesDao extends BaseDao {
     public List<Course> getAllCoursesByUser (User user);
     public List<User> getAllUsersByCourse(Course course);

}
