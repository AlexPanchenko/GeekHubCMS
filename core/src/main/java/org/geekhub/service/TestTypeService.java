package org.geekhub.service;

import org.geekhub.hibernate.entity.TestType;

import java.util.List;

/**
 * Created by admin on 27.05.2015.
 */
public interface TestTypeService {
    public List<TestType> getList();
    public void create(String name, int courseId);
}
