package com.niit.entertainment_backend.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.entertainment_backend.dao.Supplierdao;
import com.niit.entertainment_backend.model.Suppliermodel;
@Repository
public class Supplierdaoimpl implements Supplierdao {
	@Autowired
	SessionFactory sessionFactory;
	
	/*public List<Suppliermodel> getAllSupplierDetails() {
		
			Session s=sessionFactory.openSession();
			s.beginTransaction();
			List<Suppliermodel> list=s.createQuery("from Suppliermodel").list();
			s.getTransaction().commit();
			return list;
		}*/
		
	public List<Suppliermodel> getAllSupplierDetails() {
		// TODO Auto-generated method stub
		Session sf =sessionFactory.openSession();
		sf.beginTransaction();
		
		List<Suppliermodel> list=sf.createCriteria(Suppliermodel.class).list();
		System.out.println(list);
		sf.getTransaction().commit();
		return list;
		
	}	

	public Suppliermodel getSupplierDetails(int id) {
		Suppliermodel s=sessionFactory.openSession().get(Suppliermodel.class, id);
		return s;
	}

	public void updateSupplierDetails(Suppliermodel obj) {
		// TODO Auto-generated method stub
		
	}


	public void addSupplierDetails(Suppliermodel obj) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.save(obj);
		s.getTransaction().commit();
		s.close();
		
	}

	public List<Suppliermodel> getAllCategoryDetails() {
		Session sf =sessionFactory.openSession();
		sf.beginTransaction();
		Query query = sf.createQuery("from Suppliermodel");
		List<Suppliermodel> slist=query.list();
		System.out.println(slist);
		sf.getTransaction().commit();
		return slist;
	}

	
}
