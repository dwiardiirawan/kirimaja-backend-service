package com.indico.kirimaja.order.dto.response;

import java.io.Serializable;

import com.indico.kirimaja.order.entity.DeliveryOrder;

public class OrderResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int status;
	private DeliveryOrder order;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public DeliveryOrder getOrder() {
		return order;
	}
	public void setOrder(DeliveryOrder order) {
		this.order = order;
	}
	
	
	
	
}
