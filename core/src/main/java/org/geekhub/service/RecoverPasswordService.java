package org.geekhub.service;

import org.geekhub.hibernate.entity.PasswordLink;

public interface RecoverPasswordService {
    public String getMail(String mail);
    public void recoverPassword(String newPassword, int id);
    public void sendRecover(String email);
    PasswordLink getPasswordLinkById(int id);
    void deleteUniqueLink(PasswordLink link);

}
