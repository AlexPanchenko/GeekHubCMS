package org.geekhub.service;

import org.springframework.stereotype.Component;

/**
 * Created by helldes on 15.05.2015.
 */
@Component
public interface GenericService<T> {
    void create(T t);
    T read(Integer id);
    void update(T t);
    void delete(T t);
}
