package com.indico.kirimaja.order.services;

import com.indico.kirimaja.order.entity.DeliveryOrder;

public interface OrderService {
	DeliveryOrder findOrderById(Integer orderId);
}
