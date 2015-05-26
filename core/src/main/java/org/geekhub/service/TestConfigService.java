package org.geekhub.service;


import org.geekhub.hibernate.bean.TestConfigBeen;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.TestConfig;

import java.util.List;

public interface TestConfigService {

    public TestConfigBeen getTestConfigById (int testConfigId);
    public TestConfigBeen getTestConfigBeen (int courseId);
    public void createTestConfig (TestConfigBeen testConfigBeen);
    public void update (TestConfigBeen testConfigBeen);
    public void delete (TestConfigBeen testConfigBeen);
    public TestConfigBeen toBeen(TestConfig testConfig);
    public TestConfigBeen getTestConfigBeensEnable (int courseId);
    TestConfig getTestConfigByCource(Course course);
}
