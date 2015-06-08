package org.geekhub.hibernate.dao;

import org.geekhub.hibernate.entity.Note;

import java.util.List;

    public interface NoteDao extends BaseDao {

        public List<Note> getNotesListBySender(int userId);

        public List<Note> getNotesListByReceiver(int userId);
    }
