package org.geekhub.hibernate.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "NOTES")
public class Note extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "FROM_USER_ID")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "TO_USER_ID")
    private User receiver;

    @Column(name = "TEXT")
    private String noteText;


    @Column(name = "DATE")
    private Date registrationDate;

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

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public Date getDate() {
        return registrationDate;
    }

    public void setDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}