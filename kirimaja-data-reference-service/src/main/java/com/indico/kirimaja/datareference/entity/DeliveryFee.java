package com.indico.kirimaja.datareference.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DeliveryFee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private Integer minDistance;
	private Integer maxDistance;
	private Double charge;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMinDistance() {
		return minDistance;
	}
	public void setMinDistance(Integer minDistance) {
		this.minDistance = minDistance;
	}
	public Integer getMaxDistance() {
		return maxDistance;
	}
	public void setMaxDistance(Integer maxDistance) {
		this.maxDistance = maxDistance;
	}
	public Double getCharge() {
		return charge;
	}
	public void setCharge(Double charge) {
		this.charge = charge;
	}
	
	
}
