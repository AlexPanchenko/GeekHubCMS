package org.geekhub.hibernate.dao;


import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.TestConfig;

import java.util.List;

public interface TestConfigDao extends BaseDao {
    TestConfig getTestConfigByCourse(Course course);
    public List<TestConfig> getAll();


}
