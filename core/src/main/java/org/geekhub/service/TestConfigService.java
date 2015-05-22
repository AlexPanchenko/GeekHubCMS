package org.geekhub.service;


import org.geekhub.hibernate.bean.TestConfigBeen;

import java.util.List;

public interface TestConfigService {

    public TestConfigBeen getTestConfigById (int testConfigId);
    public List<TestConfigBeen> getTestConfigBeens (int courseId);

    public void update (TestConfigBeen testConfigBeen);

    public List<TestConfigBeen> getTestConfigBeensEnable (int courseId);
}
