package com.indico.kirimaja.datareference.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.indico.kirimaja.datareference.entity.CountryPhoneCode;
import com.indico.kirimaja.datareference.entity.DeliveryFee;
import com.indico.kirimaja.datareference.repositories.CountryPhoneCodeRepository;
import com.indico.kirimaja.datareference.repositories.DeliveryFeeRepository;
import com.indico.kirimaja.datareference.service.DeliveryFeeService;


@RestController
@RequestMapping("/${spring.application.name}/*")
public class DataReferenceController {
	
	
    private static final Logger LOG = LoggerFactory.getLogger(DataReferenceController.class);

	@Autowired
	private CountryPhoneCodeRepository countryPhoneCodeRepository;
	
	@Autowired
	private DeliveryFeeService deliveryFeeService;

	@GetMapping("${indico.controllers.url.country-phone-code-list}")
	public List<CountryPhoneCode> getAllCountryPhoneCode(){
		List<CountryPhoneCode> list = countryPhoneCodeRepository.findAll();
		if(!list.isEmpty())
			LOG.info("found {} country code data configuration", list.size());
		return list;
	}
	
	@GetMapping("${indico.controllers.url.country-phone-code-by-id}")
	public CountryPhoneCode getCountryPhoneCodeById(@PathVariable("countryCode") String countryCode) {
		CountryPhoneCode countryPhoneCode = countryPhoneCodeRepository.getByCountryCode(countryCode);
		return countryPhoneCode;
	}
	
	@GetMapping("${indico.controllers.url.delivery-fee-list}")
	public List<DeliveryFee> getDeliveryFees(){
		return deliveryFeeService.getAllDeliveryFee();
	}
	
	@GetMapping("${indico.controllers.url.calculate-fee}")
	public Double calculateTotalFeeByDistance(@PathVariable("distance") int distance) {
		return deliveryFeeService.calculateCost(distance);
	}
	
}
