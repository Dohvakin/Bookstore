package com.bookstore.service;

import com.bookstore.domain.User;
import com.bookstore.domain.UserBilling;
import com.bookstore.domain.UserPayment;
import com.bookstore.domain.UserShipping;
import com.bookstore.domain.security.PasswordResetToken;
import com.bookstore.domain.security.UserRole;

import java.util.Set;

/**
 * The interface User service.
 */
public interface UserService {
	/**
	 * Gets password reset token.
	 *
	 * @param token the token
	 * @return the password reset token
	 */
	PasswordResetToken getPasswordResetToken(final String token);

	/**
	 * Create password reset token for user.
	 *
	 * @param user  the user
	 * @param token the token
	 */
	void createPasswordResetTokenForUser(final User user, final String token);

	/**
	 * Find by username user.
	 *
	 * @param username the username
	 * @return the user
	 */
	User findByUsername(String username);

	/**
	 * Find by email user.
	 *
	 * @param email the email
	 * @return the user
	 */
	User findByEmail(String email);

	/**
	 * Create user user.
	 *
	 * @param user      the user
	 * @param userRoles the user roles
	 * @return the user
	 * @throws Exception the exception
	 */
	User createUser(User user, Set<UserRole> userRoles) throws Exception;

	/**
	 * Save user.
	 *
	 * @param user the user
	 * @return the user
	 */
	User save(User user);

	/**
	 * Find by id user.
	 *
	 * @param id the id
	 * @return the user
	 */
	User findById(Long id);

	/**
	 * Update user billing.
	 *
	 * @param userBilling the user billing
	 * @param userPayment the user payment
	 * @param user        the user
	 */
	void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user);

	/**
	 * Sets default payment.
	 *
	 * @param userPaymentId the user payment id
	 * @param user          the user
	 */
	void setDefaultPayment(Long userPaymentId, User user);

	/**
	 * Update user shipping.
	 *
	 * @param userShipping the user shipping
	 * @param user         the user
	 */
	void updateUserShipping(UserShipping userShipping, User user);

	/**
	 * Sets default shipping address.
	 *
	 * @param userShippingId the user shipping id
	 * @param user           the user
	 */
	void setDefaultShippingAddress(Long userShippingId, User user);

}
