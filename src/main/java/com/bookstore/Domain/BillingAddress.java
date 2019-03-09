package com.bookstore.domain;

import javax.persistence.*;

/**
 * The type Billing address.
 */
@Entity
public class BillingAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String BillingAddressName;
	private String BillingAddressStreet1;
	private String BillingAddressStreet2;
	private String BillingAddressCity;
	private String BillingAddressState;
	private String BillingAddressCountry;
	private String BillingAddressZipcode;

	@OneToOne(cascade = CascadeType.ALL)
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
	 * Gets billing address name.
	 *
	 * @return the billing address name
	 */
	public String getBillingAddressName() {
		return BillingAddressName;
	}

	/**
	 * Sets billing address name.
	 *
	 * @param billingAddressName the billing address name
	 */
	public void setBillingAddressName(String billingAddressName) {
		BillingAddressName = billingAddressName;
	}

	/**
	 * Gets billing address street 1.
	 *
	 * @return the billing address street 1
	 */
	public String getBillingAddressStreet1() {
		return BillingAddressStreet1;
	}

	/**
	 * Sets billing address street 1.
	 *
	 * @param billingAddressStreet1 the billing address street 1
	 */
	public void setBillingAddressStreet1(String billingAddressStreet1) {
		BillingAddressStreet1 = billingAddressStreet1;
	}

	/**
	 * Gets billing address street 2.
	 *
	 * @return the billing address street 2
	 */
	public String getBillingAddressStreet2() {
		return BillingAddressStreet2;
	}

	/**
	 * Sets billing address street 2.
	 *
	 * @param billingAddressStreet2 the billing address street 2
	 */
	public void setBillingAddressStreet2(String billingAddressStreet2) {
		BillingAddressStreet2 = billingAddressStreet2;
	}

	/**
	 * Gets billing address city.
	 *
	 * @return the billing address city
	 */
	public String getBillingAddressCity() {
		return BillingAddressCity;
	}

	/**
	 * Sets billing address city.
	 *
	 * @param billingAddressCity the billing address city
	 */
	public void setBillingAddressCity(String billingAddressCity) {
		BillingAddressCity = billingAddressCity;
	}

	/**
	 * Gets billing address state.
	 *
	 * @return the billing address state
	 */
	public String getBillingAddressState() {
		return BillingAddressState;
	}

	/**
	 * Sets billing address state.
	 *
	 * @param billingAddressState the billing address state
	 */
	public void setBillingAddressState(String billingAddressState) {
		BillingAddressState = billingAddressState;
	}

	/**
	 * Gets billing address country.
	 *
	 * @return the billing address country
	 */
	public String getBillingAddressCountry() {
		return BillingAddressCountry;
	}

	/**
	 * Sets billing address country.
	 *
	 * @param billingAddressCountry the billing address country
	 */
	public void setBillingAddressCountry(String billingAddressCountry) {
		BillingAddressCountry = billingAddressCountry;
	}

	/**
	 * Gets billing address zipcode.
	 *
	 * @return the billing address zipcode
	 */
	public String getBillingAddressZipcode() {
		return BillingAddressZipcode;
	}

	/**
	 * Sets billing address zipcode.
	 *
	 * @param billingAddressZipcode the billing address zipcode
	 */
	public void setBillingAddressZipcode(String billingAddressZipcode) {
		BillingAddressZipcode = billingAddressZipcode;
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
