package edu.mum.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.OrderItemDao;
import edu.mum.domain.CartItem;
import edu.mum.domain.OrderItem;

@SuppressWarnings("unchecked")
@Repository
public class OrderItemDaoImpl extends GenericDaoImpl<OrderItem> implements OrderItemDao{

	public OrderItemDaoImpl() {
		super.setDaoType(OrderItem.class);
	}
	
	@Override
	public List<OrderItem> findOrderItemsByOrderId(Long orderId) {
		Query query = entityManager.createQuery("select po from purchaseOrder po, OrderItem oi "
				+ "where po.id = :orderId AND"
				+ "po.id = oi.order_id");
		
		return (List<OrderItem>) query.setParameter("orderId", orderId).getResultList();
	}
}
