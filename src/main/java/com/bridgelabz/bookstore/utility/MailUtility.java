package com.bridgelabz.bookstore.utility;

import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class MailUtility {

    public String sendOtp(int otp) throws MessagingException {
        String message = "Hello, here is the otp for verification "+otp;
        String subject = "otp generation";
        String to="sairam.301097@gmail.com";
        String from="sairam.301097@gmail.com";

        String host = "smtp.gmail.com";
        Properties properties=System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session=Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("sairam.301097@gmail.com","9912716375");
            }
        });
        session.setDebug(true);
        MimeMessage mimeMessage=new MimeMessage(session);
        mimeMessage.setFrom(from);
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        mimeMessage.setSubject(subject);
        mimeMessage.setText(message);
        Transport.send(mimeMessage);

        return "otp sent!!!";
    }
    public String sendOtpTo(int otp,String token,String to) throws MessagingException {
        String message = "Hello, here is the otp for verification "+otp+" and token is "+token;
        String subject = "otp generation";
        String from="sairam.301097@gmail.com";

        String host = "smtp.gmail.com";
        Properties properties=System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session=Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("sairam.301097@gmail.com","9912716375");
            }
        });
        session.setDebug(true);
        MimeMessage mimeMessage=new MimeMessage(session);
        mimeMessage.setFrom(from);
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        mimeMessage.setSubject(subject);
        mimeMessage.setText(message);
        Transport.send(mimeMessage);

        return "otp sent!!!";
    }

}
