package edu.mum.dao;

import java.util.List;

import edu.mum.domain.CartItem;
import edu.mum.domain.Item;

public interface CartItemDao extends GenericDao<CartItem> {
	List<Item> getAllItemsByUserId(Long id);
	Item findItemByCartItemId(Long id);
}
