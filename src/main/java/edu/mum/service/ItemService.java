package edu.mum.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.mum.domain.Item;

public interface ItemService {
	
	List<Item> getAllItems();

	void save(Item item);

	Item findOne(long itemId);

	List<Item> findItemByName(String itemName);
	
	List<Item> findItemByCategoryId(Long id);
}
  