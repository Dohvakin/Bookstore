package com.bookstore.domain.security;

import com.bookstore.domain.User;

import javax.persistence.*;

/**
 * The type User role.
 */
@Entity
@Table(name = "user_role")
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userRoleId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id")
	private Role role;

	/**
	 * Instantiates a new User role.
	 */
	public UserRole() {
	}

	/**
	 * Instantiates a new User role.
	 *
	 * @param user the user
	 * @param role the role
	 */
	public UserRole(User user, Role role) {
		this.user = user;
		this.role = role;
	}


	/**
	 * Gets user role id.
	 *
	 * @return the user role id
	 */
	public Long getUserRoleId() {
		return userRoleId;
	}


	/**
	 * Sets user role id.
	 *
	 * @param userRoleId the user role id
	 */
	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
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
	 * Gets role.
	 *
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}


	/**
	 * Sets role.
	 *
	 * @param role the role
	 */
	public void setRole(Role role) {
		this.role = role;
	}


}
