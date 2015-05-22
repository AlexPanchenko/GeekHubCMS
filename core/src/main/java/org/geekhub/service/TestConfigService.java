package org.geekhub.service;


import org.geekhub.hibernate.bean.TestConfigBeen;

import java.util.List;

public interface TestConfigService {

    public List<TestConfigBeen> getTestConfigBeens (int courseId);
    public List<TestConfigBeen> getTestConfigBeensEnable (int courseId);
}
