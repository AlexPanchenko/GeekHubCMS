package org.geekhub.hibernate.dao.impl;

import org.geekhub.hibernate.dao.CourseDao;
import org.geekhub.hibernate.entity.Course;

import java.util.List;

/**
 * Created by helldes on 15.05.2015.
 */
public class CourseDaoImpl extends GenericDaoImpl<Course> implements CourseDao {
    @Override
    public List<Course> getAll(int page, int recordsPerPage) {
        page = page * recordsPerPage - recordsPerPage;
        return sessionFactory.getCurrentSession()
                .createCriteria(Course.class)
                .setFirstResult(page)
                .setMaxResults(recordsPerPage)
                .list();
    }
}
