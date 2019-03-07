package com.bookstore.repository;

import com.bookstore.domain.UserPayment;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface User payment repository.
 */
public interface UserPaymentRepository extends CrudRepository<UserPayment, Long> {
}
