package org.geekhub.hibernate.dao.impl;

import org.geekhub.hibernate.dao.QuestionDao;
import org.geekhub.hibernate.entity.Question;
import org.springframework.stereotype.Repository;

/**
 * Created by helldes on 15.05.2015.
 */
@Repository("questionDao")
public class QuestionDaoImpl extends GenericDaoImpl<Question> implements QuestionDao{
}
