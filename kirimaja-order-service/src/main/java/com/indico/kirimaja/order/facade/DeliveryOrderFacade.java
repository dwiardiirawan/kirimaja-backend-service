package com.indico.kirimaja.order.facade;

import org.springframework.stereotype.Component;

import com.indico.kirimaja.order.entity.DeliveryOrder;


public interface DeliveryOrderFacade {
	DeliveryOrder createDeliveryOrder(DeliveryOrder order) throws Exception;
}
