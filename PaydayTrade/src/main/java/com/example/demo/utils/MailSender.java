package com.example.demo.utils;

import com.example.demo.models.User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class MailSender {

    User input = new User();
    String name = input.getName();
    String password = input.getPassword();

    public void sendMail(String toAddress, String name, String password, String message) {

        String host = "smtp.gmail.com";
        String from = "xxxx@xxxx.com";
        String to = toAddress;


        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", 25);
        props.put("mail.debug", "true");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");


        Session session = Session.getInstance(props, new GMailAuthenticator());

        try {


            Message msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(from));

            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);

            msg.setSentDate(new Date());

            msg.setText(name + "," + "\n" + message);

            Transport.send(msg);

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

    private class GMailAuthenticator extends Authenticator {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(name, password);
        }
    }
}
