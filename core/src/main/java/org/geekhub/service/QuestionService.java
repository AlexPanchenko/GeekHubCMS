package org.geekhub.service;

import org.geekhub.hibernate.entity.Course;
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
    public Question create(String questionText, Byte questionWeight, int courseId);
   // Question create(String questionText, Byte questionWeight, Boolean questionStatus, Boolean myAnswer, Boolean manyAnswers, int courseId);

    void update(int questionId, String questionText, byte questionWeight);
}
