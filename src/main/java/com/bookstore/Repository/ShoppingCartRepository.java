package com.bookstore.repository;

import com.bookstore.domain.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Shopping cart repository.
 */
public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {
}
