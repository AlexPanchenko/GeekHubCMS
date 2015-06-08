package org.geekhub.service;

import org.geekhub.hibernate.entity.UserResults;
import org.springframework.stereotype.Component;

/**
 * Created by user on 20.05.2015.
 */
@Component
public interface UserResultsService {
    public void setAnswerStatus( int usResId);
    Object read(int userResultId);
    void update(UserResults userResult);
    void delete(int userResultId);
    void delete(UserResults userResults);
    public UserResults create(int userId, int questionId);
}
