package org.geekhub.hibernate.dao.impl;

import org.geekhub.hibernate.dao.GenericDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by helldes on 15.05.2015.
 */
@Repository
public abstract class GenericDaoImpl<T extends Serializable> implements GenericDao<T> {
    private Class<T> clazz;

    @Autowired
    protected SessionFactory sessionFactory;

    public GenericDaoImpl(){
        this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    @Override
    public void create(T t) {
        sessionFactory.getCurrentSession().save(t);
    }

    @Override
    public T read(Integer id) {
        return (T)sessionFactory.getCurrentSession().get(clazz, id);
    }

    @Override
    public void update(T t) {
        sessionFactory.getCurrentSession().update(t);
    }

    @Override
    public void delete(T t) {
        sessionFactory.getCurrentSession().delete(t);
    }

    @Override
    public List<T> getAll(){
        return sessionFactory.getCurrentSession().createCriteria(clazz).list();
    }
}
