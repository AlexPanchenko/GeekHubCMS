package org.geekhub.service.impl;

import org.geekhub.hibernate.bean.ClassRoomBean;
import org.geekhub.hibernate.bean.CourseBean;
import org.geekhub.hibernate.bean.TestConfigBeen;
import org.geekhub.hibernate.bean.UserBean;
import org.geekhub.hibernate.dao.ClassroomDao;
import org.geekhub.hibernate.entity.ClassRoom;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.TestConfig;
import org.geekhub.hibernate.entity.User;
import org.geekhub.service.BeanService;
import org.geekhub.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSInput;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private BeanService beanService;

    @Autowired
    private ClassroomDao classroomDao;

    public void createClassroom(Integer[] userId,int courseId,int teacherId,String className,String classDescription){
        ClassRoom classRoom = new ClassRoom();
        classRoom.setCourseId((Course)classroomDao.read(courseId, Course.class));
        classRoom.setName(className);
        classRoom.setDescription(classDescription);
        if(userId != null) {
            ArrayList<Integer> usersId = new ArrayList<Integer>();
            for (int i = 0; i < userId.length; i++) {
                usersId.add(userId[i]);
            }
            usersId.add(teacherId);
            ArrayList<User> users = new ArrayList<>(classroomDao.getUsersById(usersId));
            ArrayList<User> usersInClass = new ArrayList<>();
            for (User u : users) {
                u.setClassroom(classRoom);
                usersInClass.add(u);
            }
            classRoom.setUsers(usersInClass);
        }
        classroomDao.create(classRoom);
    }

    @Override
    public List<ClassRoomBean> getBeans() {
        List<ClassRoomBean> classroomsBean = new ArrayList<>();
        List<ClassRoom> classroomEntity = new ArrayList<>();
        classroomEntity = classroomDao.getAll();

        for (ClassRoom classRoom: classroomEntity){
            classroomsBean.add(beanService.toClassroomBean(classRoom));
        }

    return classroomsBean;
    }

    @Override
    public void removeClassroomById(int classroomId){
        ClassRoom classRoom = (ClassRoom) classroomDao.read(classroomId, ClassRoom.class);
        List<User> users = classRoom.getUsers();
        for(User u: users){u.setClassroom(null);}
        classRoom.setUsers(users);
        if(classRoom.getTeacher()!= null) {
           classRoom.getTeacher().setClassroomTeacher(null);
        }
        classRoom.setTeacher(null);
        classRoom.setUsers(null);
        classroomDao.update(classRoom);
        classroomDao.delete(classroomDao.read(classroomId, ClassRoom.class));
    }

    @Override
    public ClassRoomBean getClassroom(int classroomId) {
        ClassRoom classroomEntity = classroomDao.getClassroom(classroomId);
        ClassRoomBean classRoom = beanService.toClassroomBean(classroomEntity);
        return classRoom;
    }

    @Override
    public void updateClassroom(Integer[] userId,int courseId,int teacherId,String className,String classDescription,int classroomId){
        ClassRoom classRoom = (ClassRoom) classroomDao.read(classroomId, ClassRoom.class);
//        List<User> users = classRoom.getUsers();
        if(userId != null) {
            ArrayList<Integer> usersId = new ArrayList<Integer>();
            for (int i = 0; i < userId.length; i++) {
                usersId.add(userId[i]);
            }
            usersId.add(teacherId);
            List<User> users = new ArrayList<>(classroomDao.getUsersById(usersId));
            List<User> usersInClass = new ArrayList<>();
            for (User u : users) {
                u.setClassroom(classRoom);
                usersInClass.add(u);
            }
            classRoom.setUsers(usersInClass);
        }
        classRoom.setName(className);
        classRoom.setDescription(classDescription);
        classRoom.setCourseId((Course) classroomDao.read(courseId, Course.class));
        classroomDao.update(classRoom);
    }

}
