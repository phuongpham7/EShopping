package edu.mum.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.CartDao;
import edu.mum.domain.Cart;
import edu.mum.domain.CartItem;

@SuppressWarnings("unchecked")
@Repository
public class CartDaoImpl extends GenericDaoImpl<Cart> implements CartDao {

	public CartDaoImpl() {
		super.setDaoType(Cart.class);
	}
	
	@Override
	public int getNumberCartItemUserId(Long userId) {
		Query query = entityManager.createQuery("select ci from USERS u, Cart c, CartItem ci "
				+ "where u.id = :userId AND"
				+ "u.card_id = c.cartname AND"
				+ "c.cartname = ci.cartname");
		
		return query.setParameter("userId", userId).getResultList().size();
	}

	@Override
	public List<CartItem> findAllCartItemByUserId(Long userId) {
		Query query = entityManager.createQuery("select ci from USERS u, Cart c, CartItem ci "
				+ "where u.id = :userId AND"
				+ "u.card_id = c.cartname AND"
				+ "c.cartname = ci.cartname");
		
		return (List<CartItem>) query.setParameter("userId", userId).getResultList();
	}
}
