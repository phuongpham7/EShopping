package edu.mum.service;

import edu.mum.domain.CartItem;
import edu.mum.domain.Item;

public interface CartItemService {
	
	void save(CartItem cartItem);

	void delete(Long id);

	Item findItemByCartItemId(Long id);
}
