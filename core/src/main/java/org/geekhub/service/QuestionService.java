package org.geekhub.service;

import org.geekhub.hibernate.entity.Question;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by helldes on 15.05.2015.
 */
@Component
public interface QuestionService{
    List<Question> getAll();
    void create(Question question);
    Object read(int questionId);
    void update(Question question);
}
