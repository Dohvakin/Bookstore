package com.bookstore.service;

import com.bookstore.domain.User;
import com.bookstore.domain.UserBilling;
import com.bookstore.domain.UserPayment;
import com.bookstore.domain.UserShipping;
import com.bookstore.domain.security.PasswordResetToken;
import com.bookstore.domain.security.UserRole;

import java.util.Set;

public interface UserService {
	PasswordResetToken getPasswordResetToken(final String token);

	void createPasswordResetTokenForUser(final User user, final String token);

	User findByUsername(String username);

	User findByEmail(String email);
	
	User createUser(User user, Set<UserRole> userRoles) throws Exception;

	User save(User user);

	User findById(Long id);

	void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user);

	void setDefaultPayment(Long userPaymentId, User user);

	void updateUserShipping(UserShipping userShipping, User user);

	void setDefaultShippingAddress(Long userShippingId, User user);

}
