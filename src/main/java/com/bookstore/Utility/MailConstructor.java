package com.bookstore.utility;

import com.bookstore.domain.Order;
import com.bookstore.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Locale;

/**
 * The type Mail constructor.
 */
@Component
public class MailConstructor {
	@Autowired
	private Environment env;

	@Autowired
	private TemplateEngine templateEngine;

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

	/**
	 * Construct order confirmation email mime message preparator.
	 *
	 * @param user   the user
	 * @param order  the order
	 * @param locale the locale
	 * @return the mime message preparator
	 */
	public MimeMessagePreparator constructOrderConfirmationEmail(User user, Order order, Locale locale) {
		Context context = new Context();
		context.setVariable("order", order);
		context.setVariable("user", user);
		context.setVariable("cartItemList", order.getCartItemList());
		String text = templateEngine.process("orderConfirmationEmailTemplate", context);

		MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper email = new MimeMessageHelper(mimeMessage);
				email.setTo(user.getEmail());
				email.setSubject("Order Confirmation - " + order.getId());
				email.setText(text, true);
				email.setFrom(new InternetAddress("yashkaveeshwar@gmail.com"));
			}
		};

		return messagePreparator;
	}

}
