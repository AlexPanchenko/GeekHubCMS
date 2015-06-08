package org.geekhub.service;


import org.geekhub.hibernate.bean.TestConfigBeen;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.TestConfig;
import org.geekhub.hibernate.entity.TestStatus;
import org.geekhub.hibernate.entity.TestType;

import java.util.Date;
import java.util.List;

public interface TestConfigService {

    public TestConfigBeen getTestConfigById (int testConfigId);
    public TestConfig getTestConfigByID(int testConfigId);
    public TestConfigBeen getTestConfigBeen (int courseId);
    public void createTestConfig (TestConfigBeen testConfigBeen);
    public void createTestConfig (TestConfig testConfig);
    public void update (TestConfigBeen testConfigBeen);
    public void delete (TestConfigBeen testConfigBeen);
    public void deleteById (int id);
    public TestConfigBeen toBeen(TestConfig testConfig);
    public TestConfigBeen getTestConfigBeenEnable (int courseId);
    public TestConfigBeen getTestConfigBeensEnable (int courseId);
    TestConfig getTestConfigByCource(Course course);
    public List<TestConfig> getAll();
    public void updateByParams(int id, String title, int questionCount, Date dateStart, Date dateFinish, int timeToTest, TestStatus status, TestType testType);
    public boolean isRemovable(TestConfig testConfig);
}
