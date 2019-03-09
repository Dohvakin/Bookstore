package com.bookstore.repository;

import com.bookstore.domain.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Order repository.
 */
public interface OrderRepository extends CrudRepository<Order, Long> {
}
