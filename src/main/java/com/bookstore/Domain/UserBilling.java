package com.bookstore.domain;

import javax.persistence.*;

/**
 * The type User billing.
 */
@Entity
public class UserBilling {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String userBillingName;
	private String userBillingStreet1;
	private String userBillingStreet2;
	private String userBillingCity;
	private String userBillingState;
	private String userBillingCountry;
	private String userBillingZipcode;

	@OneToOne(cascade = CascadeType.ALL)
	private UserPayment userPayment;

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
	 * Gets user billing name.
	 *
	 * @return the user billing name
	 */
	public String getUserBillingName() {
		return userBillingName;
	}

	/**
	 * Sets user billing name.
	 *
	 * @param userBillingName the user billing name
	 */
	public void setUserBillingName(String userBillingName) {
		this.userBillingName = userBillingName;
	}

	/**
	 * Gets user billing street 1.
	 *
	 * @return the user billing street 1
	 */
	public String getUserBillingStreet1() {
		return userBillingStreet1;
	}

	/**
	 * Sets user billing street 1.
	 *
	 * @param userBillingStreet1 the user billing street 1
	 */
	public void setUserBillingStreet1(String userBillingStreet1) {
		this.userBillingStreet1 = userBillingStreet1;
	}

	/**
	 * Gets user billing street 2.
	 *
	 * @return the user billing street 2
	 */
	public String getUserBillingStreet2() {
		return userBillingStreet2;
	}

	/**
	 * Sets user billing street 2.
	 *
	 * @param userBillingStreet2 the user billing street 2
	 */
	public void setUserBillingStreet2(String userBillingStreet2) {
		this.userBillingStreet2 = userBillingStreet2;
	}

	/**
	 * Gets user billing city.
	 *
	 * @return the user billing city
	 */
	public String getUserBillingCity() {
		return userBillingCity;
	}

	/**
	 * Sets user billing city.
	 *
	 * @param userBillingCity the user billing city
	 */
	public void setUserBillingCity(String userBillingCity) {
		this.userBillingCity = userBillingCity;
	}

	/**
	 * Gets user billing state.
	 *
	 * @return the user billing state
	 */
	public String getUserBillingState() {
		return userBillingState;
	}

	/**
	 * Sets user billing state.
	 *
	 * @param userBillingState the user billing state
	 */
	public void setUserBillingState(String userBillingState) {
		this.userBillingState = userBillingState;
	}

	/**
	 * Gets user billing country.
	 *
	 * @return the user billing country
	 */
	public String getUserBillingCountry() {
		return userBillingCountry;
	}

	/**
	 * Sets user billing country.
	 *
	 * @param userBillingCountry the user billing country
	 */
	public void setUserBillingCountry(String userBillingCountry) {
		this.userBillingCountry = userBillingCountry;
	}

	/**
	 * Gets user billing zipcode.
	 *
	 * @return the user billing zipcode
	 */
	public String getUserBillingZipcode() {
		return userBillingZipcode;
	}

	/**
	 * Sets user billing zipcode.
	 *
	 * @param userBillingZipcode the user billing zipcode
	 */
	public void setUserBillingZipcode(String userBillingZipcode) {
		this.userBillingZipcode = userBillingZipcode;
	}

	/**
	 * Gets user payment.
	 *
	 * @return the user payment
	 */
	public UserPayment getUserPayment() {
		return userPayment;
	}

	/**
	 * Sets user payment.
	 *
	 * @param userPayment the user payment
	 */
	public void setUserPayment(UserPayment userPayment) {
		this.userPayment = userPayment;
	}


}
