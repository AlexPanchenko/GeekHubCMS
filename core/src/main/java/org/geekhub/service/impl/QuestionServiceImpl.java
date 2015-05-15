package org.geekhub.service.impl;

import org.geekhub.hibernate.entity.Question;
import org.geekhub.service.QuestionService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by helldes on 15.05.2015.
 */
@Service
@Transactional
public class QuestionServiceImpl extends GenericServiceImpl<Question> implements QuestionService{
}
