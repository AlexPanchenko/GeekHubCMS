package org.geekhub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String users() {
        return "adminpanel/users";
    }

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String courses() {
        return "adminpanel/courses";
    }
}
