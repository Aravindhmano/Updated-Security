package com.niit.entertainment_backend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.entertainment_backend.model.Ordersmodel;

@Repository
public interface Ordersdao {

	List<Ordersmodel> getAllOrderDetails();
	Ordersmodel getOrderDetails(String id);
	void updateOrderDetails(Ordersmodel obj);
	void addOrderDetails(Ordersmodel obj);

}
