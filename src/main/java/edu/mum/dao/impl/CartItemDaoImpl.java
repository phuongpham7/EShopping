package edu.mum.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;


import edu.mum.dao.CartItemDao;
import edu.mum.domain.CartItem;
import edu.mum.domain.Item;

@Repository
public class CartItemDaoImpl extends GenericDaoImpl<CartItem> implements CartItemDao {
	public CartItemDaoImpl() {
		super.setDaoType(CartItem.class);
	}

	@Override
	public Item findItemByCartItemId(Long id) {
		Query query = entityManager.createQuery("select i from CartItem ci, Item i "
				+ "where ci.id = :id AND"
				+ "ci.itemId = i.itemId");
		
		return (Item) query.setParameter("id", id).getSingleResult();
	}
}
