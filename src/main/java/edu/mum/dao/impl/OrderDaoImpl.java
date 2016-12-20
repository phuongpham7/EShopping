package edu.mum.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.OrderDao;
import edu.mum.domain.Order;

@SuppressWarnings("unchecked")
@Repository
public class OrderDaoImpl extends GenericDaoImpl<Order> implements OrderDao{

	public OrderDaoImpl() {
		super.setDaoType(Order.class);
	}

	@Override
	public List<Order> findOrdersByUserId(Long userId) {
		Query query = entityManager.createQuery("select po from USERS u, USERS_purchaseOrder up, purchaseOrder po "
				+ "where u.id = :userId AND"
				+ "u.id = up.USERS_id AND"
				+ "up.orders_id = po.id");
		
		return (List<Order>) query.setParameter("userId", userId).getResultList();
	}

}
