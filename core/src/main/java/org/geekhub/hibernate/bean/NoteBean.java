package org.geekhub.hibernate.bean;

import org.geekhub.hibernate.entity.User;

import java.util.Date;

public class NoteBean {

    private int id;

    private User sender;

    private User receiver;

    private String noteText;

    private Date registrationDate;

    public NoteBean () {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public Date getDate() {
        return registrationDate;
    }

    public void setDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }
}
