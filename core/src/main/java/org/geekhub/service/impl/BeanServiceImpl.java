package org.geekhub.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.geekhub.hibernate.bean.*;
import org.geekhub.hibernate.entity.*;
import org.geekhub.service.BeanService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BeanServiceImpl implements BeanService {

    @Override
    public List<testResWrapper> toTestResWrapper(TestAssignment testAssignment) {
        testResWrapper testResWrapper;
        List<org.geekhub.hibernate.bean.testResWrapper> testResWrappers = new ArrayList<org.geekhub.hibernate.bean.testResWrapper>();

        for (UserResults userResult: testAssignment.getUserResults()){
            testResWrapper = new testResWrapper();
            testResWrapper.setTestAssignmentId(testAssignment.getId());
            testResWrapper.setQuestion(userResult.getQuestion());
            testResWrapper.setUserAnswers(userResult.getUserAnswerses());

            if((userResult.isRightAnswer()) && (userResult.getQuestion().getMyAnswer())){
                testResWrapper.setRight(true);
            }
            if((!userResult.isRightAnswer()) && (userResult.getQuestion().getMyAnswer())){
                testResWrapper.setRight(false);
            }
            if(!userResult.getQuestion().getMyAnswer()){
                for (Answer answer: userResult.getQuestion().getAnswers()){
                    for (UserAnswers userAnswers: userResult.getUserAnswerses()){
                        if ((userAnswers.getAnswer().getId() == answer.getId()) && (answer.getAnswerRight())){
                            testResWrapper.setRight(true);
                        }else {
                            testResWrapper.setRight(false);
                        }
                    }
                }
            }
            testResWrapper.setReview(testAssignment.isStatusReview());
            testResWrapper.setScore(testAssignment.getCountTrueAnswers());

            testResWrappers.add(testResWrapper);
        }
        return testResWrappers;
    }

    @Override
    public User toUserEntity(UserBean userBean) {
        User user = new User();
        user.setLastName(userBean.getLastName());
        user.setFirstName(userBean.getFirstName());
        user.setEmail(userBean.getEmail());
        user.setPhoneNumber(userBean.getPhoneNumber());
        user.setSkype(userBean.getSkype());
        user.setEnable(userBean.getEnable());
        user.setBirthDay(userBean.getBirthDay());
        user.setRole(userBean.getRole());
        user.setRegistrationDate(userBean.getRegistrationDate());
        user.setPassword(DigestUtils.md5Hex(userBean.getPassword()));
        return user;
    }

    @Override
    public UserBean toUserBean(User user) {
        UserBean userBean = new UserBean();
        userBean.setId(user.getId());
        userBean.setLastName(user.getLastName());
        userBean.setFirstName(user.getFirstName());
        userBean.setEmail(user.getEmail());
        userBean.setPhoneNumber(user.getPhoneNumber());
        userBean.setEnable(user.getEnable());
        userBean.setSkype(user.getSkype());
        userBean.setBirthDay(user.getBirthDay());
        userBean.setRole(user.getRole());
        userBean.setRegistrationDate(user.getRegistrationDate());
        userBean.setPassword(user.getPassword());
        return userBean;
    }

    @Override
    public CourseBean toCourseBean(Course course) {
        CourseBean courseBean = new CourseBean();
        courseBean.setDescription(course.getDescription());
        courseBean.setId(course.getId());
        courseBean.setName(course.getName());
/*
        courseBean.setTestConfigListBeens(course.getTestConfig().stream().map(testConfig -> toTestConfigBean(testConfig)).collect(Collectors.toList()));
*/
        return courseBean;
    }

    @Override
    public TestConfigBeen toTestConfigBean(TestConfig testConfig) {
        TestConfigBeen testConfigBeen = new TestConfigBeen();
        testConfigBeen.setId(testConfig.getId());
        testConfigBeen.setCourseBean(toCourseBean(testConfig.getCourse()));
        testConfigBeen.setDateFinish(testConfig.getDateFinish());
        testConfigBeen.setDateStart(testConfig.getDateStart());
        testConfigBeen.setQuestionCount(testConfig.getQuestionCount());
        testConfigBeen.setStatus(testConfig.getStatus());
        testConfigBeen.setTimeToTest(testConfig.getTimeToTest());
        testConfigBeen.setTittle(testConfig.getTitle());
        return null;
    }

    @Override
    public NoteBean toNoteBean(Note note) {
        NoteBean noteBean = new NoteBean();
        noteBean.setId(note.getId());
        noteBean.setReceiver(note.getReceiver());
        noteBean.setSender(note.getSender());
        noteBean.setNoteText(note.getNoteText());
        noteBean.setDate(note.getDate());
        return noteBean;
    }

    @Override
    public ClassRoomBean toClassroomBean(ClassRoom classRoom) {
        ClassRoomBean classRoomBean = new ClassRoomBean();
        classRoomBean.setId(classRoom.getId());
        classRoomBean.setCourseId(toCourseBean(classRoom.getCourseId()));
        classRoomBean.setName(classRoom.getName());
        classRoomBean.setDescription(classRoom.getDescription());
//        classRoomBean.setTeacher(toUserBean(classRoom.getTeacher()));
        classRoomBean.setUsers(classRoom.getUsers().stream().map(user -> toUserBean(user)).collect(Collectors.toList()));
        return classRoomBean;
    }

    @Override
    public TestAssignmentBean toTestAssignmentBean(TestAssignment testAssignment) {
        TestAssignmentBean testAssignmentBean = new TestAssignmentBean();
        testAssignmentBean.setId(testAssignment.getId());
        testAssignmentBean.setUser(testAssignment.getUser());
        testAssignmentBean.setCountTrueAnswers(testAssignment.getCountTrueAnswers());
        testAssignmentBean.setTestStart(testAssignment.getDateStart());
        testAssignmentBean.setDatePassed(testAssignment.getDatePassed());
        testAssignmentBean.setTestFinish(testAssignment.getDateFinish());
        testAssignmentBean.setPassed(testAssignment.isPassed());
        testAssignmentBean.setTestConfig(testAssignment.getTestConfig());
        testAssignmentBean.setUserResults(testAssignment.getUserResults());
        testAssignmentBean.setTestStatusAssignment(testAssignment.getTestStatusAssignment());

        return testAssignmentBean;
    }
}
