package com.niit.entertainment_backend.impl;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.entertainment_backend.dao.Teledao;
import com.niit.entertainment_backend.model.Telemodel;
@Repository
public  class Teledaoimpl implements Teledao
{

	@Autowired
	SessionFactory sessionFactory;
	
	public List<Telemodel> getAllProductDetails() {
		// TODO Auto-generated method stub
		Session sf=sessionFactory.openSession();
		sf.beginTransaction();
		Query query=sf.createQuery("from Telemodel");
		List<Telemodel> list1=query.list();
		System.out.println(list1);
		sf.getTransaction().commit();
		return list1;
	}
	public Telemodel getProductDetail(int id) {
		
		System.out.println("in get "+id);
		// TODO Auto-generated method stub
		return (Telemodel)sessionFactory.openSession().get(Telemodel.class,id);
	
	}
	
	/*public void updateProductDetails(Telemodel obj) {
		// TODO Auto-generated method stub
		
	}*/
	public void addProduct(Telemodel obj) 
	{
		System.out.println("In Add Product");
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.save(obj);
		s.getTransaction().commit();
		s.close();
		
		// TODO Auto-generated method stub
		
	}
/*	private Session currentSession;
	private Transaction currentTransaction;
	
	
	public Teledaoimpl() {
		
	}
	
	public Session openCurrentSession() {
	    currentSession = getSessionFactory().openSession();
	    return currentSession;
    }
	
	public Session openCurrentSessionwithTransaction() {
			currentSession = getSessionFactory().openSession();
			currentTransaction = currentSession.beginTransaction();
			return currentSession;
	}

    public void closeCurrentSession() {
    		currentSession.close();
    }
    
     public void closeCurrentSessionwithTransaction() {
         	currentTransaction.commit();
         	currentSession.close();
     }
     
	 private static SessionFactory getSessionFactory() {
		     
             Configuration configuration = new Configuration().configure();
             StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
             SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
             return sessionFactory;
     }
	
	    public Session getCurrentSession() {
		 	return currentSession;
     }

    public void setCurrentSession(Session currentSession) {
        	this.currentSession = currentSession;
     }

    public Transaction getCurrentTransaction() {
             return currentTransaction;
     }

     public void setCurrentTransaction(Transaction currentTransaction) {
    	 	this.currentTransaction = currentTransaction;
    }

	//Getting Product details from Model
	public List<Telemodel> getAllProductDetails()
	{
		List<Telemodel> products = (List<Telemodel>) getCurrentSession().createQuery("from ProductDetails").list();

        return products;
	}
	
	public Telemodel getProductDetail(String id)
	{
		Telemodel product = (Telemodel) getCurrentSession().get(Telemodel.class, id);

        return product;
	}
	
	public void updateProductDetails(Telemodel obj)
	{
		getCurrentSession().update(obj);
	
	}
	public void addProduct(Telemodel obj)
	{
		getCurrentSession().save(obj);
	}
*/
	public void updateProductDetails(Telemodel obj) 
	{
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.update(obj);
		s.getTransaction().commit();
		s.close();
		// TODO Auto-generated method stub
		
	}
	public void delete(Telemodel obj) {
		System.out.println("in Delete");
		  System.out.println(obj.getProdId());
		  Session s=sessionFactory.openSession();
		  s.beginTransaction();
			s.delete(obj);
			s.getTransaction().commit();
			s.close();
			
		// TODO Auto-generated method stub
		
	}
	public List<Telemodel> getProducts() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Telemodel> getFilterProducts(int category_Id) {
		Session s=sessionFactory.openSession();
		
		List<Telemodel> results =s.createQuery("from Telemodel where category_Id="+category_Id).list();
		s.close();
		// TODO Auto-generated method stub
		return results;
	}
	
}
