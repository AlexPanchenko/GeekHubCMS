package org.geekhub.hibernate.dao;


import org.geekhub.hibernate.entity.TestAssignment;
import org.geekhub.hibernate.entity.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * Created by user on 13.05.2015.
 */

public interface UserDao extends BaseDao {

    public Long usersCount();
    public List<User> readAllUsers();
    public List<User> usersOnPage(int page, int limit);
    User getUserById(int userId);
    public void addUser(User user);
    public User loadUserByUsername(String email) throws UsernameNotFoundException;
    public User getUserByEmail(String email) throws UsernameNotFoundException;
    public List<User> getUserListByTestAssignment(TestAssignment testAssignment);
}
