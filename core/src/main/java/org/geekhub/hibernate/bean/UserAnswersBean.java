package org.geekhub.hibernate.bean;

/**
 * Created by user on 22.05.2015.
 */
public class UserAnswersBean {
    private int id;
    private String CustomAnswer;
    private UserResultsBean userResultsBean;

    public UserAnswersBean() {
    }

    public UserAnswersBean(int id, AnswerBean answerBean, UserResultsBean userResultsBean, String customAnswer) {
        this.id = id;
        this.userResultsBean = userResultsBean;
        CustomAnswer = customAnswer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomAnswer() {
        return CustomAnswer;
    }

    public void setCustomAnswer(String customAnswer) {
        CustomAnswer = customAnswer;
    }

    public UserResultsBean getUserResultsBean() {
        return userResultsBean;
    }

    public void setUserResultsBean(UserResultsBean userResultsBean) {
        this.userResultsBean = userResultsBean;
    }


}
