package org.geekhub.service;

import org.geekhub.hibernate.bean.TestInfo;

/**
 * Created by admin on 26.05.2015.
 */
public interface TestResultService {
    public void  parseResult(TestInfo[] testInfos, int testConfigId);
}
