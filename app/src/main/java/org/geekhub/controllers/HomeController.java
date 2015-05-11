package org.geekhub.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String defaultPage() throws IOException {
        return "GeekHub Home page";
    }

    @RequestMapping(value = "/error404")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String error404(HttpServletRequest request,
                           HttpServletResponse response) throws IOException {
        return "Page not found";
    }
}
