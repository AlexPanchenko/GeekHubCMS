package org.geekhub.hibernate.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by helldes on 15.05.2015.
 */
public interface GenericDao<T extends Serializable> {
    void create(T t);
    T read(Integer id);
    void update(T t);
    void delete(T t);
    List<T> getAll();
}
