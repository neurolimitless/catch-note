package com.catchnote.springmvc.service;

import com.catchnote.springmvc.dao.UserDao;
import com.catchnote.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailServiceImpl implements EmailService {

    @Autowired
    UserDao userDao;
    @Autowired
    JavaMailSender mailSender;


    public void sendValidationEmail(User user) {
        try {
            SimpleMailMessage validation = new SimpleMailMessage();
            validation.setFrom("CatchNote+");
            validation.setTo(user.getEmail());
            validation.setText("Hello! Thank you for registration at 'CatchNote+'\n"+
                    "To activate your account press this link:\n"+
                    "http://catchnote.us-west-2.elasticbeanstalk.com/validation?token="+user.getToken());
            validation.setSubject("Registration validation");
            mailSender.send(validation);
            System.out.println("Sending validation email to "+user.getName() + " "+user.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validateEmail(User user) {
        user.setValid(1);
        userDao.refresh(user);
    }
}
