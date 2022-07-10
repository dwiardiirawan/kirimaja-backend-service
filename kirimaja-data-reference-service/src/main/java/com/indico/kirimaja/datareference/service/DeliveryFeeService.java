package com.indico.kirimaja.datareference.service;

import java.util.List;

import com.indico.kirimaja.datareference.entity.DeliveryFee;

public interface DeliveryFeeService {
	Double calculateCost(int distance);
	List<DeliveryFee> getAllDeliveryFee();
}
