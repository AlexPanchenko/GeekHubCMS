package org.geekhub.controllers;

import org.apache.commons.codec.digest.DigestUtils;
import org.geekhub.hibernate.bean.NoteBean;
import org.geekhub.hibernate.bean.UserBean;
import org.geekhub.hibernate.entity.Role;
import org.geekhub.hibernate.entity.User;
import org.geekhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
public class MasterController {

    @Autowired
    private UserService userService;

        public void createFeedback(@PathVariable("userid") int userid,
                               Principal principal,
                               @RequestParam("feedback") String feedback,
                               HttpServletResponse response) throws IOException {

        UserBean userBean = userService.getUserBeanByEmail(principal.getName());
        NoteBean noteBean = new NoteBean();
        noteBean.setNoteText(feedback);
        noteBean.setReceiver(userService.getUserById(userid));
        noteBean.setSender(userService.getUserById(userBean.getId()));
        noteBean.setDate(new Date());
        userService.saveNote(noteBean);
        response.getWriter().write("OK");
    }

    @RequestMapping(value = "/users/{userId}/changepassword2", method = RequestMethod.GET)
    public void postChangePassword(@PathVariable("userId") Integer userId, ModelMap model,
                                   @RequestParam("oldpassword") String oldPassword,
                                   @RequestParam("newpassword") String newPassword,
                                   @RequestParam("confirmpassword") String confirmNewPassword,
                                   HttpServletResponse response) throws IOException {

        ModelAndView modelAndView = new ModelAndView("studentPage/changePassword");
        UserBean userBean = userService.getUserBeanById(userId);
        System.out.println(userBean.getPassword());
        System.out.println(DigestUtils.md5Hex(oldPassword));
        if (!userBean.getPassword().equals(DigestUtils.md5Hex(oldPassword))) {
            response.getWriter().write("Wrong Password");
            return;
        }
        if(!newPassword.equals(confirmNewPassword)) {
            response.getWriter().write("Wrong Confirmed Password");
            return;
        }
        userBean.setPassword(confirmNewPassword);
        userService.saveUser(userBean);
        response.sendRedirect("/student/userProfile");
    }


    public String viewUserProfile(ModelMap model,@PathVariable(value = "userId") int userId) {
        UserBean userBean = userService.getUserBeanById(userId);
        model.addAttribute("user", userBean);
        return "studentPage/userProfile";
    }



}
