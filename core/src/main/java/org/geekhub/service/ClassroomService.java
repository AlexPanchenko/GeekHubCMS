package org.geekhub.service;

import org.geekhub.hibernate.bean.ClassRoomBean;
import org.geekhub.hibernate.bean.UserBean;

import java.util.ArrayList;
import java.util.List;

public interface ClassroomService {
    public List<UserBean> getUserByClassroomId(int classRoomId);
    public List<UserBean> getTeacherByClassroomId(int classRoomId);
    public void createClassroom(Integer[] userId,int courseId,int teacherId,String className,String classDescription);
    public List<ClassRoomBean> getBeans();
    public List<ClassRoomBean> getBeansByCourseId(int courseId);
    public void removeClassroomById(int classroomId);
    public ClassRoomBean getClassroom(int classroomId);
    public void updateClassroom(Integer[] userId,int courseId,int teacherId,String className,String classDescription,int classroomId);
}
