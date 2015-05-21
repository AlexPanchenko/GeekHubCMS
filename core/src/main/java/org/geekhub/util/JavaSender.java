package org.geekhub.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component("javaSender")
public class JavaSender {
    
    @Autowired
    private MailSender mailSender;

    @Autowired
    private SimpleMailMessage preConfigMessage;

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMessage(String from, String to, String subject, String msg){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(msg);
        mailSender.send(message);
    }

    public void sendMessageFromPersistEmail(String to,String subj, String msg){
        SimpleMailMessage message = new SimpleMailMessage(preConfigMessage);
        message.setTo(to);
        message.setText(msg);
        message.setSubject(subj);
        mailSender.send(message);
    }
}
