package org.geekhub.service.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.geekhub.hibernate.dao.PasswordDao;
import org.geekhub.hibernate.dao.UserDao;
import org.geekhub.hibernate.entity.PasswordLink;
import org.geekhub.hibernate.entity.User;
import org.geekhub.service.RecoverPasswordService;
import org.geekhub.util.JavaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Transactional
public class RecoverPasswordServiceImpl implements RecoverPasswordService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordDao passwordDao;

    @Autowired
    private JavaSender javaSender;

    @Override
    public void recoverPassword(String newPassword,int id) {
        PasswordLink pl = passwordDao.getUserId(id);
        User user = userDao.getUserById(pl.getUserId());
        System.out.println(newPassword);
        user.setPassword(newPassword);
        System.out.println("New User password  - " + user.getPassword());
        userDao.update(user);
    }

    /*method that redirect to you mail service*/
    @Override
    public String getMail(String mail) {
        Matcher m = Pattern.compile("@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+").matcher(mail);
        while (m.find()) {
            return (m.group()).replace("@","");
        }
        return null;
    }

    /*Send unique link to user and save this link to db*/
    @Override
    public void sendRecover(String email) {
        User user = userDao.getUserByEmail(email);
        String randomString = RandomStringUtils.random(20, true, true);
        PasswordLink passwordLink = new PasswordLink(user.getId(),randomString);
        passwordDao.create(passwordLink);

        String html = "<p> you may recover password if you redirect to this link </p><a href='http://localhost:8080/recoverPassword/" + passwordLink.getId() +"/" + randomString + "'>http://localhost:8080/recoverPassword/'" + passwordLink.getId() +"/" + randomString + "</a>";
        javaSender.sendMimeMessage("myjekauser@gmail.com",email,"Recover Password",html);
    }
}
