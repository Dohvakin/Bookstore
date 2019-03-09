package com.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * The type Shopping cart.
 */
@Entity
public class ShoppingCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal GrandTotal;

	@OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<CartItem> cartItemList;

	@OneToOne(cascade = CascadeType.ALL)
	private User user;

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
	 * Gets grand total.
	 *
	 * @return the grand total
	 */
	public BigDecimal getGrandTotal() {
		return GrandTotal;
	}

	/**
	 * Sets grand total.
	 *
	 * @param grandTotal the grand total
	 */
	public void setGrandTotal(BigDecimal grandTotal) {
		GrandTotal = grandTotal;
	}

	/**
	 * Gets cart item list.
	 *
	 * @return the cart item list
	 */
	public List<CartItem> getCartItemList() {
		return cartItemList;
	}

	/**
	 * Sets cart item list.
	 *
	 * @param cartItemList the cart item list
	 */
	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}

	/**
	 * Gets user.
	 *
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets user.
	 *
	 * @param user the user
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
