/**
 * 
 */
package com.cuisine_mart.user.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cuisine_mart.email.SmtpGmailSender;

/**
 * @author Sadiksha
 *
 */
@RestController
public class EmailController {
	@Autowired
	private SmtpGmailSender smtpGmailSender;

	@RequestMapping("/send-mail")
	public void sendMail() throws MessagingException {
		smtpGmailSender.send("sadikshadhakal@gmail.com", "test message", "This is a test message using javamail");
	}

}
