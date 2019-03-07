package com.bookstore.utility;

import com.bookstore.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * The type Mail constructor.
 */
@Component
public class MailConstructor {
	@Autowired
	private Environment env;

	/**
	 * Construct reset token email simple mail message.
	 *
	 * @param contextPath the context path
	 * @param locale      the locale
	 * @param token       the token
	 * @param user        the user
	 * @param password    the password
	 * @return the simple mail message
	 */
	public SimpleMailMessage constructResetTokenEmail(
			String contextPath, Locale locale, String token, User user, String password
	) {

		String url = contextPath + "/newUser?token=" + token;
		String message = "\nPlease click on this link to verify your email and edit your personal information. Your password is: \n" + password;
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(user.getEmail());
		email.setSubject("Le's Bookstore - New User");
		email.setText(url + message);
		email.setFrom(env.getProperty("support.email"));
		return email;

	}
}
