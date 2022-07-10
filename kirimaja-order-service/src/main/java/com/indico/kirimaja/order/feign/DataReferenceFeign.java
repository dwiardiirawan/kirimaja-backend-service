package com.indico.kirimaja.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${indico.config.feign.route.dataReference}")
public interface DataReferenceFeign {

	@GetMapping("${indico.config.feign.url.calculateFee}")
	public Double calculateTotalFeeByDistance(@PathVariable("distance") int distance);
}
