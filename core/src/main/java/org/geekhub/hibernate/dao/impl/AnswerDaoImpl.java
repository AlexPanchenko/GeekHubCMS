package org.geekhub.hibernate.dao.impl;

import org.geekhub.hibernate.dao.AnswerDao;
import org.geekhub.hibernate.entity.Answer;
import org.springframework.stereotype.Repository;

/**
 * Created by helldes on 15.05.2015.
 */
@Repository("answerDao")
public class AnswerDaoImpl extends GenericDaoImpl<Answer> implements AnswerDao {
}
