package com.bookstore.domain;

import javax.persistence.*;

/**
 * The type Shipping address.
 */
@Entity
public class ShippingAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ShippingAddressName;
	private String ShippingAddressStreet1;
	private String ShippingAddressStreet2;
	private String ShippingAddressCity;
	private String ShippingAddressState;
	private String ShippingAddressCountry;
	private String ShippingAddressZipcode;


	@OneToOne
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
	 * Gets shipping address name.
	 *
	 * @return the shipping address name
	 */
	public String getShippingAddressName() {
		return ShippingAddressName;
	}

	/**
	 * Sets shipping address name.
	 *
	 * @param shippingAddressName the shipping address name
	 */
	public void setShippingAddressName(String shippingAddressName) {
		ShippingAddressName = shippingAddressName;
	}

	/**
	 * Gets shipping address street 1.
	 *
	 * @return the shipping address street 1
	 */
	public String getShippingAddressStreet1() {
		return ShippingAddressStreet1;
	}

	/**
	 * Sets shipping address street 1.
	 *
	 * @param shippingAddressStreet1 the shipping address street 1
	 */
	public void setShippingAddressStreet1(String shippingAddressStreet1) {
		ShippingAddressStreet1 = shippingAddressStreet1;
	}

	/**
	 * Gets shipping address street 2.
	 *
	 * @return the shipping address street 2
	 */
	public String getShippingAddressStreet2() {
		return ShippingAddressStreet2;
	}

	/**
	 * Sets shipping address street 2.
	 *
	 * @param shippingAddressStreet2 the shipping address street 2
	 */
	public void setShippingAddressStreet2(String shippingAddressStreet2) {
		ShippingAddressStreet2 = shippingAddressStreet2;
	}

	/**
	 * Gets shipping address city.
	 *
	 * @return the shipping address city
	 */
	public String getShippingAddressCity() {
		return ShippingAddressCity;
	}

	/**
	 * Sets shipping address city.
	 *
	 * @param shippingAddressCity the shipping address city
	 */
	public void setShippingAddressCity(String shippingAddressCity) {
		ShippingAddressCity = shippingAddressCity;
	}

	/**
	 * Gets shipping address state.
	 *
	 * @return the shipping address state
	 */
	public String getShippingAddressState() {
		return ShippingAddressState;
	}

	/**
	 * Sets shipping address state.
	 *
	 * @param shippingAddressState the shipping address state
	 */
	public void setShippingAddressState(String shippingAddressState) {
		ShippingAddressState = shippingAddressState;
	}

	/**
	 * Gets shipping address country.
	 *
	 * @return the shipping address country
	 */
	public String getShippingAddressCountry() {
		return ShippingAddressCountry;
	}

	/**
	 * Sets shipping address country.
	 *
	 * @param shippingAddressCountry the shipping address country
	 */
	public void setShippingAddressCountry(String shippingAddressCountry) {
		ShippingAddressCountry = shippingAddressCountry;
	}

	/**
	 * Gets shipping address zipcode.
	 *
	 * @return the shipping address zipcode
	 */
	public String getShippingAddressZipcode() {
		return ShippingAddressZipcode;
	}

	/**
	 * Sets shipping address zipcode.
	 *
	 * @param shippingAddressZipcode the shipping address zipcode
	 */
	public void setShippingAddressZipcode(String shippingAddressZipcode) {
		ShippingAddressZipcode = shippingAddressZipcode;
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
