package org.geekhub.service.impl;

import org.geekhub.hibernate.dao.ClassroomDao;
import org.geekhub.hibernate.entity.ClassRoom;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.User;
import org.geekhub.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class ClassroomServiceImpl implements ClassroomService {

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
}
