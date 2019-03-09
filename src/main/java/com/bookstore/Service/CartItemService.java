package com.bookstore.service;

import com.bookstore.domain.Book;
import com.bookstore.domain.CartItem;
import com.bookstore.domain.ShoppingCart;
import com.bookstore.domain.User;

import java.util.List;

/**
 * The interface Cart item service.
 */
public interface CartItemService {
	/**
	 * Find by shopping cart list.
	 *
	 * @param shoppingCart the shopping cart
	 * @return the list
	 */
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

	/**
	 * Update cart item cart item.
	 *
	 * @param cartItem the cart item
	 * @return the cart item
	 */
	CartItem updateCartItem(CartItem cartItem);

	/**
	 * Add book to cart item cart item.
	 *
	 * @param book the book
	 * @param user the user
	 * @param qty  the qty
	 * @return the cart item
	 */
	CartItem addBookToCartItem(Book book, User user, int qty);

	/**
	 * Find by id cart item.
	 *
	 * @param id the id
	 * @return the cart item
	 */
	CartItem findById(Long id);

	/**
	 * Remove item.
	 *
	 * @param cartItem the cart item
	 */
	void removeItem(CartItem cartItem);

	/**
	 * Save cart item.
	 *
	 * @param cartItem the cart item
	 * @return the cart item
	 */
	CartItem save(CartItem cartItem);
}
