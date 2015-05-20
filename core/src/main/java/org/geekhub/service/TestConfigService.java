package org.geekhub.service;


import org.geekhub.hibernate.bean.CourseBean;
import org.geekhub.hibernate.bean.TestConfigBeen;
import org.geekhub.hibernate.entity.Course;


import java.util.List;

public interface TestConfigService {

    public List<TestConfigBeen> getTestConfigBeens (int courseId);

}
