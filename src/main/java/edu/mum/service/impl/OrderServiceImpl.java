package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.dao.OrderDao;
import edu.mum.domain.Order;
import edu.mum.service.OrderService;

public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Override
	public void save(Order order) {
		orderDao.save(order);
	}

	@Override
	public List<Order> findOrdersByUserId(Long userId) {
		return orderDao.findOrdersByUserId(userId);
	}
}
