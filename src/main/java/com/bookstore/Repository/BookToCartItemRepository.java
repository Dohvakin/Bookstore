package com.bookstore.repository;

import com.bookstore.domain.BookToCartItem;
import com.bookstore.domain.CartItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The interface Book to cart item repository.
 */
@Transactional
public interface BookToCartItemRepository extends CrudRepository<BookToCartItem, Long> {

	/**
	 * Delete by cart item.
	 *
	 * @param cartItem the cart item
	 */
	void deleteByCartItem(CartItem cartItem);

}
