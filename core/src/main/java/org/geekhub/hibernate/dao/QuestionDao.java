package org.geekhub.hibernate.dao;

import org.geekhub.hibernate.entity.Question;

import java.util.List;

/**
 * Created by helldes on 15.05.2015.
 */
public interface QuestionDao extends BaseDao{
    public List<Question> getAll();
}
