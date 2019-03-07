package com.bookstore.domain;

import javax.persistence.*;

/**
 * The type Book to cart item.
 */
@Entity
public class BookToCartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;


	@ManyToOne
	@JoinColumn(name = "cart_item_id")
	private CartItem cartItem;

	/**
	 * Gets id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets id.
	 *
	 * @param id the id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets book.
	 *
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * Sets book.
	 *
	 * @param book the book
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	/**
	 * Gets cart item.
	 *
	 * @return the cart item
	 */
	public CartItem getCartItem() {
		return cartItem;
	}

	/**
	 * Sets cart item.
	 *
	 * @param cartItem the cart item
	 */
	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}
}
