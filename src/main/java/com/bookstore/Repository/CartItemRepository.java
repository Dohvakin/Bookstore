package com.bookstore.repository;

import com.bookstore.domain.CartItem;
import com.bookstore.domain.Order;
import com.bookstore.domain.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The interface Cart item repository.
 */
public interface CartItemRepository extends CrudRepository<CartItem, Long> {

	/**
	 * Find by shopping cart list.
	 *
	 * @param shoppingCart the shopping cart
	 * @return the list
	 */
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

	List<CartItem> findByOrder(Order order);

}
