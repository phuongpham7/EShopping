package edu.mum.service;

import java.util.List;

import edu.mum.domain.CartItem;
import edu.mum.domain.Item;

public interface CartItemService {
	
	void save(CartItem cartItem);

	void delete(Long id);
	
	List<Item> getAllItemsByUserId(Long i);

	Item findItemByCartItemId(Long id);
}
