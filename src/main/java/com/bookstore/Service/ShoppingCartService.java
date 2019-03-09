package com.bookstore.service;

import com.bookstore.domain.ShoppingCart;

/**
 * The interface Shopping cart service.
 */
public interface ShoppingCartService {

	/**
	 * Update shopping cart shopping cart.
	 *
	 * @param shoppingCart the shopping cart
	 * @return the shopping cart
	 */
	ShoppingCart updateShoppingCart(ShoppingCart shoppingCart);

	/**
	 * Clear shopping cart.
	 *
	 * @param shoppingCart the shopping cart
	 */
	void clearShoppingCart(ShoppingCart shoppingCart);

}
