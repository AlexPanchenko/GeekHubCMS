package org.geekhub.controllers;

import org.geekhub.entity.Role;
import org.geekhub.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

/**
 * Created on 14.05.2015.
 *
 * @Author Odahovskiy (odahovskiy@gmail.com)
 * @Author Palyvoda (jekainfinity@gmail.com)
 */
@Controller
@RequestMapping(value = "/dashboard")
public class AdminController {

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "adminpanel/index";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users(ModelMap model) {
        List<User> users = new ArrayList<>();
        User u = new User();
        u.setBirthDay(new Date());
        u.setId(1);
        u.setFirstName("Test1");
        u.setEmail("Ivan@mail.ru");
        u.setIcq("4118377166");
        u.setLastName("Test");
        u.setPatronymic("Test");
        u.setLogin("Ivan123");
        u.setPassword("1234512");
        u.setRegistrationDate(new Date());
        u.setPhoneNumber("+380(93)145-1514");
        for (int i = 0; i < 5; i++) users.add(u);
        model.addAttribute("users",users);
        return "adminpanel/users";
    }

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String courses() {
        return "adminpanel/courses";
    }

    @RequestMapping(value = "/users/{userId}/edit", method = RequestMethod.GET)
    public String courses(ModelMap model) throws Exception {
        try{
            return "adminpanel/user-edit";
        }catch (Exception ex) {
            throw new Exception(ex);
        }
    }
}
