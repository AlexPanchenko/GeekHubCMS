package org.geekhub.service.impl;

import org.geekhub.hibernate.entity.User;
import org.geekhub.service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by user on 13.05.2015.
 */
@Service
@Transactional
public class UserServiceImpl extends GenericServiceImpl<User> implements UserService {
}
