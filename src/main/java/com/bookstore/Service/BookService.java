package com.bookstore.service;

import com.bookstore.domain.Book;

import java.util.List;

/**
 * The interface Book service.
 */
public interface BookService {
	/**
	 * Find all list.
	 *
	 * @return the list
	 */
	List<Book> findAll();

	/**
	 * Find one book.
	 *
	 * @param id the id
	 * @return the book
	 */
	Book findOne(Long id);
}
