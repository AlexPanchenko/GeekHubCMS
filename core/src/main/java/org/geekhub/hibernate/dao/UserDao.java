package org.geekhub.hibernate.dao;

import org.geekhub.hibernate.entity.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by user on 13.05.2015.
 */
public interface UserDao extends GenericDao<User> {
    User getUserById(int userId);

    public void addUser(User user);

    public User loadUserByUsername(String email) throws UsernameNotFoundException;
    public User getUserByEmail(String email) throws UsernameNotFoundException;
    public User getUserByLogin(String login) throws UsernameNotFoundException;
}
