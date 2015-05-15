package org.geekhub.dao.interface_dao;

import org.geekhub.entity.User;

/**
 * Created by user on 13.05.2015.
 */
public interface UserDao {
    User getUserById(int userId);
}
