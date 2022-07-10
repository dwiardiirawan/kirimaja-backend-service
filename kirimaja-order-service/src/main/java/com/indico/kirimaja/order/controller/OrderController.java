package com.indico.kirimaja.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.indico.kirimaja.order.dto.response.OrderResponse;
import com.indico.kirimaja.order.entity.DeliveryOrder;
import com.indico.kirimaja.order.facade.DeliveryOrderFacade;
import com.indico.kirimaja.order.services.OrderService;

@RestController
@RequestMapping("/${spring.application.name}/*")
public class OrderController {


	private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private DeliveryOrderFacade deliveryOrderFacade;
	
	@Autowired
	private OrderService orderService;

	@PostMapping(value = "${indico.controllers.url.order}", produces = "application/json")
	public @ResponseBody OrderResponse order(@RequestBody DeliveryOrder order){
		LOG.info("OrderController.order(). Incoming request, order id: {}", order.getOrderId());
		
		LOG.info("Request Pick Up Latitude: {}, Pick Up Longitude: {}", order.getPickUpLatitude(), order.getPickUpLongitude());
		LOG.info("Request Drop Off Up Latitude: {}, Drop Off Longitude: {}", order.getPickUpLatitude(), order.getPickUpLongitude());
		
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		try {
			DeliveryOrder processOrder = deliveryOrderFacade.createDeliveryOrder(order);
			orderResponse.setOrder(processOrder);
			if(processOrder!=null)
				orderResponse.setStatus(HttpStatus.OK.value());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderResponse;
	}
	
	@GetMapping(value = "${indico.controllers.url.findOrderById}", produces = "application/json")
	public DeliveryOrder findOrderById(@PathVariable("orderId") Integer orderId) {
		LOG.info("OrderController.findOrderById(). Order Id: {}", orderId);
		return orderService.findOrderById(orderId);
		
	}
}
