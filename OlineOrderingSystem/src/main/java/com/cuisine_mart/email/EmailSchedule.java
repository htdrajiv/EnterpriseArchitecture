/**
 * 
 */
package com.cuisine_mart.email;

import com.cuisine_mart.user.service.IServiceContract.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.text.SimpleDateFormat;



/**
 * @author Sadiksha
 *
 */
@Component
@EnableScheduling
public class EmailSchedule {
	@Autowired
	IUserService userService;
	
	@Autowired
	private SmtpGmailSender smtpGmailSender;
	
	SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy HH:mm:SS");

	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {
		
	}

	
	@Scheduled(cron = "0/5 * * * * *")
	public void deleteInActiveUserFromDatabaseCron() throws MessagingException {
		//System.out.println("-----------schedule test----------");

//		try {
//
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
//			List<User> users = userService.getAllUsers();
//			DateTime da = new DateTime();
//			for (User u : users) {
//				if (u.getCreatedDate() != null) {
//					Date date = sdf.parse(u.getCreatedDate().toString());
//					DateTime dt = new DateTime(date);
//					if (da.minus(1).isAfter(dt)) {
//						String str = "Please confirm your email by click on following link "+"http://localhost:9080/validateUser/"+u.getUsername();
//						smtpGmailSender.send(u.getEmail(), "Please confirm your registration", str);
//						System.out.println("User successfully signed up and email already sent");
//					}
//				}
//			}
//
//		} catch (ParseException ex) {
//			ex.printStackTrace();
//		}
	}
}
