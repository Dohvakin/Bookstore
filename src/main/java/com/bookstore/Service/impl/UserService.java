package com.bookstore.Service.impl;

import com.bookstore.Domain.User;
import com.bookstore.Domain.security.PasswordResetToken;
import com.bookstore.Domain.security.UserRole;

import java.util.Set;

public interface UserService {
	PasswordResetToken getPasswordResetToken(final String token);

	void createPasswordResetTokenForUser(final User user, final String token);

	User findByUsername(String username);

	User findByEmail(String email);

	User createUser(User user, Set<UserRole> userRoles) throws Exception;
}
