package com.niit.entertainment_backend.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.entertainment_backend.dao.Userdao;
import com.niit.entertainment_backend.model.Usermodel;
import com.niit.entertainment_backend.model.Usermodel;

@Repository
public class Userdaoimpl implements Userdao{

@Autowired
private SessionFactory sessionFactory;

public void setSessionFactory(SessionFactory sf)
{
	this.sessionFactory=sf;
}

public List<Usermodel> getAllUserDetails() {
	/*// TODO Auto-generated method stub
	Session sf=sessionFactory.openSession();
	sf.beginTransaction();
	Query query=sf.createQuery("From Usermodel");
	List<Usermodel> list1=query.list();
	System.out.println(list1);
	sf.getTransaction().commit();*/
	
	return null;
}

public void addUserDetails(Usermodel obj) 
{
	System.out.println("In Add User");
	Session s=sessionFactory.openSession();
	s.beginTransaction();
	s.save(obj);
	s.getTransaction().commit();
	s.close();
	
	// TODO Auto-generated method stub
	
}

public Usermodel getUserDetails(String id) {
	// TODO Auto-generated method stub
	return null;
}

public void updateUserDetails(Usermodel obj) {
	// TODO Auto-generated method stub
	
}
}
