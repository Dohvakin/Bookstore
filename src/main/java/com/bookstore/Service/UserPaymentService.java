package com.bookstore.service;

import com.bookstore.domain.UserPayment;


/**
 * The interface User payment service.
 */
public interface UserPaymentService {

	/**
	 * Find by id user payment.
	 *
	 * @param id the id
	 * @return the user payment
	 */
	UserPayment findById(Long id);

	/**
	 * Remove by id.
	 *
	 * @param id the id
	 */
	void removeById(Long id);

}
