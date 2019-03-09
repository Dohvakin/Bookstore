package com.bookstore.service;

import com.bookstore.domain.BillingAddress;
import com.bookstore.domain.UserBilling;

/**
 * The interface Billing address service.
 */
public interface BillingAddressService {

	/**
	 * Sets by user billing.
	 *
	 * @param userBilling    the user billing
	 * @param billingAddress the billing address
	 * @return the by user billing
	 */
	BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress);

}
