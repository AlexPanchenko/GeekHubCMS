package org.geekhub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public ModelAndView defaultPage() throws IOException {
        return new ModelAndView("adminpanel/navigation");
    }

}
