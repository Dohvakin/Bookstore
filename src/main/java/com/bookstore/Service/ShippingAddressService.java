package com.bookstore.service;

import com.bookstore.domain.ShippingAddress;
import com.bookstore.domain.UserShipping;

/**
 * The interface Shipping address service.
 */
public interface ShippingAddressService {

	/**
	 * Sets by user shipping.
	 *
	 * @param userShipping    the user shipping
	 * @param shippingAddress the shipping address
	 * @return the by user shipping
	 */
	ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress);

}
