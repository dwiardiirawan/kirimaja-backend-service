package com.indico.kirimaja.datareference.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indico.kirimaja.datareference.entity.DeliveryFee;
import com.indico.kirimaja.datareference.repositories.DeliveryFeeRepository;
import com.indico.kirimaja.datareference.service.DeliveryFeeService;

@Service
public class DeliveryFeeServiceImpl implements DeliveryFeeService {

	private static final Logger LOG = LoggerFactory.getLogger(DeliveryFeeServiceImpl.class);
	@Autowired
	private DeliveryFeeRepository deliveryFeeRepository;
	
	@Override
	public Double calculateCost(int distance) {
		double totalDeliveryFee = 0;
		DeliveryFee deliveryFee = deliveryFeeRepository.findByMinDistanceAndMaxDistance(distance);
		if(deliveryFee!=null) {
			totalDeliveryFee = distance * deliveryFee.getCharge().doubleValue();
		}
		return totalDeliveryFee;
	}

	@Override
	public List<DeliveryFee> getAllDeliveryFee() {
		List<DeliveryFee> list = deliveryFeeRepository.findAll();
		if(!list.isEmpty())
			LOG.info("found {} delivery fee data configuration");
		return list;
	}



}
