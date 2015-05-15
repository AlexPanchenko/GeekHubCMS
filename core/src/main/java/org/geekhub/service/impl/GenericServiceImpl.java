package org.geekhub.service.impl;

import org.geekhub.hibernate.dao.GenericDao;
import org.geekhub.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by helldes on 15.05.2015.
 */
@Service
public abstract class GenericServiceImpl<T extends Serializable> implements GenericService<T> {

    @Autowired
    GenericDao<T> genericDao;

    public GenericServiceImpl (GenericDao<T> genericDao){
        this.genericDao = genericDao;
    }

    public GenericServiceImpl (){
    }

    public GenericDao<T> getGenericDao(){
        return genericDao;
    }

    public void setGenericDao(GenericDao<T> genericDao){
        this.genericDao = genericDao;
    }

    @Override
    public void create(T t) {
        genericDao.create(t);
    }

    @Override
    public T read(Integer id) {
        return genericDao.read(id);
    }

    @Override
    public void update(T t) {
        genericDao.update(t);
    }

    @Override
    public void delete(T t) {
        genericDao.delete(t);
    }
}
