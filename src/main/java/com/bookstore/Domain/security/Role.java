package com.bookstore.domain.security;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Role.
 */
@Entity
public class Role {

	@Id
	private int roleId;
	private String name;

	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<UserRole> userRoles = new HashSet<>();

	/**
	 * Gets role id.
	 *
	 * @return the role id
	 */
	public int getRoleId() {
		return roleId;
	}

	/**
	 * Sets role id.
	 *
	 * @param roleId the role id
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	/**
	 * Gets name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets name.
	 *
	 * @param name the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets user roles.
	 *
	 * @return the user roles
	 */
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	/**
	 * Sets user roles.
	 *
	 * @param userRoles the user roles
	 */
	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}


}
