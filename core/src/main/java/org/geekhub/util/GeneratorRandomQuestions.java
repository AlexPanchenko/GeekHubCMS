package org.geekhub.util;

import org.geekhub.hibernate.dao.QuestionDao;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by helldes on 20.05.2015.
 */
public class GeneratorRandomQuestions {

    @Autowired
    QuestionDao questionDao;

    public List<Question> GeneratorRandomQuestions(int questionCount, Course course, int countEasyQuestion,
                                                   int countMediumQuestion, int countHardQuestion){
        ArrayList<Question> questionsListByCourse = (ArrayList)questionDao.getByCourse(course);
        ArrayList<Question> easyQuestionList = new ArrayList<>();
        ArrayList<Question> mediumQuestionList = new ArrayList<>();
        ArrayList<Question> hardQuestionList = new ArrayList<>();

        for(Question question: questionsListByCourse){
            switch (question.getQuestionWeight()){
                

            }
        }

        List<Question> questionsList = new LinkedList<>();

        for(int i=0; i < questionCount; i++) {
            int random = (int) (Math.random() * questionsListByCourse.size());
            questionsList.add(questionsListByCourse.get(random));
            questionsListByCourse.remove(questionsListByCourse.get(random));
        }
        return questionsList;
    }
}
