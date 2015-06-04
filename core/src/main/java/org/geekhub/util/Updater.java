package org.geekhub.util;

import org.geekhub.hibernate.dao.TestAssignmentDao;
import org.geekhub.hibernate.entity.TestAssignment;
import org.geekhub.hibernate.entity.TestStatusAssignment;
import org.geekhub.service.TestAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 04.06.2015.
 */
@Component
@Transactional
public class Updater {

    @Autowired
    private TestAssignmentService testAssignmentService;

    @Autowired
    private TestAssignmentDao testAssignmentDao;

    @Scheduled(cron = "59 59 23 * * ?")
    public void updateTestAssignmentStatus() {

        List<TestAssignment> testAssignmentList = testAssignmentService.getAll();
        for (TestAssignment testAssignment: testAssignmentList){
            if(!testAssignment.getTestStatusAssignment().equals(TestStatusAssignment.PASSED)){
                if(new Date().getTime() >= testAssignment.getDateFinish().getTime()){
                    testAssignment.setTestStatusAssignment(TestStatusAssignment.OVERDUE);
                    testAssignmentDao.update(testAssignment);
                }
            }
        }
        System.out.println("TestStatusAssignment is update.");
    }
}
