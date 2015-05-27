package org.geekhub.hibernate.dao.impl;

import org.geekhub.hibernate.dao.ClassroomDao;
import org.geekhub.hibernate.dao.CourseDao;
import org.geekhub.hibernate.entity.ClassRoom;
import org.geekhub.hibernate.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClassroomDaoImpl extends BaseDaoImpl implements ClassroomDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<User> getUsersById(ArrayList<Integer> usersId){
        return sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.in("id",usersId)).list();
    }

    @Override
    public List<ClassRoom> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(ClassRoom.class).list();
    }
}
