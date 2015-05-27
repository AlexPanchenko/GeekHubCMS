package org.geekhub.service.impl;

import org.geekhub.hibernate.bean.ClassRoomBean;
import org.geekhub.hibernate.bean.CourseBean;
import org.geekhub.hibernate.bean.TestConfigBeen;
import org.geekhub.hibernate.bean.UserBean;
import org.geekhub.hibernate.entity.ClassRoom;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.TestConfig;
import org.geekhub.hibernate.entity.User;
import org.geekhub.service.BeanService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
@Transactional
public class BeanServiceImpl implements BeanService {
    @Override
    public UserBean toUserBean(User user) {
        UserBean userBean = new UserBean();
        userBean.setId(user.getId());
        userBean.setLastName(user.getLastName());
        userBean.setFirstName(user.getFirstName());
        userBean.setEmail(user.getEmail());
        userBean.setPhoneNumber(user.getPhoneNumber());
        userBean.setSkype(user.getSkype());
        userBean.setBirthDay(user.getBirthDay());
        userBean.setRole(user.getRole());
        userBean.setRegistrationDate(user.getRegistrationDate());
        return userBean;
    }

    @Override
    public CourseBean toCourseBean(Course course) {
        CourseBean courseBean = new CourseBean();
        courseBean.setDescription(course.getDescription());
        courseBean.setId(course.getId());
        courseBean.setName(course.getName());
        courseBean.setTestConfigListBeens(course.getTestConfig().stream().map(testConfig -> toTestConfigBean(testConfig)).collect(Collectors.toList()));
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
    public ClassRoomBean toClassroomBean(ClassRoom classRoom) {
        ClassRoomBean classRoomBean = new ClassRoomBean();
        classRoomBean.setId(classRoom.getId());
        classRoomBean.setCourseId(toCourseBean(classRoom.getCourseId()));
        classRoomBean.setUsers(classRoom.getUsers().stream().map(user -> toUserBean(user)).collect(Collectors.toList()));
        return classRoomBean;
    }
}
