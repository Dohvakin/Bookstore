package com.bookstore.domain;

import javax.persistence.*;

/**
 * The type User payment.
 */
@Entity
public class UserPayment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String type;
	private String cardName;
	private String cardNumber;
	private int expiryMonth;
	private int expiryYear;
	private int cvc;
	private String holderName;
	private boolean defaultPayment;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "userPayment")
	private UserBilling userBilling;

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
	 * Gets type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets type.
	 *
	 * @param type the type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets card name.
	 *
	 * @return the card name
	 */
	public String getCardName() {
		return cardName;
	}

	/**
	 * Sets card name.
	 *
	 * @param cardName the card name
	 */
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	/**
	 * Gets card number.
	 *
	 * @return the card number
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * Sets card number.
	 *
	 * @param cardNumber the card number
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * Gets expiry month.
	 *
	 * @return the expiry month
	 */
	public int getExpiryMonth() {
		return expiryMonth;
	}

	/**
	 * Sets expiry month.
	 *
	 * @param expiryMonth the expiry month
	 */
	public void setExpiryMonth(int expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	/**
	 * Gets expiry year.
	 *
	 * @return the expiry year
	 */
	public int getExpiryYear() {
		return expiryYear;
	}

	/**
	 * Sets expiry year.
	 *
	 * @param expiryYear the expiry year
	 */
	public void setExpiryYear(int expiryYear) {
		this.expiryYear = expiryYear;
	}

	/**
	 * Gets cvc.
	 *
	 * @return the cvc
	 */
	public int getCvc() {
		return cvc;
	}

	/**
	 * Sets cvc.
	 *
	 * @param cvc the cvc
	 */
	public void setCvc(int cvc) {
		this.cvc = cvc;
	}

	/**
	 * Gets holder name.
	 *
	 * @return the holder name
	 */
	public String getHolderName() {
		return holderName;
	}

	/**
	 * Sets holder name.
	 *
	 * @param holderName the holder name
	 */
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	/**
	 * Is default payment boolean.
	 *
	 * @return the boolean
	 */
	public boolean isDefaultPayment() {
		return defaultPayment;
	}

	/**
	 * Sets default payment.
	 *
	 * @param defaultPayment the default payment
	 */
	public void setDefaultPayment(boolean defaultPayment) {
		this.defaultPayment = defaultPayment;
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
	 * Gets user billing.
	 *
	 * @return the user billing
	 */
	public UserBilling getUserBilling() {
		return userBilling;
	}

	/**
	 * Sets user billing.
	 *
	 * @param userBilling the user billing
	 */
	public void setUserBilling(UserBilling userBilling) {
		this.userBilling = userBilling;
	}


}
