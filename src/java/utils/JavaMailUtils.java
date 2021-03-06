/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ADMIN
 */
public class JavaMailUtils {

    public static void sendMail(String recepient, String verifyCode) throws MessagingException {

        Properties properties = System.getProperties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String from = "eventmanage93@gmail.com";
        String password = "Password_123456";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        Message message = prepareMessage(session, from, recepient, verifyCode);
        if (message != null) {
            Transport.send(message);
        }
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient, String verifyCode) throws MessagingException {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(myAccountEmail));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
        message.setSubject("SE Event CheckIn Code ");
        message.setText("Your CheckIn Code: " + verifyCode);
        return message;
    }
}
