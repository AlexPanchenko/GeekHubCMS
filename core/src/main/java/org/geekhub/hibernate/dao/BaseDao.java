package org.geekhub.hibernate.dao;

import org.geekhub.hibernate.entity.BaseEntity;

import java.util.List;

/**
 * Created by user on 18.05.2015.
 */
public interface BaseDao {
    public void create (BaseEntity obj);
    public void update (BaseEntity obj);
    public  void delete (BaseEntity obj);
    public  BaseEntity read (int id, BaseEntity obj);
    public List<BaseEntity> getAll (BaseDao obj);
}
