package org.geekhub.service.impl;

import org.geekhub.hibernate.dao.CourseDao;
import org.geekhub.hibernate.dao.TestTypeDao;
import org.geekhub.hibernate.entity.*;
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

    @Autowired
    private CourseDao courseDao;


    @Override
    public List<TestType> getList() {
        return testTypeDao.getList();
    }

    @Override
    public void create(String name, int courseId) {
        TestType testType = new TestType();
        testType.setName(name);
        testType.setCourse((Course) courseDao.read(courseId, Course.class));
        testTypeDao.create(testType);
    }

    @Override

    public List<TestType> getListByCourseId(int courseId) {
        return testTypeDao.getListByCource((Course) courseDao.read(courseId, Course.class));
    }

    @Override
    public TestType getTestTypeById(int testTypeId) {
        return (TestType) testTypeDao.read(testTypeId, TestType.class);
    }

    public void deleteById(int id) {
        TestType testType = (TestType) testTypeDao.read(id, TestType.class);
        for(TestConfig testConfig: testType.getTestConfigList()){
            testConfig.setStatus(TestStatus.INACTIVE);
            testConfig.setTestType(null);
        }

        for(Question question: testType.getQuestionList()){
            question.setTestType(null);
        }
        if(testType.getCourse() != null) {
            testType.getCourse().getTestTypeList().remove(testType);
        }
        testTypeDao.update(testType);
        testTypeDao.delete(testType);
    }



    @Override
    public void changeTestType(int id, String name, int courseId) {
        TestType testType = (TestType) testTypeDao.read(id, TestType.class);
        testType.setName(name);
        testType.setCourse((Course) courseDao.read(courseId, Course.class));

    }
}
