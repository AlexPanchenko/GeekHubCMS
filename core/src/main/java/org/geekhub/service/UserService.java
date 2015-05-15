package org.geekhub.service;

import org.geekhub.hibernate.entity.User;

/**
 * Created by user on 13.05.2015.
 */
public interface UserService {
    User getUserById(int userId);

}
