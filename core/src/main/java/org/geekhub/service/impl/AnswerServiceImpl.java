package org.geekhub.service.impl;

import org.geekhub.hibernate.entity.Answer;
import org.geekhub.service.AnswerService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by helldes on 15.05.2015.
 */
@Service
@Transactional
public class AnswerServiceImpl extends GenericServiceImpl<Answer> implements AnswerService{
}
