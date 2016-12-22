package edu.mum.service;

import java.util.List;
import java.util.Locale;

import edu.mum.domain.Item;
import edu.mum.domain.Order;
import edu.mum.domain.User;

public interface UserService {

	public void save(User member);

	public void saveFull(User member);

	public List<User> findAll();

	public User findOne(Long id);

	public void sendEmail( final String recipientName, final String recipientEmail, final String [] ccrecipientEmail,  Order order,Item item, String documentName,final Locale locale) ;
}
