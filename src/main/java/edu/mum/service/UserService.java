package edu.mum.service;

import java.util.List;
import java.util.Set;

import edu.mum.domain.User;

public interface UserService {

	public void save(User member);

	public void saveFull(User member);

	public List<User> findAll();

	public User findOne(Long id);

}
