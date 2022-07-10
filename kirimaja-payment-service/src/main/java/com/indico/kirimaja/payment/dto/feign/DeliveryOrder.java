package com.indico.kirimaja.payment.dto.feign;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DeliveryOrder implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer orderId;
	private Integer orderStatusId;
	private int userId;
	private String recepientName;
	private String recepientPhoneNumber;
	private String pickUpAddress;
	private String pickUpProvince;
	private String pickUpCity;
	private String pickUpDistrict;
	private Double pickUpLatitude;
	private Double pickUpLongitude;
	private String pickUpVillage;
	private String dropOffAddress;
	private String dropOffProvince;
	private String dropOffCity;
	private String dropOffDistrict;
	private String dropOffVillage;
	private Double dropOffLatitude;
	private Double dropOffLongitude;
	private String notes;
	private Double distance;
	private Integer deliveryFeeId;
	private Double deliveryFeeTotalCharge;
	private Integer deliveryItemsId;
	private Double weight;
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getOrderStatusId() {
		return orderStatusId;
	}
	public void setOrderStatusId(Integer orderStatusId) {
		this.orderStatusId = orderStatusId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getRecepientName() {
		return recepientName;
	}
	public void setRecepientName(String recepientName) {
		this.recepientName = recepientName;
	}
	public String getRecepientPhoneNumber() {
		return recepientPhoneNumber;
	}
	public void setRecepientPhoneNumber(String recepientPhoneNumber) {
		this.recepientPhoneNumber = recepientPhoneNumber;
	}
	public String getPickUpAddress() {
		return pickUpAddress;
	}
	public void setPickUpAddress(String pickUpAddress) {
		this.pickUpAddress = pickUpAddress;
	}
	public String getPickUpProvince() {
		return pickUpProvince;
	}
	public void setPickUpProvince(String pickUpProvince) {
		this.pickUpProvince = pickUpProvince;
	}
	public String getPickUpCity() {
		return pickUpCity;
	}
	public void setPickUpCity(String pickUpCity) {
		this.pickUpCity = pickUpCity;
	}
	public String getPickUpDistrict() {
		return pickUpDistrict;
	}
	public void setPickUpDistrict(String pickUpDistrict) {
		this.pickUpDistrict = pickUpDistrict;
	}
	public String getPickUpVillage() {
		return pickUpVillage;
	}
	public void setPickUpVillage(String pickUpVillage) {
		this.pickUpVillage = pickUpVillage;
	}
	public String getDropOffAddress() {
		return dropOffAddress;
	}
	public void setDropOffAddress(String dropOffAddress) {
		this.dropOffAddress = dropOffAddress;
	}
	public String getDropOffProvince() {
		return dropOffProvince;
	}
	public void setDropOffProvince(String dropOffProvince) {
		this.dropOffProvince = dropOffProvince;
	}
	public String getDropOffCity() {
		return dropOffCity;
	}
	public void setDropOffCity(String dropOffCity) {
		this.dropOffCity = dropOffCity;
	}
	public String getDropOffDistrict() {
		return dropOffDistrict;
	}
	public void setDropOffDistrict(String dropOffDistrict) {
		this.dropOffDistrict = dropOffDistrict;
	}
	public String getDropOffVillage() {
		return dropOffVillage;
	}
	public void setDropOffVillage(String dropOffVillage) {
		this.dropOffVillage = dropOffVillage;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public Integer getDeliveryFeeId() {
		return deliveryFeeId;
	}
	public void setDeliveryFeeId(Integer deliveryFeeId) {
		this.deliveryFeeId = deliveryFeeId;
	}
	public Double getDeliveryFeeTotalCharge() {
		return deliveryFeeTotalCharge;
	}
	public void setDeliveryFeeTotalCharge(Double deliveryFeeTotalCharge) {
		this.deliveryFeeTotalCharge = deliveryFeeTotalCharge;
	}
	public Integer getDeliveryItemsId() {
		return deliveryItemsId;
	}
	public void setDeliveryItemsId(Integer deliveryItemsId) {
		this.deliveryItemsId = deliveryItemsId;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getPickUpLatitude() {
		return pickUpLatitude;
	}
	public void setPickUpLatitude(Double pickUpLatitude) {
		this.pickUpLatitude = pickUpLatitude;
	}
	public Double getPickUpLongitude() {
		return pickUpLongitude;
	}
	public void setPickUpLongitude(Double pickUpLongitude) {
		this.pickUpLongitude = pickUpLongitude;
	}
	public Double getDropOffLatitude() {
		return dropOffLatitude;
	}
	public void setDropOffLatitude(Double dropOffLatitude) {
		this.dropOffLatitude = dropOffLatitude;
	}
	public Double getDropOffLongitude() {
		return dropOffLongitude;
	}
	public void setDropOffLongitude(Double dropOffLongitude) {
		this.dropOffLongitude = dropOffLongitude;
	}
	
	
}
