package com.indico.kirimaja.order.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indico.kirimaja.order.entity.DeliveryOrder;
import com.indico.kirimaja.order.repositories.OrderRepository;
import com.indico.kirimaja.order.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public DeliveryOrder findOrderById(Integer orderId) {
		Optional<DeliveryOrder> orderOptional = orderRepository.findById(orderId);
		return orderOptional.get();
	}


}
