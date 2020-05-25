package com.goonestep.goonestepClothesAppBackEnd.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table( name="orders",
uniqueConstraints = { 
		@UniqueConstraint(columnNames = "orderId") })
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	
	private String name;
	private Long userId;
	private Long productId;
	private String email;
    private boolean approvedOrder;
	private boolean rejectedOrder;
	private String address;
	private Long pincode;
	private Long phoneNumber;
	private double totalCost;
	private Long quantity;
	private boolean canceledOrder;
	private boolean orderStatus;
	
	
	public Order() {
		super();
	}
	public Order(Long orderId, String name, Long userId, Long productId,String email,boolean approvedOrder,boolean rejectedOrder, String address,
			Long pincode, Long phoneNumber,double totalCost,Long quantity,boolean canceledOrder,boolean orderStatus) {
		super();
		this.orderId = orderId;
		this.name = name;
		this.userId = userId;
		this.productId = productId;
	    this.email=email;
	    this.approvedOrder=approvedOrder;
	    this.rejectedOrder=rejectedOrder;
	    this.canceledOrder=canceledOrder;
		this.address = address;
		this.pincode = pincode;
		this.phoneNumber = phoneNumber;
		this.totalCost=totalCost;
		this.quantity=quantity;
		this.orderStatus=orderStatus;
	}
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public boolean isOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(boolean orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public boolean isApprovedOrder() {
		return approvedOrder;
	}
	public void setApprovedOrder(boolean approvedOrder) {
		this.approvedOrder = approvedOrder;
	}
	public boolean isRejectedOrder() {
		return rejectedOrder;
	}
	public void setRejectedOrder(boolean rejectedOrder) {
		this.rejectedOrder = rejectedOrder;
	}
	public boolean isCanceledOrder() {
		return canceledOrder;
	}
	public void setCanceledOrder(boolean canceledOrder) {
		this.canceledOrder = canceledOrder;
	}
}
