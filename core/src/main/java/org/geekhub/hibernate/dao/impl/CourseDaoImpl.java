package org.geekhub.hibernate.dao.impl;

import org.geekhub.hibernate.dao.CourseDao;
import org.geekhub.hibernate.entity.Course;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDaoImpl extends BaseDaoImpl implements CourseDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @SuppressWarnings("unchecked")
    public List<Course> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(Course.class).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Course> getListCoursesById(List<Integer> listCourseId) {
        return sessionFactory.getCurrentSession().createQuery("from Course course WHERE course.id in :listCourseId")
                .setParameterList("listCourseId", listCourseId).list();
    }

    @Override
    @SuppressWarnings("unchecked")
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
