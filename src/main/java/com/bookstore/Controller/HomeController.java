package com.bookstore.controller;

import com.bookstore.domain.*;
import com.bookstore.domain.security.PasswordResetToken;
import com.bookstore.domain.security.Role;
import com.bookstore.domain.security.UserRole;
import com.bookstore.service.BookService;
import com.bookstore.service.UserPaymentService;
import com.bookstore.service.UserService;
import com.bookstore.service.UserShippingService;
import com.bookstore.service.impl.UserSecurityService;
import com.bookstore.utility.IndianStates;
import com.bookstore.utility.MailConstructor;
import com.bookstore.utility.SecurityUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.security.Principal;
import java.util.*;

/**
 * The type Home controller.
 */
@Controller
public class HomeController {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private MailConstructor mailConstructor;

	@Autowired
	private UserService userService;

	@Autowired
	private UserSecurityService userSecurityService;

	@Autowired
	private BookService bookService;

	@Autowired
	private UserPaymentService userPaymentService;

	@Autowired
	private UserShippingService userShippingService;

	/**
	 * Index string.
	 *
	 * @return the string
	 */
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	/**
	 * Login string.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("classActiveLogin", true);
		return "myAccount";
	}

	@RequestMapping("/hours")
	public String hours() {
		return "hours";
	}

	@RequestMapping("/faq")
	public String faq() {
		return "faq";
	}

	/**
	 * Bookshelf string.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping("/bookshelf")
	public String bookshelf(Model model) {
		List<Book> bookList = bookService.findAll();
		model.addAttribute("bookList", bookList);

		return "bookshelf";
	}

	/**
	 * Book detail string.
	 *
	 * @param id        the id
	 * @param model     the model
	 * @param principal the principal
	 * @return the string
	 */
	@RequestMapping("/bookDetail")
	public String bookDetail(
			@PathParam("id") Long id, Model model, Principal principal
	) {
		if (principal != null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
		}

		Book book = bookService.findOne(id);

		model.addAttribute("book", book);

		List<Integer> qtyList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		model.addAttribute("qtyList", qtyList);
		model.addAttribute("qty", 1);

		return "bookDetail";
	}

	/**
	 * Forget password string.
	 *
	 * @param request the request
	 * @param email   the email
	 * @param model   the model
	 * @return the string
	 */
	@RequestMapping("/forgetPassword")
	public String forgetPassword(
			HttpServletRequest request,
			@ModelAttribute("email") String email,
			Model model
	) {

		model.addAttribute("classActiveForgetPassword", true);

		User user = userService.findByEmail(email);

		if (user == null) {
			model.addAttribute("emailNotExist", true);
			return "myAccount";
		}

		String password = SecurityUtility.randomPassword();

		String encryptedPassword = SecurityUtility.passwordEncoder().encode(password);
		user.setPassword(encryptedPassword);

		userService.save(user);

		String token = UUID.randomUUID().toString();
		userService.createPasswordResetTokenForUser(user, token);

		String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();

		SimpleMailMessage newEmail = mailConstructor.constructResetTokenEmail(appUrl, request.getLocale(), token, user, password);

		mailSender.send(newEmail);

		model.addAttribute("forgetPasswordEmailSent", "true");


		return "myAccount";
	}

	/**
	 * My profile string.
	 *
	 * @param model     the model
	 * @param principal the principal
	 * @return the string
	 */
	@RequestMapping("/myProfile")
	public String myProfile(Model model, Principal principal) {
		User user = userService.findByUsername(principal.getName());
		model.addAttribute("user", user);

		model.addAttribute("userPaymentList", user.getUserPaymentList());
		model.addAttribute("userShippingList", user.getUserShippingList());
		/*model.addAttribute("orderList", user.getOrderList());*/

		UserShipping userShipping = new UserShipping();
		model.addAttribute("userShipping", userShipping);
		model.addAttribute("listOfCreditCard" ,true);
		model.addAttribute("listOfShippingAddresses", true);

		List<String> stateList = IndianStates.listOfINStatesCode;
		Collections.sort(stateList);
		model.addAttribute("stateList", stateList);
		model.addAttribute("classActiveEdit", true);
		return "myProfile";
	}

	/**
	 * List of credit cards string.
	 *
	 * @param request   the request
	 * @param model     the model
	 * @param principal the principal
	 * @return the string
	 */
	@RequestMapping("/listOfCreditCards")
	public String listOfCreditCards(HttpServletRequest request, Model model, Principal principal) {
		User user = userService.findByUsername(principal.getName());
		model.addAttribute("user", user);
		model.addAttribute("userPaymentList", user.getUserPaymentList());
		model.addAttribute("userShippingList", user.getUserShippingList());
		/*model.addAttribute("orderList", user.orderList());*/
		model.addAttribute("listOfCreditCards", true);
		model.addAttribute("classActiveBilling", true);
		model.addAttribute("listOfShippingAddresses", true);

		return "myProfile";
	}

	/**
	 * List of shipping addresses string.
	 *
	 * @param request   the request
	 * @param model     the model
	 * @param principal the principal
	 * @return the string
	 */
	@RequestMapping("/listOfShippingAddresses")
	public String listOfShippingAddresses(HttpServletRequest request, Model model, Principal principal) {
		User user = userService.findByUsername(principal.getName());
		model.addAttribute("user", user);
		model.addAttribute("userPaymentList", user.getUserPaymentList());
		model.addAttribute("userShippingList", user.getUserShippingList());
		/*model.addAttribute("orderList", user.orderList());*/
		model.addAttribute("listOfCreditCards", true);
		model.addAttribute("classActiveShipping", true);
		model.addAttribute("listOfShippingAddresses", true);

		return "myProfile";
	}

	/**
	 * Add new credit card string.
	 *
	 * @param model     the model
	 * @param principal the principal
	 * @return the string
	 */
	@RequestMapping("addNewCreditCard")
	public String addNewCreditCard(Model model, Principal principal) {
		User user = userService.findByUsername(principal.getName());
		model.addAttribute("user", user);
		model.addAttribute("addNewCreditCard", true);
		model.addAttribute("classActiveBilling", true);
		model.addAttribute("listOfShippingAddresses", true);
		UserBilling userBilling = new UserBilling();
		UserPayment userPayment = new UserPayment();
		model.addAttribute("userBilling", userBilling);
		model.addAttribute("userPayment", userPayment);

		List<String> stateList = IndianStates.listOfINStatesCode;
		Collections.sort(stateList);
		model.addAttribute("stateList", stateList);

		model.addAttribute("userPaymentList", user.getUserPaymentList());
		model.addAttribute("userShippingList", user.getUserShippingList());
		/*model.addAttribute("orderList", user.orderList());*/

		return "myProfile";
	}

	/**
	 * Add new shipping address string.
	 *
	 * @param model     the model
	 * @param principal the principal
	 * @return the string
	 */
	@RequestMapping("addNewShippingAddress")
	public String addNewShippingAddress(Model model, Principal principal) {
		User user = userService.findByUsername(principal.getName());
		model.addAttribute("user", user);
		model.addAttribute("addNewShippingAddress", true);
		model.addAttribute("listOfCreditCards", true);
		model.addAttribute("classActiveShipping", true);

		UserShipping userShipping = new UserShipping();

		model.addAttribute("userShipping", userShipping);

		List<String> stateList = IndianStates.listOfINStatesCode;
		Collections.sort(stateList);
		model.addAttribute("stateList", stateList);

		model.addAttribute("userPaymentList", user.getUserPaymentList());
		model.addAttribute("userShippingList", user.getUserShippingList());
		/*model.addAttribute("orderList", user.orderList());*/

		return "myProfile";
	}

	/**
	 * Add new shipping address string.
	 *
	 * @param userShipping the user shipping
	 * @param model        the model
	 * @param principal    the principal
	 * @return the string
	 */
	@RequestMapping(value = "addNewShippingAddress", method = RequestMethod.POST)
	public String addNewShippingAddress(@ModelAttribute("UserShipping") UserShipping userShipping, Model model, Principal principal) {
		User user = userService.findByUsername(principal.getName());
		userService.updateUserShipping(userShipping, user);
		model.addAttribute("user", user);
		model.addAttribute("userPaymentList", user.getUserPaymentList());
		model.addAttribute("userShippingList", user.getUserShippingList());
		model.addAttribute("listOfCreditCards", true);
		model.addAttribute("classActiveShipping", true);
		model.addAttribute("listOfShippingAddresses", true);

		return "myProfile";
	}

	/**
	 * Update user shipping string.
	 *
	 * @param shippingAddressId the shipping address id
	 * @param principal         the principal
	 * @param model             the model
	 * @return the string
	 */
	@RequestMapping("/updateUserShipping")
	public String updateUserShipping(@ModelAttribute("id") Long shippingAddressId, Principal principal, Model model) {
		User user = userService.findByUsername(principal.getName());
		UserShipping userShipping = userShippingService.findById(shippingAddressId);

		if (user.getId() != userShipping.getUser().getId()) {
			return "/badRequestPage";
		} else {
			model.addAttribute("user", user);

			model.addAttribute("userShipping", userShipping);

			List<String> stateList = IndianStates.listOfINStatesCode;
			Collections.sort(stateList);
			model.addAttribute("stateList", stateList);

			model.addAttribute("addNewShippingAddress", true);
			model.addAttribute("classActiveShipping", true);
			model.addAttribute("listOfCreditCards", true);

			model.addAttribute("userPaymentList", user.getUserPaymentList());
			model.addAttribute("userShippingList", user.getUserShippingList());

			return "myProfile";
		}
	}

	/**
	 * Sets default shipping address.
	 *
	 * @param defaultShippingId the default shipping id
	 * @param principal         the principal
	 * @param model             the model
	 * @return the default shipping address
	 */
	@RequestMapping(value = "/setDefaultShippingAddress", method = RequestMethod.POST)
	public String setDefaultShippingAddress(@ModelAttribute("defaultShippingAddressId") Long defaultShippingId, Principal principal, Model model) {
		User user = userService.findByUsername(principal.getName());
		UserPayment userPayment = userPaymentService.findById(defaultShippingId);
		if (user.getId() != userPayment.getUser().getId()) {
			return "/badRequestPage";
		} else {
			model.addAttribute("user", user);

			userService.setDefaultShippingAddress(defaultShippingId, user);


			model.addAttribute("listOfCreditCard", true);
			model.addAttribute("classActiveShipping", true);
			model.addAttribute("listOfShippingAddresses", true);

			model.addAttribute("userPaymentList", user.getUserPaymentList());
			model.addAttribute("userShippingList", user.getUserShippingList());

			return "myProfile";
		}
	}

	/**
	 * Remove user shipping string.
	 *
	 * @param userShippingId the user shipping id
	 * @param principal      the principal
	 * @param model          the model
	 * @return the string
	 */
	@RequestMapping("/removeUserShipping")
	public String removeUserShipping(@ModelAttribute("id") Long userShippingId, Principal principal, Model model) {
		User user = userService.findByUsername(principal.getName());
		UserShipping userShipping = userShippingService.findById(userShippingId);

		if (user.getId() != userShipping.getUser().getId()) {
			return "/badRequestPage";
		} else {
			model.addAttribute("user", user);

			userShippingService.removeById(userShippingId);

			model.addAttribute("ListOfShippingAddresses", true);
			model.addAttribute("classActiveShipping", true);

			model.addAttribute("userPaymentList", user.getUserPaymentList());
			model.addAttribute("userShippingList", user.getUserShippingList());

			return "myProfile";
		}
	}

	/**
	 * Add new credit card string.
	 *
	 * @param userPayment the user payment
	 * @param userBilling the user billing
	 * @param model       the model
	 * @param principal   the principal
	 * @return the string
	 */
	@RequestMapping(value = "addNewCreditCard", method = RequestMethod.POST)
	public String addNewCreditCard(@ModelAttribute("UserPayment") UserPayment userPayment, @ModelAttribute("UserBilling") UserBilling userBilling, Model model, Principal principal) {
		User user = userService.findByUsername(principal.getName());
		userService.updateUserBilling(userBilling, userPayment, user);
		model.addAttribute("user", user);
		model.addAttribute("userPaymentList", user.getUserPaymentList());
		model.addAttribute("userShippingList", user.getUserShippingList());
		model.addAttribute("listOfCreditCards", true);
		model.addAttribute("classActiveBilling", true);
		model.addAttribute("listOfShippingAddresses", true);

		return "myProfile";
	}

	/**
	 * Update credit card string.
	 *
	 * @param creditCardId the credit card id
	 * @param principal    the principal
	 * @param model        the model
	 * @return the string
	 */
	@RequestMapping("/updateCreditCard")
	public String updateCreditCard(@ModelAttribute("id") Long creditCardId, Principal principal, Model model) {
		User user = userService.findByUsername(principal.getName());
		UserPayment userPayment = userPaymentService.findById(creditCardId);

		if (user.getId() != userPayment.getUser().getId()) {
			return "/badRequestPage";
		} else {
			model.addAttribute("user", user);
			UserBilling userBilling = userPayment.getUserBilling();

			model.addAttribute("userPayment", userPayment);
			model.addAttribute("userBilling", userBilling);

			List<String> stateList = IndianStates.listOfINStatesCode;
			Collections.sort(stateList);
			model.addAttribute("stateList", stateList);

			model.addAttribute("addNewCreditCard", true);
			model.addAttribute("classActiveBilling", true);
			model.addAttribute("listOfShippingAddresses", true);

			model.addAttribute("userPaymentList", user.getUserPaymentList());
			model.addAttribute("userShippingList", user.getUserShippingList());

			return "myProfile";
		}
	}

	/**
	 * Remove credit card string.
	 *
	 * @param creditCardId the credit card id
	 * @param principal    the principal
	 * @param model        the model
	 * @return the string
	 */
	@RequestMapping("/removeCreditCard")
	public String removeCreditCard(@ModelAttribute("id") Long creditCardId, Principal principal, Model model) {
		User user = userService.findByUsername(principal.getName());
		UserPayment userPayment = userPaymentService.findById(creditCardId);
		if (user.getId() != userPayment.getUser().getId()) {
			return "/badRequestPage";
		} else {
			model.addAttribute("user", user);
			userPaymentService.removeById(creditCardId);


			model.addAttribute("listOfCreditCard", true);
			model.addAttribute("classActiveBilling", true);
			model.addAttribute("listOfShippingAddresses", true);

			model.addAttribute("userPaymentList", user.getUserPaymentList());
			model.addAttribute("userShippingList", user.getUserShippingList());

			return "myProfile";
		}
	}

	/**
	 * Sets default payment.
	 *
	 * @param defaultPaymentId the default payment id
	 * @param principal        the principal
	 * @param model            the model
	 * @return the default payment
	 */
	@RequestMapping(value = "/setDefaultPayment", method = RequestMethod.POST)
	public String setDefaultPayment(@ModelAttribute("defaultUserPaymentId") Long defaultPaymentId, Principal principal, Model model) {
		User user = userService.findByUsername(principal.getName());
		UserPayment userPayment = userPaymentService.findById(defaultPaymentId);
		if (user.getId() != userPayment.getUser().getId()) {
			return "/badRequestPage";
		} else {
			model.addAttribute("user", user);

			userService.setDefaultPayment(defaultPaymentId, user);


			model.addAttribute("listOfCreditCard", true);
			model.addAttribute("classActiveBilling", true);
			model.addAttribute("listOfShippingAddresses", true);

			model.addAttribute("userPaymentList", user.getUserPaymentList());
			model.addAttribute("userShippingList", user.getUserShippingList());

			return "myProfile";
		}
	}

	/**
	 * New user post string.
	 *
	 * @param request   the request
	 * @param userEmail the user email
	 * @param username  the username
	 * @param model     the model
	 * @return the string
	 * @throws Exception the exception
	 */
	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public String newUserPost(
			HttpServletRequest request,
			@ModelAttribute("email") String userEmail,
			@ModelAttribute("username") String username,
			Model model
	) throws Exception {
		model.addAttribute("classActiveNewAccount", true);
		model.addAttribute("email", userEmail);
		model.addAttribute("username", username);

		if (userService.findByUsername(username) != null) {
			model.addAttribute("usernameExists", true);

			return "myAccount";
		}

		if (userService.findByEmail(userEmail) != null) {
			model.addAttribute("emailExists", true);

			return "myAccount";
		}

		User user = new User();
		user.setUsername(username);
		user.setEmail(userEmail);

		String password = SecurityUtility.randomPassword();

		String encryptedPassword = SecurityUtility.passwordEncoder().encode(password);
		user.setPassword(encryptedPassword);

		Role role = new Role();
		role.setRoleId(1);
		role.setName("ROLE_USER");
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(new UserRole(user, role));
		userService.createUser(user, userRoles);

		String token = UUID.randomUUID().toString();
		userService.createPasswordResetTokenForUser(user, token);

		String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();

		SimpleMailMessage email = mailConstructor.constructResetTokenEmail(appUrl, request.getLocale(), token, user, password);

		mailSender.send(email);

		model.addAttribute("emailSent", "true");

		return "myAccount";
	}


	/**
	 * New user string.
	 *
	 * @param locale the locale
	 * @param token  the token
	 * @param model  the model
	 * @return the string
	 */
	@RequestMapping("/newUser")
	public String newUser(Locale locale, @RequestParam("token") String token, Model model) {
		PasswordResetToken passToken = userService.getPasswordResetToken(token);

		if (passToken == null) {
			String message = "Invalid Token.";
			model.addAttribute("message", message);
			return "redirect:/badRequest";
		}

		User user = passToken.getUser();
		String username = user.getUsername();

		UserDetails userDetails = userSecurityService.loadUserByUsername(username);

		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(),
				userDetails.getAuthorities());

		SecurityContextHolder.getContext().setAuthentication(authentication);

		model.addAttribute("user", user);

		model.addAttribute("classActiveEdit", true);
		return "myProfile";
	}

	/**
	 * Update user info string.
	 *
	 * @param user        the user
	 * @param newPassword the new password
	 * @param model       the model
	 * @return the string
	 * @throws Exception the exception
	 */
	@RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
	public String updateUserInfo(
			@ModelAttribute("user") User user,
			@ModelAttribute("newPassword") String newPassword,
			Model model
	) throws Exception {
		User currentUser = userService.findById(user.getId());

		if (currentUser == null) {
			throw new Exception("User not found");
		}

		/*check email already exists*/
		if (userService.findByEmail(user.getEmail()) != null) {
			if (userService.findByEmail(user.getEmail()).getId() != currentUser.getId()) {
				model.addAttribute("emailExists", true);
				return "myProfile";
			}
		}

		/*check username already exists*/
		if (userService.findByUsername(user.getUsername()) != null) {
			if (userService.findByUsername(user.getUsername()).getId() != currentUser.getId()) {
				model.addAttribute("usernameExists", true);
				return "myProfile";
			}
		}

//		update password
		if (newPassword != null && !newPassword.isEmpty() && !newPassword.equals("")) {
			BCryptPasswordEncoder passwordEncoder = SecurityUtility.passwordEncoder();
			String dbPassword = currentUser.getPassword();
			if (passwordEncoder.matches(user.getPassword(), dbPassword)) {
				currentUser.setPassword(passwordEncoder.encode(newPassword));
			} else {
				model.addAttribute("incorrectPassword", true);

				return "myProfile";
			}
		}

		currentUser.setFirstName(user.getFirstName());
		currentUser.setLastName(user.getLastName());
		currentUser.setUsername(user.getUsername());
		currentUser.setEmail(user.getEmail());

		userService.save(currentUser);

		model.addAttribute("updateSuccess", true);
		model.addAttribute("user", currentUser);
		model.addAttribute("classActiveEdit", true);

		UserDetails userDetails = userSecurityService.loadUserByUsername(currentUser.getUsername());

		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(),
				userDetails.getAuthorities());

		SecurityContextHolder.getContext().setAuthentication(authentication);

		return "myProfile";
	}

}
