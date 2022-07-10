package com.indico.kirimaja.payment.facade;

import com.indico.kirimaja.payment.dto.paymentRequest.PaymentRequest;
import com.indico.kirimaja.payment.entity.Payment;

public interface PaymentFacade {
	Payment payDeliveryOrder(PaymentRequest paymentRequest);
}
