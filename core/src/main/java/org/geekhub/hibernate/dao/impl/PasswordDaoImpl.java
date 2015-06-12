package org.geekhub.hibernate.dao.impl;

import org.geekhub.hibernate.dao.PasswordDao;
import org.geekhub.hibernate.entity.PasswordLink;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PasswordDaoImpl extends BaseDaoImpl implements PasswordDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public PasswordLink getPasswordLinkById(int passwordLinkID) {
        PasswordLink pl = (PasswordLink) sessionFactory.getCurrentSession().createCriteria(PasswordLink.class).add(Restrictions.eq("id",passwordLinkID)).list().get(0);
        return pl;
    }

    @Override
    public void deleteLink(PasswordLink passwordLink) {
        sessionFactory.getCurrentSession().delete(passwordLink);
    }
}
