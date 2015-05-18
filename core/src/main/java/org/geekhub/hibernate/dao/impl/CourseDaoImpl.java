package org.geekhub.hibernate.dao.impl;

import org.geekhub.hibernate.dao.CourseDao;
import org.geekhub.hibernate.entity.BaseEntity;
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
}
