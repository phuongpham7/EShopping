package edu.mum.service;

import java.util.List;

import edu.mum.domain.Authority;

public interface AuthorityService {
	List<Authority> findAllAuthorityByUserName(String username);

	boolean isAdmin(String userName);

	boolean isUser(String userName);
}
