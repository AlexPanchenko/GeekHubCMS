package org.geekhub.service;

import org.geekhub.hibernate.bean.ClassRoomBean;

import java.util.ArrayList;
import java.util.List;

public interface ClassroomService {
    public void createClassroom(Integer[] userId,int courseId,int teacherId,String className,String classDescription);
    public List<ClassRoomBean> getBeans();
    public void removeClassroomById(int classroomId);
    public ClassRoomBean getClassroom(int classroomId);
    public void updateClassroom(Integer[] userId,int courseId,int teacherId,String className,String classDescription,int classroomId);
}
