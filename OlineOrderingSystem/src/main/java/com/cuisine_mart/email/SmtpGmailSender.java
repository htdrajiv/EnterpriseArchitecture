/**
 * 
 */
package com.cuisine_mart.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author Sadiksha
 *
 */
@Component
public class SmtpGmailSender {
	@Autowired
	private JavaMailSender javaMailSender;
	@Async
	public boolean send(String mail_to, String subject, String msg) throws MessagingException{
		boolean status = true;
		try{
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper;

			helper = new MimeMessageHelper(message, true);

			helper.setSubject(subject);
			helper.setTo(mail_to);
			helper.setText(msg, true);

			javaMailSender.send(message);
		}catch (MailException mailException){
			System.out.println("An error occured while sending an email to "+mail_to);
			System.out.println("Email Exception :: " + mailException);
			status = false;
		}
		return status;
	}
}
