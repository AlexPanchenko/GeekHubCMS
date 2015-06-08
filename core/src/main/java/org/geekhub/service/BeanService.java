package org.geekhub.service;

import org.geekhub.hibernate.bean.*;
import org.geekhub.hibernate.entity.*;

public interface BeanService {
    public User toUserEntity(UserBean userBean);
    public UserBean toUserBean(User user);
    public CourseBean toCourseBean(Course course);
    public ClassRoomBean toClassroomBean(ClassRoom classRoom);
    public TestConfigBeen toTestConfigBean(TestConfig testConfig);
    public NoteBean toNoteBean (Note note);
}
