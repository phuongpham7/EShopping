package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.AuthorityDao;
import edu.mum.domain.Authority;
import edu.mum.service.AuthorityService;

@Service
@Transactional 
public class AuthorityServiceImpl implements AuthorityService{

	@Autowired
	private AuthorityDao authorityDao;
	
	@Override
	public List<Authority> findAllAuthorityByUserName(String username) {
		return authorityDao.findAllAuthorityByUserName(username);
	}

	@Override
	public boolean isAdmin(String userName) {
		return authorityDao.isAdmin(userName);
	}

	@Override
	public boolean isUser(String userName) {
		return authorityDao.isUser(userName);
	}
}
