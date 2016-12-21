package edu.mum.dao;

import java.util.List;

import edu.mum.domain.OrderItem;

public interface OrderItemDao extends GenericDao<OrderItem>{
	List<OrderItem> findOrderItemsByOrderId(Long orderId);
}
