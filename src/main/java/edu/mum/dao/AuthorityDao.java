package edu.mum.dao;

import java.util.List;

import edu.mum.domain.Authority;

public interface AuthorityDao extends GenericDao<Authority>{
	List<Authority> findAllAuthorityByUserName(String username);
	boolean isAdmin(String userName);
	boolean isUser(String userName);
}
