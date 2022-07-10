package com.indico.kirimaja.order.facade.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.indico.kirimaja.order.common.Constant;
import com.indico.kirimaja.order.entity.DeliveryOrder;
import com.indico.kirimaja.order.facade.DeliveryOrderFacade;
import com.indico.kirimaja.order.feign.DataReferenceFeign;
import com.indico.kirimaja.order.services.OrderService;

@Component
public class DeliveryOrderFacadeImpl implements DeliveryOrderFacade {

	private static final Logger LOG = LoggerFactory.getLogger(DeliveryOrderFacadeImpl.class);
	
	@Autowired
	private OrderService orderService;
		
	@Autowired
	private DataReferenceFeign dataReferenceFeign;
	
	@Override
	public DeliveryOrder createDeliveryOrder(DeliveryOrder order) throws Exception {
		boolean isWeightPermitted = WeightValidation(order.getWeight());
		if(!isWeightPermitted)
			throw new Exception(Constant.ERROR_WEIGHT_MSG);
		
		LOG.info("Pick Up Latitude: {}, Pick Up Longitude: {}", order.getPickUpLatitude(), order.getPickUpLongitude());
		LOG.info("Drop Off Up Latitude: {}, Drop Off Longitude: {}", order.getPickUpLatitude(), order.getPickUpLongitude());
		double distance = calculateDistance(order.getDropOffLatitude().doubleValue(), order.getDropOffLongitude().doubleValue(), order.getDropOffLatitude().doubleValue(), order.getDropOffLongitude().doubleValue());

		LOG.info("DeliveryOrderFacadeImpl.createDeliveryOrder(). Order Id: {} has delivery distance: {}", order.getOrderId(), distance);
		double totalDeliveryFee = dataReferenceFeign.calculateTotalFeeByDistance(11);
		order.setDeliveryFeeTotalCharge(totalDeliveryFee);
		LOG.info("DeliveryOrderFacadeImpl.createDeliveryOrder(). Total Delivery Fee: {}", totalDeliveryFee);
		return order;
	}

	//source: https://www.geodatasource.com/developers/java
	private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		}
		else {
			double theta = lon1 - lon2;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
		    dist = dist * 1.609344;
			
			return (dist);
		}
	}


	private boolean WeightValidation(Double weight) {
		if(weight.doubleValue() <= Constant.MAX_WEIGHT) {
			return true;
		}
		return false;
	}

}
