package org.geekhub.hibernate.dao.impl;

import org.geekhub.hibernate.dao.NoteDao;
import org.geekhub.hibernate.entity.Note;
import org.geekhub.hibernate.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class NoteDaoImpl extends BaseDaoImpl implements NoteDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override

    public List<Note> getNotesListBySender(User user) {
        List<Note> notesListBySender = (List<Note>) sessionFactory.getCurrentSession().createCriteria(Note.class).add(Restrictions.eq("sender", user)).list();
        return notesListBySender;
    }

    @Override
    public List<Note> getNotesListByReceiver(User user) {
        List<Note> notesListByReceiver = (List <Note>) sessionFactory.getCurrentSession().createCriteria(Note.class).add(Restrictions.eq("receiver", user)).list();
        return  notesListByReceiver;
    }

   }


