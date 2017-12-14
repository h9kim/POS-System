/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPos.Model;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Bhagya
 */
public class Forgetpassword {

    public void sendHtmlEmail(String host, String port, final String userName, final String password, String toAddress, String subject, String message) throws AddressException,
            MessagingException {

        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };

        Session session = Session.getInstance(properties, auth);

        // creates a new e-mail message
        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = {new InternetAddress(toAddress)};
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        // set plain text message
        msg.setContent(message, "text/html");

        Transport.send(msg);

    }


    public String sendMail(String mailTo) {
        String reval = "";
        org.hibernate.Session ses = BPos.Connection.NewHibernateUtil.getSessionFactory().openSession();
        Criteria cr = ses.createCriteria(BPos.DB.User.class);
        cr.add(Restrictions.eq("email", mailTo));
        BPos.DB.User us = (BPos.DB.User) cr.uniqueResult();
        if(us!=null){
        BPos.DB.UserLogin ul = (BPos.DB.UserLogin) ses.load(BPos.DB.UserLogin.class, us.getIdUser());

        String subject = "Forget Your Password";
        String message = "<h2>Recover Your Password?</h2><br>";
        message += "Your password is :- " + ul.getPassword();


        Forgetpassword mailer = new Forgetpassword();

        try {
            mailer.sendHtmlEmail("smtp.gmail.com", "587", "bsoftsoftwresolution@gmail.com", "bhagyasolution", mailTo, subject, message);
            System.out.println("Email sent.");
            reval = "send";
        } catch (Exception ex) {
            reval = ex.getMessage() + "";
            System.out.println("Failed to sent email.");
        }
        }else{
            reval ="Please enter valid email address!";
        }
        return reval;
    }
}
