package com.bookstore.repository;

import com.bookstore.domain.BookToCartItem;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Book to cart item repository.
 */
public interface BookToCartItemRepository extends CrudRepository<BookToCartItem, Long> {
}
