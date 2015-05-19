package org.geekhub.hibernate.dao.impl;

import org.geekhub.hibernate.dao.CourseDao;
import org.geekhub.hibernate.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by helldes on 15.05.2015.
 */
@Repository
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

    @Override
    public void updateCourse(Course course) {
        sessionFactory.getCurrentSession().createSQLQuery("UPDATE courses SET course_name = :course_name, course_description = :course_description where course_id = :course_id")
                .setParameter("course_name", course.getName())
                .setParameter("course_description", course.getDescription())
                .setParameter("course_id", course.getId())
                .executeUpdate();
    }

    @Override
    public void deleteCourse(int courseId) {
        sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM courses WHERE course_id = :course_id")
                .setParameter("course_id", courseId)
                .executeUpdate();
    }
}
