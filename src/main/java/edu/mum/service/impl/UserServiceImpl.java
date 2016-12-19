package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.UserDao;
import edu.mum.domain.User;
import edu.mum.service.UserCredentialsService;
import edu.mum.service.UserService;

@Service
@Transactional 
public class UserServiceImpl implements UserService {
	
 	@Autowired
	private UserDao userDao;

 	@Autowired
 	UserCredentialsService credentialsService;

    public void save( User member) {  		
    	userDao.save(member);
	}
	
 	
    @Override
   	public void saveFull( User member) {  		
  		credentialsService.save(member.getUserCredentials());
  		userDao.save(member);
	}
  	

	public List<User> findAll() {
		return (List<User>)userDao.findAll();
	}

 	public User findOne(Long id) {
		return userDao.findOne(id);
	}
	
 
}
