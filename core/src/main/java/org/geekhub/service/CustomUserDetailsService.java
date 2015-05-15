package org.geekhub.service;



import org.geekhub.hibernate.dao.impl.UserDaoImpl;
import org.geekhub.hibernate.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDaoImpl userDao;

    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        try {
            org.geekhub.hibernate.entity.User user = userDao.loadUserByUsername(userName);

            return new User(user.getLogin(),
                            user.getPassword(),
                            getAuthorities(user.getRoles()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<GrantedAuthority> getAuthorities(Role role) {
        return getGrantedAuthorities(role.toString());
    }

    public static List<GrantedAuthority> getGrantedAuthorities(String role) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }
}
