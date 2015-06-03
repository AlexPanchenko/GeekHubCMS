package org.geekhub.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

public class AuthControllerHandle extends SavedRequestAwareAuthenticationSuccessHandler{
    @Override
    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = auth.getAuthorities().toString();
        System.out.println("In handler, role " + role);

        String url = "";
        if(role.equals("[ROLE_TEACHER]")){
            url = "/teacher";
        }
        if(role.equals("[ROLE_ADMIN]")){
            System.out.println("In admin");
            url = "/admin";
        }
        if(role.equals("[ROLE_STUDENT]")){
            url = "/student";
        }
        return url;
    }
}
