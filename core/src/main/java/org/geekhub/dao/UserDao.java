package org.geekhub.dao;

import org.geekhub.entity.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDao {
    User getUserById(int userId);

    public void addUser(User user);

    public User loadUserByUsername(String userName) throws UsernameNotFoundException;
    public User getUserByEmail(String email) throws UsernameNotFoundException;
    public User getUserByLogin(String login) throws UsernameNotFoundException;
}
