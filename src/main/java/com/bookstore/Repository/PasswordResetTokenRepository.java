package com.bookstore.repository;

import com.bookstore.domain.User;
import com.bookstore.domain.security.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.stream.Stream;

/**
 * The interface Password reset token repository.
 */
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {

	/**
	 * Find by token password reset token.
	 *
	 * @param token the token
	 * @return the password reset token
	 */
	PasswordResetToken findByToken(String token);

	/**
	 * Find by user password reset token.
	 *
	 * @param user the user
	 * @return the password reset token
	 */
	PasswordResetToken findByUser(User user);

	/**
	 * Find all by expiry date less than stream.
	 *
	 * @param now the now
	 * @return the stream
	 */
	Stream<PasswordResetToken> findAllByExpiryDateLessThan(Date now);

	/**
	 * Delete all expired since.
	 *
	 * @param now the now
	 */
	@Modifying
	@Query("delete from PasswordResetToken t where t.expiryDate <= ?1")
	void deleteAllExpiredSince(Date now);

}
