package org.geekhub.hibernate.dao.impl;

import org.geekhub.hibernate.dao.TestConfigDao;
import org.geekhub.hibernate.entity.BaseEntity;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.TestConfig;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestConfigDaoImpl implements TestConfigDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(BaseEntity obj) {

    }

    @Override
    public void update(BaseEntity obj) {

    }

    @Override
    public void delete(BaseEntity obj) {

    }

    @Override
    public BaseEntity read(int id, Class clazz) {
        return null;
    }

}
