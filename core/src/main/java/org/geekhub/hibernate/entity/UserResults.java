package org.geekhub.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.geekhub.hibernate.entity.UserAnswers;
import org.geekhub.hibernate.entity.Question;
/**
 * Created by user on 19.05.2015.
 */
@Entity
@Table(name = "USER_RESULTS")
public class UserResults extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "USER_RESULTS_ID", unique = true, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userResults")
    List<UserAnswers> userAnswerses = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="QUESTION_ID")
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEST_ASSIGNMENT_ID")
    private TestAssignment testAssignment;

    @Column(name = "RIGHT_ANSWER")
    private boolean rightAnswer;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public TestAssignment getTestAssignment() {
        return testAssignment;
    }

    public void setTestAssignment(TestAssignment testAssignment) {
        this.testAssignment = testAssignment;
    }

    public UserResults() {
    }

    public boolean isRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(boolean rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<UserAnswers> getUserAnswerses() {
        return userAnswerses;
    }

    public void setUserAnswerses(List<UserAnswers> userAnswerses) {
        this.userAnswerses = userAnswerses;
    }
}
