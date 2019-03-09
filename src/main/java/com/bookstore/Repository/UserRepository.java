package com.bookstore.repository;

import com.bookstore.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface User repository.
 */
public interface UserRepository extends CrudRepository<User, Long> {
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
}
