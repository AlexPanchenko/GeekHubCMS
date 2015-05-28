package org.geekhub.service;

import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.TestType;

import java.util.List;

/**
 * Created by admin on 27.05.2015.
 */
public interface TestTypeService {
    public List<TestType> getList();
    public void create(String name, int courseId);
    public List<TestType> getListByCourseId(int courseId);
    TestType getTestTypeById(int testTypeId);

}
