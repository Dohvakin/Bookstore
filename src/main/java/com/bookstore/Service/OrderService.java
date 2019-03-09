package com.bookstore.service;

import com.bookstore.domain.*;

/**
 * The interface Order service.
 */
public interface OrderService {

	/**
	 * Create order order.
	 *
	 * @param shoppingCart    the shopping cart
	 * @param shippingAddress the shipping address
	 * @param billingAddress  the billing address
	 * @param payment         the payment
	 * @param shippingMethod  the shipping method
	 * @param user            the user
	 * @return the order
	 */
	Order createOrder(ShoppingCart shoppingCart, ShippingAddress shippingAddress, BillingAddress billingAddress, Payment payment, String shippingMethod, User user);

	/**
	 * Find one order.
	 *
	 * @param id the id
	 * @return the order
	 */
	Order findOne(Long id);

}
