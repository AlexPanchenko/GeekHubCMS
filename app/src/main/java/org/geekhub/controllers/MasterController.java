package org.geekhub.controllers;

import org.geekhub.hibernate.bean.NoteBean;
import org.geekhub.hibernate.bean.UserBean;
import org.geekhub.hibernate.entity.Role;
import org.geekhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.Date;

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


}
