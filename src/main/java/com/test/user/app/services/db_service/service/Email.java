package com.test.user.app.services.db_service.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Email {

    public void sendEmail() throws AddressException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("kusumajati51@gmail.com", "Kusuma12!");
            }
        });

        Message msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress("kusumajati51@gmail.com", false));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("kusumajati51@gmail.com"));
            msg.setSubject("Tutorials point email");
            msg.setContent("Tutorials point email", "text/html");
            msg.setSentDate(new Date());
         
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart = new MimeBodyPart();
            messageBodyPart.attachFile(new File("mail.txt"));
            messageBodyPart.setHeader("Content-Type", "text/plain; charset=\"us-ascii\"; name=\"mail.txt\"");
                     
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            MimeBodyPart attachPart = new MimeBodyPart();
         
            // attachPart.attachFile("/var/tmp/image19.png");
            multipart.addBodyPart(attachPart);
            msg.setContent(multipart);
            Transport.send(msg);   
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      
    }

    
}