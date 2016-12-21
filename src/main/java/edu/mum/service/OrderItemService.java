package edu.mum.service;

import java.util.List;

import edu.mum.domain.OrderItem;

public interface OrderItemService {
	
	void save(OrderItem orderItem);

	List<OrderItem> findOrderItemsByOrderId(Long orderId);
}
