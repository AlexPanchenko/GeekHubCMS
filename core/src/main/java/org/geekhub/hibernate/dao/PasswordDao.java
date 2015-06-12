package org.geekhub.hibernate.dao;

import org.geekhub.hibernate.entity.PasswordLink;

public interface PasswordDao extends BaseDao {
       public PasswordLink getPasswordLinkById(int passwordLink);

       void deleteLink(PasswordLink passwordLink);
}
