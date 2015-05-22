package org.geekhub.service;

import org.geekhub.hibernate.bean.QuestionBean;
import org.geekhub.hibernate.entity.Question;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by helldes on 15.05.2015.
 */
@Component
public interface QuestionService{
    List<Question> getAll();
    Object read(int questionId);
    void delete(int questionId);
    int create(QuestionBean questionBean);

    void update(int questionId, String questionText, byte questionWeight);
}
