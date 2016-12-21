package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.Item;
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
	
	public Item findOne(long id) {
		return itemDao.findOne(id);
	}

	@Override
	public List<Item> findItemByName(String itemName) {
		return itemDao.findItemByName(itemName);
	}

	@Override
	public void deleteItem(Long id) {
		itemDao.delete(id);
		
	}

	@Override
	public List<Item> findItemByCategoryId(Long id) {
		
		return itemDao.findItemByCategoryId(id);
	}
	
	       
}
