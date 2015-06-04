package org.geekhub.service;

import org.geekhub.hibernate.entity.UserAnswers;
import org.springframework.stereotype.Component;

/**
 * Created by user on 20.05.2015.
 */
@Component
public interface UserAnswersService {
    Object read(int userAnswersId);
    void update(UserAnswers userAnswers);
    void delete(int userAnswersId);
    void delete(UserAnswers userAnswers);
    public UserAnswers create(int userResultId, int answerId);
}
