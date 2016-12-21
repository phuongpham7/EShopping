package edu.mum.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.Item;
import edu.mum.domain.Order;
import edu.mum.domain.OrderItem;
import edu.mum.domain.OrderPayment;
import edu.mum.emailservice.EmailService;
import edu.mum.dao.ItemDao;
import edu.mum.service.ItemService;

@Service
@Transactional 
public class ItemServiceImpl implements ItemService{
	
 	@Autowired
	private ItemDao itemDao;

	public List<Item> getAllItems() {
		return itemDao.findAll();
	}

 
 	public void save(Item item) {
 		itemDao.update(item);
	}
	
	public Item findOne(long itemID) {
		return itemDao.findOne(itemID);
	}

    
 


}
