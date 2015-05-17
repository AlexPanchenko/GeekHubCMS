package org.geekhub.hibernate.dao.impl;

import org.geekhub.hibernate.dao.CourseDao;
import org.geekhub.hibernate.entity.Course;
import org.springframework.stereotype.Repository;

/**
 * Created by helldes on 15.05.2015.
 */
@Repository("courseDao")
public class CourseDaoImpl extends GenericDaoImpl<Course> implements CourseDao {
}
