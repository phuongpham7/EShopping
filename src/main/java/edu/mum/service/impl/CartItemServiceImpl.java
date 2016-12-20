package edu.mum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.dao.CartItemDao;
import edu.mum.domain.CartItem;
import edu.mum.domain.Item;
import edu.mum.service.CartItemService;

public class CartItemServiceImpl implements CartItemService {
	@Autowired
	private CartItemDao cartItemDao;
	
	public void save(CartItem cartItem) {
		cartItemDao.save(cartItem);
	}
	
	public void delete(Long id) {
		cartItemDao.delete(id);
	}

	@Override
	public Item findItemByCartItemId(Long id) {
		return cartItemDao.findItemByCartItemId(id);
	}
}
