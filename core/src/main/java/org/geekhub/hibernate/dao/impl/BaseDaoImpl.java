package org.geekhub.hibernate.dao.impl;

import org.geekhub.hibernate.dao.BaseDao;
import org.geekhub.hibernate.entity.BaseEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BaseDaoImpl implements BaseDao {

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public void create(BaseEntity obj) {
        sessionFactory.getCurrentSession().save(obj);    }

    @Override
    public void update(BaseEntity obj) {
        sessionFactory.getCurrentSession().update(obj);
    }

    @Override
    public void delete(BaseEntity obj) {
        sessionFactory.getCurrentSession().delete(obj);
    }

    @Override
    public BaseEntity read(int id, BaseEntity obj) {
        return (BaseEntity) sessionFactory.getCurrentSession().get(obj.getClass(),id);
    }

    @Override
    public List<BaseEntity> getAll(BaseDao obj) {
        return sessionFactory.getCurrentSession().createCriteria(obj.getClass()).list();
    }
}
