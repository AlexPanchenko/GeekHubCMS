package org.geekhub.service;

import org.geekhub.hibernate.bean.*;
import org.geekhub.hibernate.entity.*;
import org.geekhub.hibernate.exceptions.CourseNotFoundException;

import java.util.List;

public interface BeanService {
    public List<testResWrapper> toTestResWrapper(TestAssignment testAssignment);
    public User toUserEntity(UserBean userBean);
    public UserBean toUserBean(User user);
    public CourseBean toCourseBean(Course course);
    public ClassRoomBean toClassroomBean(ClassRoom classRoom);
    public TestConfigBeen toTestConfigBean(TestConfig testConfig);
    public NoteBean toNoteBean (Note note);
    public TestAssignmentBean toTestAssignmentBean(TestAssignment testAssignment);
    public Question toQuestionEntity (QuestionBean questionBean) throws CourseNotFoundException;
    public TestTypeBean toTestTypeBean (TestType testType);
}
