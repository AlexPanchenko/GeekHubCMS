package org.geekhub.service.impl;

import org.geekhub.hibernate.dao.CourseDao;
import org.geekhub.hibernate.dao.QuestionDao;
import org.geekhub.hibernate.dao.TestTypeDao;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.Question;
import org.geekhub.hibernate.entity.TestType;
import org.geekhub.service.GeneratorRandomQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by helldes on 20.05.2015.
 */
@Service
public class GeneratorRandomQuestionsImpl implements GeneratorRandomQuestions {

    @Autowired
    QuestionDao questionDao;

    @Autowired
    CourseDao courseDao;

    @Autowired
    TestTypeDao testTypeDao;

    public List<Question> generatorRandomQuestionsByLevel(int questionCount, Course course, int countEasyQuestion,
                                                   int countMediumQuestion, int countHardQuestion){
        ArrayList<Question> questionsListByCourse = (ArrayList)questionDao.getByCourse(course);
        ArrayList<Question> easyQuestionList = new ArrayList<>();
        ArrayList<Question> mediumQuestionList = new ArrayList<>();
        ArrayList<Question> hardQuestionList = new ArrayList<>();

        for(Question question: questionsListByCourse){
            switch (question.getQuestionWeight()){
                case 5:{
                    easyQuestionList.add(question); break;
                }
                case 10:{
                    mediumQuestionList.add(question); break;
                }
                case 15:{
                    hardQuestionList.add(question); break;
                }
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

    public List<Question> generatorRandomQuestionsAll(int questionCount, TestType testType) {
        List<Question> questionsListByCourse = (List) questionDao.getByTestType(testType);
        List<Question> questionsList = new LinkedList<>();

        for(int i=0; i < questionCount; i++) {
            int random = (int) (Math.random() * questionsListByCourse.size());
            questionsList.add(questionsListByCourse.get(random));
            questionsListByCourse.remove(questionsListByCourse.get(random));
        }
        return questionsList;
    }
}
