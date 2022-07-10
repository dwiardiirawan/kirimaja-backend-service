package com.indico.kirimaja.payment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indico.kirimaja.payment.dto.paymentRequest.PaymentRequest;
import com.indico.kirimaja.payment.entity.Payment;
import com.indico.kirimaja.payment.facade.PaymentFacade;

@RestController
@RequestMapping("/${spring.application.name}/*")
public class PaymentController {

	private static final Logger LOG = LoggerFactory.getLogger(PaymentController.class);
	
	@Autowired
	private PaymentFacade paymentFacade;
	
	@PostMapping("${indico.controllers.url.payment}")
	public ResponseEntity<Payment> payment(@RequestBody PaymentRequest paymentRequest){
		
		LOG.info("PaymentController.payment(). Incoming payment request, order id: {}", paymentRequest.getOrderId());
		ResponseEntity<Payment> responseEntity = null;
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		Payment payment = paymentFacade.payDeliveryOrder(paymentRequest);
		if(payment!=null)
			httpStatus = HttpStatus.OK;
		
		responseEntity = new ResponseEntity<Payment>(payment, httpStatus);
		return responseEntity;
	}
}
