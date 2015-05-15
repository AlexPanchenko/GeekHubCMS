package org.geekhub.service;

import org.geekhub.hibernate.entity.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import java.text.ParseException;
import java.util.Date;

@Component
public interface UserService extends GenericService<User> {
    public User getUserById(int userId);
    public User getUserByEmail(String email) throws UsernameNotFoundException;
    public User getUserByLogin(String login) throws UsernameNotFoundException;


    public String addUser(String login, String password, String firstName, String lastName,
                          String patronymic, String email, String skype, String phoneNumber, String confirmPassword, String date, Date dataRegistration) throws ParseException;
}
