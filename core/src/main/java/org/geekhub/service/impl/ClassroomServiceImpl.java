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

    public void createClassroom(Integer[] userId,int courseId,int teacherId){
        /*convert users id into List*/
        ArrayList<Integer> usersId = new ArrayList<>();
        for (int i = 0; i < userId.length; i++){
            usersId.add(userId[i]);
        }
        usersId.add(teacherId);

        /*Set users list*/
        ArrayList<User> users = new ArrayList<>(classroomDao.getUsersById(usersId));

        /*Make classroom set all fields*/
        ClassRoom classRoom = new ClassRoom();
        classRoom.setUsers(users);
        classRoom.setCourseId((Course) classroomDao.read(courseId,Course.class));

        /*save entity at db*/
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
        classroomDao.delete(classroomDao.read(classroomId,ClassRoom.class));
    }

}
