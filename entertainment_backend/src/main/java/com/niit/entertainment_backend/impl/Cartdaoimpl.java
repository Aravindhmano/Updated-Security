package com.niit.entertainment_backend.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.entertainment_backend.dao.Cartdao;
import com.niit.entertainment_backend.model.Cartmodel;

@Repository
public class Cartdaoimpl  implements Cartdao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void save(Cartmodel cart1)
	{
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.save(cart1);
		s.getTransaction().commit();
		s.close();
		
	}

	public Cartmodel getId(int id) {
		// TODO Auto-generated method stub
		return (Cartmodel)sessionFactory.openSession().get(Cartmodel.class,id);
		
	}

	public void update(Cartmodel cart) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.update(cart);
		s.getTransaction().commit();
		s.close();
		
	}

	public void deleteById(Cartmodel p) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.delete(p);
		s.getTransaction().commit();
		s.close();

		
	}

	public List<Cartmodel> getAll() {
		Session s=sessionFactory.openSession();
		List<Cartmodel> clist=s.createCriteria(Cartmodel.class).list();
		s.clear();
		return clist;
	}

	public List<Cartmodel> checkExistance(int pid) 
	{
        Session s=sessionFactory.openSession();		
        List<Cartmodel> results =s.createQuery("from Cartmodel where productid="+pid).list();		
		s.close();
		return results;
	}
	      
		
}
