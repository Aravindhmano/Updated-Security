package com.niit.entertainment_backend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
/*@Table(name="OrderDetails",uniqueConstraints = {
		@UniqueConstraint(columnNames = "orderId")})*/
@Table(name="OrderDetails")
public class Ordersmodel implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="orderId")
	private Integer orderId;
/*	@Column(name="orderUserId")
	private String orderUserId;*/
	
	@ManyToOne
	@JoinColumn(name="userId")
	private Usermodel userId;
	
	
	@Column(name="orderPayment")
	private String orderPayment;
	@Column(name="orderTotal")
	private double orderTotal;
	
	public Ordersmodel()
	{
		
	}

	public Ordersmodel(Integer orderId,  Usermodel userId, String orderPayment,
			double orderTotal) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.orderPayment = orderPayment;
		this.orderTotal = orderTotal;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}


	public Usermodel getUserId() {
		return userId;
	}

	public void setUserId(Usermodel userId) {
		this.userId = userId;
	}

	public String getOrderPayment() {
		return orderPayment;
	}

	public void setOrderPayment(String orderPayment) {
		this.orderPayment = orderPayment;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}