package org.geekhub.service;

import org.geekhub.hibernate.entity.User;
import org.springframework.stereotype.Component;
import java.text.ParseException;
import java.util.Date;

@Component
public interface UserService extends GenericService<User> {
    User getUserById(int userId);


    public String addUser(String login, String password, String firstName, String lastName,
                          String patronymic, String email, String skype, String phoneNumber, String confirmPassword, String date, Date dataRegistration) throws ParseException;
}
