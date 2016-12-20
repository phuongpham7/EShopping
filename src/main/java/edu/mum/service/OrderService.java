package edu.mum.service;

import java.util.List;

import edu.mum.domain.Order;

public interface OrderService {
	
	void save(Order order);
	
	List<Order> findOrdersByUserId(Long userId);
}
