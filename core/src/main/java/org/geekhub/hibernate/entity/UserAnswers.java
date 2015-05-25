package org.geekhub.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 20.05.2015.
 */
@Entity
@Table(name = "USER_ANSWERS")
public class UserAnswers extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "USER_ANSWERS_ID", unique = true, nullable = false)
    private int id;

    @Column(name = "CUSTOM_ANSWERS")
    private String CustomAnswer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_RESULTS_ID")
    private UserResults userResults;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ANSWER_ID")
    private Answer answer;

    public UserAnswers() {}

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
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

    public UserResults getUserResults() {
        return userResults;
    }

    public void setUserResults(UserResults userResults) {
        this.userResults = userResults;
    }
}
