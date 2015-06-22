package org.geekhub.service.impl;

import org.geekhub.hibernate.bean.CourseBean;
import org.geekhub.hibernate.bean.QuestionBean;
import org.geekhub.hibernate.dao.CourseDao;
import org.geekhub.hibernate.dao.QuestionDao;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.Question;
import org.geekhub.hibernate.entity.TestType;
import org.geekhub.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by helldes on 15.05.2015.
 */
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    QuestionDao questionDao;

    @Autowired
    CourseDao courseDao;

    public List<Question> getAll() {
        return (List<Question>)questionDao.getAll();
    }


    @Override
    public Question read(int questionId) {
        Question question = (Question)questionDao.read(questionId, Question.class);
        return question;
    }

    @Override
    public void update(QuestionBean questionBean) {
        Question question = (Question) questionDao.read(questionBean.getId(), Question.class);
        question.setQuestionText(questionBean.getQuestionText());
        question.setQuestionCode(questionBean.getQuestionCode());
        question.setQuestionWeight(questionBean.getQuestionWeight());
        question.setCourse((Course)courseDao.read(questionBean.getCourse(), Course.class));
        question.setMyAnswer(questionBean.getMyAnswer());
        question.setQuestionStatus(questionBean.getQuestionStatus());
        question.setTestType(questionBean.getTestType());
        question.setManyAnswers(questionBean.getManyAnswers());
        questionDao.update(question);
    }

    @Override
    public void delete(int questionId) {
        questionDao.delete(questionDao.read(questionId, Question.class));
    }

    @Override
    public List<Question> getQuestionsByCourse(CourseBean courseBean) {
        return questionDao.getByCourse(courseDao.getCourseByName(courseBean.getName()));
    }

    @Override
    public List<Question> getQuestionsByTestType(TestType testType) {
        return questionDao.getByTestType(testType);
    }

    @Override
    public List<Question> getQuestionsByCourseWithoutTestType(CourseBean courseBean) {
        return questionDao.getByCourseWithoutTestType(courseDao.getCourseByName(courseBean.getName()));
    }

    @Override
    public Long getQuestionsCount() {
        return questionDao.getQuestionsCount();
    }

    @Override
    public List<Question> getQuestionsOnOnePage(int pageIndex, int offset) {
        return questionDao.getQuestionsOnOnePage(pageIndex, offset);
    }

    @Override
    public void saveOrUpdate(Question question) {
        questionDao.saveOrUpdate(question);
    }
}
