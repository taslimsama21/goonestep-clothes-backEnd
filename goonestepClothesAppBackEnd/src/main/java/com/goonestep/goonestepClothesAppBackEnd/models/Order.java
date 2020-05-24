package com.goonestep.goonestepClothesAppBackEnd.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table( name="order",
uniqueConstraints = { 
		@UniqueConstraint(columnNames = "name") })
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="userId")
	private long userId;
	
	@Column(name="productId")
	private long productId;
	
	private String email;
    private boolean approvedOrder;
	private boolean rejectedOrder;
	private String address;
	private long pincode;
	private long phoneNumber;
	private double totalCost;
	private int quantity;
	
	public Order() {
		super();
	}
	public Order(Long orderId, String name, Long userId, Long productId,String email,boolean approvedOrder,boolean rejectedOrder, String address,
			long pincode, long phoneNumber,double totalCost,int quantity) {
		super();
		this.orderId = orderId;
		this.name = name;
		this.userId = userId;
		this.productId = productId;
	    this.email=email;
	    this.approvedOrder=approvedOrder;
	    this.rejectedOrder=rejectedOrder;
		this.address = address;
		this.pincode = pincode;
		this.phoneNumber = phoneNumber;
		this.totalCost=totalCost;
		this.quantity=quantity;
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
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
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
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
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
}
