package com.alliance.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.alliance.dao.MailDAO;
import com.alliance.model.UserModel;

public class SendMail {
	
	
	public void sendMail(UserModel um)
	{
		 // Recipient's email ID needs to be mentioned.
	     
		MailDAO md=new MailDAO();
		String to = md.getMailID(um);

	      // Sender's email ID needs to be mentioned
	      String from = "alliance@gmail.com";

	      // Assuming you are sending email from localhost
	      String host = "localhost";

	      // Get system properties
	      Properties properties = System.getProperties();

	      // Setup mail server
	      properties.setProperty("mail.smtp.host", "smtp.gmail.com");
	      

	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(properties);

	      try {
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	         // Set Subject: header field
	         message.setSubject("This is the Subject Line!");

	         // Send the actual HTML message, as big as you like
	         message.setContent("<h1>This is actual message</h1>", "text/html");

	         // Send message
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      } catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	}
	

}
