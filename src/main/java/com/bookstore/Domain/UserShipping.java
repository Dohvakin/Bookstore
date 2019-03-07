package com.bookstore.domain;

import javax.persistence.*;

/**
 * The type User shipping.
 */
@Entity
public class UserShipping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String userShippingName;
	private String userShippingStreet1;
	private String userShippingStreet2;
	private String userShippingCity;
	private String userShippingState;
	private String userShippingCountry;
	private String userShippingZipcode;
	private Boolean userShippingDefault;


	@ManyToOne
	@JoinColumn(name = "user_id")
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
	 * Gets user shipping name.
	 *
	 * @return the user shipping name
	 */
	public String getUserShippingName() {
		return userShippingName;
	}


	/**
	 * Sets user shipping name.
	 *
	 * @param userShippingName the user shipping name
	 */
	public void setUserShippingName(String userShippingName) {
		this.userShippingName = userShippingName;
	}


	/**
	 * Gets user shipping street 1.
	 *
	 * @return the user shipping street 1
	 */
	public String getUserShippingStreet1() {
		return userShippingStreet1;
	}


	/**
	 * Sets user shipping street 1.
	 *
	 * @param userShippingStreet1 the user shipping street 1
	 */
	public void setUserShippingStreet1(String userShippingStreet1) {
		this.userShippingStreet1 = userShippingStreet1;
	}


	/**
	 * Gets user shipping street 2.
	 *
	 * @return the user shipping street 2
	 */
	public String getUserShippingStreet2() {
		return userShippingStreet2;
	}


	/**
	 * Sets user shipping street 2.
	 *
	 * @param userShippingStreet2 the user shipping street 2
	 */
	public void setUserShippingStreet2(String userShippingStreet2) {
		this.userShippingStreet2 = userShippingStreet2;
	}


	/**
	 * Gets user shipping city.
	 *
	 * @return the user shipping city
	 */
	public String getUserShippingCity() {
		return userShippingCity;
	}


	/**
	 * Sets user shipping city.
	 *
	 * @param userShippingCity the user shipping city
	 */
	public void setUserShippingCity(String userShippingCity) {
		this.userShippingCity = userShippingCity;
	}


	/**
	 * Gets user shipping state.
	 *
	 * @return the user shipping state
	 */
	public String getUserShippingState() {
		return userShippingState;
	}


	/**
	 * Sets user shipping state.
	 *
	 * @param userShippingState the user shipping state
	 */
	public void setUserShippingState(String userShippingState) {
		this.userShippingState = userShippingState;
	}


	/**
	 * Gets user shipping country.
	 *
	 * @return the user shipping country
	 */
	public String getUserShippingCountry() {
		return userShippingCountry;
	}


	/**
	 * Sets user shipping country.
	 *
	 * @param userShippingCountry the user shipping country
	 */
	public void setUserShippingCountry(String userShippingCountry) {
		this.userShippingCountry = userShippingCountry;
	}


	/**
	 * Gets user shipping zipcode.
	 *
	 * @return the user shipping zipcode
	 */
	public String getUserShippingZipcode() {
		return userShippingZipcode;
	}


	/**
	 * Sets user shipping zipcode.
	 *
	 * @param userShippingZipcode the user shipping zipcode
	 */
	public void setUserShippingZipcode(String userShippingZipcode) {
		this.userShippingZipcode = userShippingZipcode;
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
	 * Gets user shipping default.
	 *
	 * @return the user shipping default
	 */
	public Boolean getUserShippingDefault() {
		return userShippingDefault;
	}

	/**
	 * Sets user shipping default.
	 *
	 * @param userShippingDefault the user shipping default
	 */
	public void setUserShippingDefault(Boolean userShippingDefault) {
		this.userShippingDefault = userShippingDefault;
	}
}
