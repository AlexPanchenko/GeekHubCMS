package org.geekhub.hibernate.dao;

import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.Question;
import org.geekhub.hibernate.entity.TestType;

import java.util.List;

/**
 * Created by helldes on 15.05.2015.
 */
public interface QuestionDao extends BaseDao{
    public List<Question> getAll();
    public List<Question> getByCourse(Course course);
    public List<Question> getByTestType(TestType testType);
    public List<Question> getByCourseWithoutTestType(Course course);
    public Question getQuestionWithId(Question question);
    Long getQuestionsCount();
    Long getQuestionsCountByCourse(Course course);
    Long getQuestionsCountByCourseAndTestType(Course course, TestType testType);

    List<Question> getQuestionsOnOnePage(int pageIndex, int limit);
    List<Question> getQuestionsOnOnePageByCourse(int pageIndex, Integer limit, Course course);
    List<Question> getQuestionsOnOnePageByCourseAndTestType(int pageIndex, Integer limit, Course course, TestType testType);

    public void saveOrUpdate(Question question);
}
