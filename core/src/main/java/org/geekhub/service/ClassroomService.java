package org.geekhub.service;

import org.geekhub.hibernate.bean.ClassRoomBean;

import java.util.ArrayList;
import java.util.List;

public interface ClassroomService {
    public void createClassroom(Integer[] userId,int courseId,int teacherId);
    public List<ClassRoomBean> getBeans();
    public void removeClassroomById(int classroomId);
}
