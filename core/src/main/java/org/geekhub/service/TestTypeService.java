package org.geekhub.service;

import org.geekhub.hibernate.entity.TestType;

import java.util.List;

/**
 * Created by admin on 27.05.2015.
 */
public interface TestTypeService {
    public List<TestType> getList();
    public void create(String name, int courseId);
    public void deleteById(int id);
    public TestType getTestTypeById(int id);
    public void changeTestType(int id, String name, int courseId);
}
