package org.geekhub.service;

import org.geekhub.hibernate.bean.ClassRoomBean;
import org.geekhub.hibernate.bean.CourseBean;
import org.geekhub.hibernate.bean.TestConfigBeen;
import org.geekhub.hibernate.bean.UserBean;
import org.geekhub.hibernate.entity.ClassRoom;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.TestConfig;
import org.geekhub.hibernate.entity.User;

public interface BeanService {
    public UserBean toUserBean(User user);
    public CourseBean toCourseBean(Course course);
    public ClassRoomBean toClassroomBean(ClassRoom classRoom);
    public TestConfigBeen toTestConfigBean(TestConfig testConfig);
}
