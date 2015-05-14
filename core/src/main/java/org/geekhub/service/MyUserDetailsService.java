package org.geekhub.service;


import org.geekhub.dao.UserDaoImpl;
import org.geekhub.entity.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by use on 14.05.2015.
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDaoImpl userDao;

    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        org.geekhub.entity.User user = userDao.loadUserByUsername(userName);
        Set<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());

        return buildUserForAuthentication(user, authorities);
    }

    private User buildUserForAuthentication(org.geekhub.entity.User user, Set<GrantedAuthority> authorities) {
        return new User(user.getEmail(), user.getPassword(), authorities);
    }
    private Set<GrantedAuthority> buildUserAuthority(Set<Role> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<>();

        // Build user's authorities
        for (Role userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getName()));
        }

        Set<GrantedAuthority> Result = new HashSet<>(setAuths);

        return Result;
    }


}
