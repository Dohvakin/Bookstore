package com.bookstore.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * The type Cart item.
 */
@Entity
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int qty;
	private BigDecimal subTotal;

	@OneToOne
	private Book book;

	@OneToMany(mappedBy = "cartItem")
	@JsonIgnore
	private List<BookToCartItem> bookToCartItemList;

	@ManyToOne
	@JoinColumn(name = "shopping_cart_id")
	private ShoppingCart shoppingCart;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

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
	 * Gets qty.
	 *
	 * @return the qty
	 */
	public int getQty() {
		return qty;
	}

	/**
	 * Sets qty.
	 *
	 * @param qty the qty
	 */
	public void setQty(int qty) {
		this.qty = qty;
	}

	/**
	 * Gets sub total.
	 *
	 * @return the sub total
	 */
	public BigDecimal getSubTotal() {
		return subTotal;
	}

	/**
	 * Sets sub total.
	 *
	 * @param subTotal the sub total
	 */
	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
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
	 * Gets book to cart item list.
	 *
	 * @return the book to cart item list
	 */
	public List<BookToCartItem> getBookToCartItemList() {
		return bookToCartItemList;
	}

	/**
	 * Sets book to cart item list.
	 *
	 * @param bookToCartItemList the book to cart item list
	 */
	public void setBookToCartItemList(List<BookToCartItem> bookToCartItemList) {
		this.bookToCartItemList = bookToCartItemList;
	}

	/**
	 * Gets shopping cart.
	 *
	 * @return the shopping cart
	 */
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	/**
	 * Sets shopping cart.
	 *
	 * @param shoppingCart the shopping cart
	 */
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	/**
	 * Gets order.
	 *
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * Sets order.
	 *
	 * @param order the order
	 */
	public void setOrder(Order order) {
		this.order = order;
	}
}
