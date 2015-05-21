package org.geekhub.service;

import org.geekhub.hibernate.bean.TestAssignmentBean;

import java.util.List;

/**
 * Created by helldes on 21.05.2015.
 */
public interface TestAssignmentService {
    public List<TestAssignmentBean> getTAByUserAndCourse(int courseId);
}
