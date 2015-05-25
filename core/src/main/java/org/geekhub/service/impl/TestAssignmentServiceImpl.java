package org.geekhub.service.impl;

import org.geekhub.hibernate.bean.TestAssignmentBean;
import org.geekhub.hibernate.dao.TestAssignmentDao;
import org.geekhub.service.TestAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by helldes on 21.05.2015.
 */
@Service
@Transactional
public class TestAssignmentServiceImpl implements TestAssignmentService {

    @Autowired
    TestAssignmentDao testAssignmentDao;

    @Override
    public List<TestAssignmentBean> getTAByUserAndCourse(int courseId) {
        return null;
    }
}
