package com.niit.entertainment_backend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.entertainment_backend.model.Usermodel;

@Repository
public interface Userdao {

	List<Usermodel> getAllUserDetails();
	Usermodel getUserDetails(String id);
	void updateUserDetails(Usermodel obj);
	void addUserDetails(Usermodel obj);

}

