package org.geekhub.service;

/**
 * Created by Aleksander on 22.05.2015.
 */
public interface RecoverPasswordService {
    public void recoverPassword(String newPassword,int id);
    public String getMail(String mail);
    public void sendRecover(String email);
}
