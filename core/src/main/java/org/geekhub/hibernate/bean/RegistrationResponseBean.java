package org.geekhub.hibernate.bean;

/**
 * Created by admin on 20.05.2015.
 */
public class RegistrationResponseBean {

    private boolean success;
    private String errorMessage;

    public RegistrationResponseBean() {
    }

    public RegistrationResponseBean(boolean success, String errorMessage) {
        this.success = success;
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
