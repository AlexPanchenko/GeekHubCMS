package org.geekhub.service;

public interface RecoverPasswordService {
    public String getMail(String mail);
    public void recoverPassword(String newPassword, int id);
    public void sendRecover(String email);
}
