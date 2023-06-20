package com.example.relaxwikiapi.service;

import com.example.relaxwikiapi.entity.EmailSubscibers;
import com.example.relaxwikiapi.repo.EmailSubscibersRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private EmailSubscibersRepository emailSubscibersRepository;

    public boolean sendEmail(String Email){
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setTo(Email);
            helper.setSubject("www.Relaxwiki.com");
            helper.setText("Congratulations... Now you are a Relaxwiki Subscriber... ");
            javaMailSender.send(message);
            return true;
        }catch (MessagingException e){
            e.printStackTrace();
            return false;
        }
    }

    public void saveSubscriber(String email){
        EmailSubscibers emailSubsciber = new EmailSubscibers();
        emailSubsciber.setEmail(email);
        this.emailSubscibersRepository.save(emailSubsciber);
    }
}
