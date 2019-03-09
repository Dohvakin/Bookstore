package com.bookstore.service;

import com.bookstore.domain.Payment;
import com.bookstore.domain.UserPayment;

/**
 * The interface Payment service.
 */
public interface PaymentService {

	/**
	 * Sets by user payment.
	 *
	 * @param userPayment the user payment
	 * @param payment     the payment
	 * @return the by user payment
	 */
	Payment setByUserPayment(UserPayment userPayment, Payment payment);

}
