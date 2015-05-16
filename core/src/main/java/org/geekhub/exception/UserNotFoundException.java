package org.geekhub.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by admin on 15.05.2015.
 */
public class UserNotFoundException extends UsernameNotFoundException {
    public UserNotFoundException(String msg){
        super(msg);
    }
}
