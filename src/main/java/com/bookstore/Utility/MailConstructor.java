package com.bookstore.Utility;

import com.bookstore.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MailConstructor {

	@Autowired
	private Environment env;

	public SimpleMailMessage constructResetTokenMail(String contextPath, Locale locale, String token, User user, String password) {
		String url = contextPath = "/newUser?token" + token;
		String message = "\nplease click the link below to complete your registration. your password is:\n" + password;
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(user.getEmail());
		email.setSubject("Saint's Bookstore");
		email.setText(url + message);
		email.setFrom(env.getProperty("support.email"));
		return email;
	}

}
