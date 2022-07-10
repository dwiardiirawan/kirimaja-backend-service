package com.indico.kirimaja.payment.facade.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.indico.kirimaja.payment.dto.feign.DeliveryOrder;
import com.indico.kirimaja.payment.dto.paymentRequest.PaymentRequest;
import com.indico.kirimaja.payment.entity.Payment;
import com.indico.kirimaja.payment.facade.PaymentFacade;
import com.indico.kirimaja.payment.feign.OrderFeign;
import com.indico.kirimaja.payment.repositories.PaymentRepository;

@Component
public class PaymentFacadeImpl implements PaymentFacade {

	private static final Logger LOG = LoggerFactory.getLogger(PaymentFacadeImpl.class);
	
	@Autowired
	private OrderFeign orderFeign;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	public Payment payDeliveryOrder(PaymentRequest paymentRequest) {
		Payment payment = null;
		boolean isValidOrder = validateDeliveryOrder(paymentRequest.getOrderId(), paymentRequest.getAmount());
		if(isValidOrder) {
			payment = pay(paymentRequest);
		}
		return payment;
	}

	private Payment pay(PaymentRequest paymentRequest) {
		Payment payment = new Payment();
		payment.setAmount(paymentRequest.getAmount());
		payment.setOrderId(paymentRequest.getOrderId());
		payment.setPaymentSource(paymentRequest.getPaymentSource());
		payment.setPaymentType(paymentRequest.getPaymentType());
		payment.setPaymentDate(new Date());
		
		return paymentRepository.saveAndFlush(payment);
		
	}

	private boolean validateDeliveryOrder(Integer orderId, Double paymentAmount) {
		boolean isValid = false;
		DeliveryOrder order = orderFeign.findOrderById(orderId);
		
		if(order!=null && order.getDeliveryFeeTotalCharge().compareTo(paymentAmount) == 0)
			isValid = true;
		
		return isValid;
	}

	
	
}
