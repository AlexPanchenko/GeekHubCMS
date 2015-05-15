package org.geekhub.util;

/**
 * Created by admin on 14.05.2015.
 */
public class FormValidator {

    public String validateForm(String password, String firstName, String lastName, String patronymic,
                               String email,String confirmPassword, String login){
        if(email.equals("")){
            return "Email is empty";
        } else if(firstName.equals("")){
            return "First name is empty";
        } else if(lastName.equals("")){
            return "Last name is empty";
        } else if(patronymic.equals("")) {
            return "Patronymic is empty";
        } else if(login.equals("")) {
            return "Login is empty";
        }else if(password.length()<6){
            return "Password length should be more than 6 characters";
        } else if(!password.equals(confirmPassword)){
            return "Password doesn't match";
        } else {
            return null;
        }
    }
}
