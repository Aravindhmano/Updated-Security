package com.niit.entertainment_backend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.entertainment_backend.model.Categorymodel;

@Repository
public interface Categorydao {

	List<Categorymodel> getAllCategoryDetails();
    Categorymodel getCategoryDetails(int id);
	void updateCategoryDetails(Categorymodel obj);
	void addCategoryDetails(Categorymodel obj);

}
