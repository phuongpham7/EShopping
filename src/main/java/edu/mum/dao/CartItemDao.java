package edu.mum.dao;

import edu.mum.domain.CartItem;
import edu.mum.domain.Item;

public interface CartItemDao extends GenericDao<CartItem> {
	Item findItemByCartItemId(Long id);
}
