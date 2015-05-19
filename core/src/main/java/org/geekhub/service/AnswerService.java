package org.geekhub.service;

import org.geekhub.hibernate.entity.Answer;
import org.geekhub.hibernate.entity.Question;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by helldes on 15.05.2015.
 */
@Component
public interface AnswerService {
    public List<Answer> getAnswersByQuestion(Question question);
    Object read(int answerId);
    void create(Answer answer);
    void delete(Object read);
}