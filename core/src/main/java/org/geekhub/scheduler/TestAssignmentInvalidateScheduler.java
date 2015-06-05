package org.geekhub.scheduler;

import org.geekhub.hibernate.dao.TestAssignmentDao;
import org.geekhub.hibernate.entity.TestAssignment;
import org.geekhub.hibernate.entity.TestStatusAssignment;
import org.geekhub.service.TestAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by admin on 05.06.2015.
 */
@Component
@Transactional
public class TestAssignmentInvalidateScheduler extends AbstractScheduler {

    @Autowired
    private TestAssignmentService testAssignmentService;

    @Autowired
    private TestAssignmentDao testAssignmentDao;

    @Scheduled(cron = "30 * * * * ?")
    public void updateTestAssignmentStatus() {
        List<TestAssignment> testAssignmentList = testAssignmentService.getOverdueTestAssignmentList();
        for (TestAssignment testAssignment: testAssignmentList){
                    testAssignment.setTestStatusAssignment(TestStatusAssignment.OVERDUE);
                    testAssignmentDao.update(testAssignment);
        }
        System.out.println("TestStatusAssignment is update.");
    }
}
