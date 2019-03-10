package com.bookstore.repository;


import com.bookstore.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The interface Book repository.
 */
public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findByCategory(String category);

	List<Book> findByTitleContaining(String title);

}
