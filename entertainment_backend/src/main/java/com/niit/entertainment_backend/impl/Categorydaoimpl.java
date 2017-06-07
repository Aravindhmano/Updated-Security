package com.niit.entertainment_backend.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.entertainment_backend.dao.Categorydao;
import com.niit.entertainment_backend.model.Categorymodel;

@Repository
public class Categorydaoimpl implements Categorydao {
	@Autowired
	private SessionFactory sessionFactory;
	
/*	public Categorydaoimpl(SessionFactory sessionFactory )
	{
		this.sessionFactory=sessionFactory;
		
	}*/
	public Categorydaoimpl(){}
	public List<Categorymodel> getAllCategoryDetails() {
		// TODO Auto-generated method stub
		Session sf =sessionFactory.openSession();
		sf.beginTransaction();
		Query query = sf.createQuery("from Categorymodel");
		List<Categorymodel> list=query.list();
		System.out.println(list);
		sf.getTransaction().commit();
		return list;
		
	}
		
		
	/*	Session session=sessionFactory.openSession();
		List<Categorymodel> category=null;
		session.beginTransaction();
		category=session.createQuery("from Categorymodel").list();
		session.getTransaction().commit();
	
		
		return category ;*/


	public Categorymodel getCategoryDetails(int id)
	{
		Categorymodel c=(Categorymodel)sessionFactory.openSession().get(Categorymodel.class, id);
		// TODO Auto-generated method stub
		return c;
	}

	public void updateCategoryDetails(Categorymodel obj) {
		// TODO Auto-generated method stub
		
	}

	public void addCategoryDetails(Categorymodel obj) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.save(obj);
		s.getTransaction().commit();
		s.close();
		
	}

}
