package org.geekhub.hibernate.dao;


import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.TestConfig;

public interface TestConfigDao extends BaseDao {
    TestConfig getTestConfigByCourse(Course course);


}
