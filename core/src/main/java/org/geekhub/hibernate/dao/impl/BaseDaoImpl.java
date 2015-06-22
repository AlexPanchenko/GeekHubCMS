package org.geekhub.hibernate.dao.impl;

import org.geekhub.hibernate.dao.BaseDao;
import org.geekhub.hibernate.entity.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
    public BaseEntity read(int id, Class clazz) {
        return (BaseEntity) sessionFactory.getCurrentSession().get(clazz, id);
    }

    @Override
    public void saveOrUpdate(List<BaseEntity> baseEntitiesList) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        for ( int i = 0; i < baseEntitiesList.size(); i++ ) {
            BaseEntity baseEntity = baseEntitiesList.get(i);
            session.saveOrUpdate(baseEntity);
            if ( i % 20 == 0 ) {
                session.flush();
                session.clear();
            }
        }
        tx.commit();
        session.close();
    }
}
