package com.indico.kirimaja.payment.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.indico.kirimaja.payment.dto.feign.DeliveryOrder;

@FeignClient("${indico.config.feign.route.order}")
public interface OrderFeign {

	@GetMapping(value = "${indico.config.feign.url.findOrderById}", produces = "application/json")
	public DeliveryOrder findOrderById(@PathVariable("orderId") Integer orderId);
}
