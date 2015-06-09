package org.geekhub.hibernate.dao;

import org.geekhub.hibernate.entity.Note;
import org.geekhub.hibernate.entity.User;

import java.util.List;

    public interface NoteDao extends BaseDao {

        public List<Note> getNotesListBySender(User user);

        public List<Note> getNotesListByReceiver(User user);

    }
