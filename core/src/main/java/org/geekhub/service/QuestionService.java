package org.geekhub.service;

import org.geekhub.hibernate.bean.CourseBean;
import org.geekhub.hibernate.bean.QuestionBean;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.Question;
import org.geekhub.hibernate.entity.TestType;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by helldes on 15.05.2015.
 */
@Component
public interface QuestionService{
    List<Question> getAll();
    List<Question> getQuestionsByCourse(CourseBean courseBean);
    List<Question> getQuestionsByTestType(TestType testType);
    List<Question> getQuestionsByCourseWithoutTestType(CourseBean courseBean);

    Question read(int questionId);
    void delete(int questionId);
    void update(QuestionBean questionBean);
    Long getQuestionsCount();
    Long getQuestionsCountByCourse(Course course);
    Long getQuestionsCountByCourseAndTestType(Course course, TestType testType);
    List<Question> getQuestionsOnOnePage(int pageIndex, int limit);
    List<Question> getQuestionsOnOnePageByCourse(int pageIndex, Integer limit, Course course);
    List<Question> getQuestionsOnOnePageByCourseAndTestType(int pageIndex, Integer limit, Course course, TestType testType);

    public void saveOrUpdate(Question question);
}
