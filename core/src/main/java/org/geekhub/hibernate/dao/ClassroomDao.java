package org.geekhub.hibernate.dao;

import org.geekhub.hibernate.entity.User;

import java.util.ArrayList;
import java.util.List;

public interface ClassroomDao extends BaseDao {
    public List<User> getUsersById(ArrayList<Integer> usersId);
}
