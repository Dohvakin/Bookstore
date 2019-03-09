package com.bookstore.domain.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * The type Authority.
 */
public class Authority implements GrantedAuthority {
	private final String authority;

	/**
	 * Instantiates a new Authority.
	 *
	 * @param authority the authority
	 */
	public Authority(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return authority;
	}
}
