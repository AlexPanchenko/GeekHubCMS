package org.geekhub.wrapper;

import org.geekhub.hibernate.entity.User;

/**
 * Created by admin on 02.06.2015.
 */
public class UserWrapper {
    private User user;
    private boolean isRegistered;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean getIsRegistered() {
        return isRegistered;
    }

    public void setIsRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }
}
