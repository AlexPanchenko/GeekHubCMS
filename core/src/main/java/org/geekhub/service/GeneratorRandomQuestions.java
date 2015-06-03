package org.geekhub.service;

import org.geekhub.hibernate.entity.Question;
import org.geekhub.hibernate.entity.TestType;

import java.util.List;

/**
 * Created by helldes on 24.05.2015.
 */
public interface GeneratorRandomQuestions {
    public List<Question> generatorRandomQuestionsAll(int questionCount, TestType testType);
}
