package org.geekhub.hibernate.dao.impl;

import org.geekhub.hibernate.dao.TestConfigDao;
import org.geekhub.hibernate.entity.BaseEntity;
import org.geekhub.hibernate.entity.Course;
import org.geekhub.hibernate.entity.TestConfig;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestConfigDaoImpl extends BaseDaoImpl implements TestConfigDao {
}
