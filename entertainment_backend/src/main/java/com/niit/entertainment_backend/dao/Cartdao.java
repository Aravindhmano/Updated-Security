package com.niit.entertainment_backend.dao;

import java.util.List;

import com.niit.entertainment_backend.model.Cartmodel;


public interface Cartdao {

	//save
		public void save(Cartmodel cart);
	    //read
			public Cartmodel getId(int id);
			//update
			public void update(Cartmodel cart);
			//deleted
			public void deleteById(Cartmodel id);
			//Get All
			public List<Cartmodel> getAll();
			
			public List<Cartmodel> checkExistance(int pid);
}
