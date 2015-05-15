package org.geekhub.hibernate.dao.impl;

import org.geekhub.hibernate.dao.UserDao;
import org.geekhub.hibernate.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 13.05.2015.
 */
@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {
}
