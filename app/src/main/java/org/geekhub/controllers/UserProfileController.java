package org.geekhub.controllers;

import org.geekhub.hibernate.bean.CourseBean;
import org.geekhub.hibernate.bean.UserBean;
import org.geekhub.hibernate.entity.Role;
import org.geekhub.hibernate.entity.User;
import org.geekhub.service.CourseService;
import org.geekhub.service.TestConfigService;
import org.geekhub.service.UserService;
import org.geekhub.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class UserProfileController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private TestConfigService testConfigService;

    @Autowired
    private UserService userService;

    @RequestMapping(value ="/userProfile", method = RequestMethod.GET)
    public ModelAndView userProfile(Principal principal){
        ModelAndView model = new ModelAndView("studentPage/userProfile");
        model.addObject("user",userService.getUserBeanByEmail(principal.getName()));
        return model;
    }

    @RequestMapping(value = "/users/{userId}/edit", method = RequestMethod.GET)
    public ModelAndView getEditUserPage(@PathVariable("userId") Integer userId, ModelMap model){
        ModelAndView modelAndView = new ModelAndView("studentPage/user-edit");
        User user = userService.getUserById(userId);
        modelAndView.addObject("roleList", Role.values());
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String editUser(@RequestParam("id") int id,
                           @RequestParam("first-name") String firstName,
                           @RequestParam("last-name") String lastName,
                           @RequestParam("email") String email,
                           @RequestParam("skype") String skype,
                           @RequestParam("phone") String phone,
                           @RequestParam("birthday") String birthday,
                           ModelMap model) {
        try {
            Date date = CommonUtil.getFormattedDate(birthday);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        UserBean userBean = new UserBean();
        userBean.setId(id);
        userBean.setFirstName(firstName);
        userBean.setLastName(lastName);
        userBean.setEmail(email);
        userBean.setSkype(skype);
        userBean.setPhoneNumber(phone);
        userService.updateUserByUserBean(userBean);
        return "redirect:/student";
    }
}

