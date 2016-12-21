package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.OrderItemDao;
import edu.mum.domain.OrderItem;
import edu.mum.service.OrderItemService;

@Service
@Transactional 
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemDao orderItemDao;
	
	@Override
	public void save(OrderItem orderItem) {
		orderItemDao.save(orderItem);
	}

	@Override
	public List<OrderItem> findOrderItemsByOrderId(Long orderId) {
		return orderItemDao.findOrderItemsByOrderId(orderId);
	}
}
