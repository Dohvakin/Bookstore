package com.bookstore.service;

import com.bookstore.domain.UserShipping;

/**
 * The interface User shipping service.
 */
public interface UserShippingService {

	/**
	 * Find by id user shipping.
	 *
	 * @param id the id
	 * @return the user shipping
	 */
	UserShipping findById(Long id);

	/**
	 * Remove by id.
	 *
	 * @param id the id
	 */
	void removeById(Long id);

}
