package com.bookstore.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * The type Order.
 */
@Entity
@Table(name = "user_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date orderDate;
	private Date shippingDate;
	private String shippingMethod;
	private String orderStatus;
	private BigDecimal orderTotal;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<CartItem> cartItemList;

	@OneToOne(cascade = CascadeType.ALL)
	private ShippingAddress shippingAddress;

	@OneToOne(cascade = CascadeType.ALL)
	private BillingAddress billingAddress;

	@OneToOne(cascade = CascadeType.ALL)
	private Payment payment;

	@ManyToOne
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
	 * Gets order date.
	 *
	 * @return the order date
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * Sets order date.
	 *
	 * @param orderDate the order date
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * Gets shipping date.
	 *
	 * @return the shipping date
	 */
	public Date getShippingDate() {
		return shippingDate;
	}

	/**
	 * Sets shipping date.
	 *
	 * @param shippingDate the shipping date
	 */
	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}

	/**
	 * Gets shipping method.
	 *
	 * @return the shipping method
	 */
	public String getShippingMethod() {
		return shippingMethod;
	}

	/**
	 * Sets shipping method.
	 *
	 * @param shippingMethod the shipping method
	 */
	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	/**
	 * Gets order status.
	 *
	 * @return the order status
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

	/**
	 * Sets order status.
	 *
	 * @param orderStatus the order status
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * Gets order total.
	 *
	 * @return the order total
	 */
	public BigDecimal getOrderTotal() {
		return orderTotal;
	}

	/**
	 * Sets order total.
	 *
	 * @param orderTotal the order total
	 */
	public void setOrderTotal(BigDecimal orderTotal) {
		this.orderTotal = orderTotal;
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
	 * Gets shipping address.
	 *
	 * @return the shipping address
	 */
	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	/**
	 * Sets shipping address.
	 *
	 * @param shippingAddress the shipping address
	 */
	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	/**
	 * Gets payment.
	 *
	 * @return the payment
	 */
	public Payment getPayment() {
		return payment;
	}

	/**
	 * Sets payment.
	 *
	 * @param payment the payment
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
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

	/**
	 * Gets billing address.
	 *
	 * @return the billing address
	 */
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	/**
	 * Sets billing address.
	 *
	 * @param billingAddress the billing address
	 */
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
}
