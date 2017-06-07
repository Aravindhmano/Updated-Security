package com.niit.entertainment_backend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.entertainment_backend.model.Suppliermodel;

@Repository
public interface Supplierdao {

	List<Suppliermodel> getAllSupplierDetails();
    Suppliermodel getSupplierDetails(int id);
	void updateSupplierDetails(Suppliermodel obj);
	void addSupplierDetails(Suppliermodel obj);
	
	
	List<Suppliermodel> getAllCategoryDetails();
	

}