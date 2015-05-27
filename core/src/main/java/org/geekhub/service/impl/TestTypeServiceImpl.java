package org.geekhub.service.impl;

import org.geekhub.hibernate.dao.TestTypeDao;
import org.geekhub.hibernate.entity.TestType;
import org.geekhub.service.TestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by admin on 27.05.2015.
 */
@Service
@Transactional
public class TestTypeServiceImpl implements TestTypeService {

    @Autowired
    private TestTypeDao testTypeDao;


    @Override
    public List<TestType> getList() {
        return testTypeDao.getList();
    }
}
