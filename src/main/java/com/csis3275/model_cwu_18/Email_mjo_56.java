package com.csis3275.model_cwu_18;

import java.util.Properties;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;

public class Email_mjo_56 {

	private String receiverEmail;

	public Email_mjo_56(String receiver) {
		this.receiverEmail = receiver;

	}

	public static void sendEmail(String receiver) throws AddressException, MessagingException {
		// provide access properties: props.put(key, value)
		Properties props = new Properties();
		props.put("mail.starttls.enable", "true");
		props.put("mail.setup.auth", "true");
		
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.setup.port", 587);
		
		props.put("mail.smtp.socketFactory.port", 587);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		//props.put("mail.smtp.timeout", 15000);
		//props.put("mail.smtp.socketFactory.port", 587);
		//props.put("mail.smtp.socketFactory.fallback", "true");
		//props.put("mail.smtp.port", "465");

		String rbsEmail = "strugglingdevelopers.rbs@gmail.com";
		String rbsPass = "RoomBookingSystem";

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(rbsEmail, rbsPass);
			}
		});

		// Prepare the content, set To and From
		Message content = new MimeMessage(session);
		content.setFrom(new InternetAddress(rbsEmail));
		content.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
		System.out.println(receiver);
		content.setSubject("Your appointment booking confirmation");
		content.setText("You have an appointment coming up soon!");

		// Send it!
		Transport.send(content);

	}
}
