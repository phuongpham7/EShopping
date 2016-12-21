package edu.mum.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.AuthorityDao;
import edu.mum.domain.Authority;

@SuppressWarnings("unchecked")
@Repository
public class AuthorityDaoImpl extends GenericDaoImpl<Authority> implements AuthorityDao{

	public AuthorityDaoImpl() {
		super.setDaoType(Authority.class);
	}
	
	@Override
	public List<Authority> findAllAuthorityByUserName(String username) {
		Query query = entityManager.createQuery("select a from Authority a "
				+ "where a.username = :username");
		
		return (List<Authority>) query.setParameter("username", username).getResultList();
	}

	@Override
	public boolean isAdmin(String userName) {
		List<Authority> authorities = findAllAuthorityByUserName(userName);
		
		for (Authority auth : authorities) {
			if (auth.getAuthority().equals("ROLE_ADMIN"))
				return true;
		}
		
		return false;
	}

	@Override
	public boolean isUser(String userName) {
		List<Authority> authorities = findAllAuthorityByUserName(userName);
		
		for (Authority auth : authorities) {
			if (auth.getAuthority().equals("ROLE_USER"))
				return true;
		}
		
		return false;
	}
}
