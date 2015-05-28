package org.geekhub.hibernate.dao;

import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.TestType;

import java.util.List;

/**
 * Created by admin on 27.05.2015.
 */
public interface TestTypeDao extends BaseDao {
    public List<TestType> getList();
    public List<TestType> getListByCource(Course course);
}
