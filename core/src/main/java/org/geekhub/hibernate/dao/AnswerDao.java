package org.geekhub.hibernate.dao;

import org.geekhub.hibernate.entity.Answer;
import org.geekhub.hibernate.entity.Question;

import java.util.List;


public interface AnswerDao  extends BaseDao {
    public List<Answer> getAnswersByQuestion(Question question);

    void saveOrUpdate(Answer answer);

    void delete(List<Integer> answerIdsToDelete);
}

