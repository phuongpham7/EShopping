package edu.mum.service;

import java.util.List;

import edu.mum.domain.Item;

public interface ItemService {
	
	List<Item> getAllItems();

	void save(Item item);

	Item findOne(long id);

	List<Item> findItemByName(String itemName);
}
