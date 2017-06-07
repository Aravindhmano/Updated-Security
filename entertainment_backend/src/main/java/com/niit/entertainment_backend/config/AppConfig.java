package com.niit.entertainment_backend.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.entertainment_backend.dao.Categorydao;
import com.niit.entertainment_backend.dao.Teledao;
import com.niit.entertainment_backend.impl.Categorydaoimpl;
import com.niit.entertainment_backend.impl.Teledaoimpl;
import com.niit.entertainment_backend.model.Cartmodel;
import com.niit.entertainment_backend.model.Categorymodel;
import com.niit.entertainment_backend.model.Ordersmodel;
import com.niit.entertainment_backend.model.Suppliermodel;
import com.niit.entertainment_backend.model.Telemodel;
import com.niit.entertainment_backend.model.Usermodel;

//import com.niit.service.ProductService;

@Configuration
@ComponentScan("com.niit.entertainment_backend")
@EnableTransactionManagement
public class AppConfig 
{
	   // @Autowired
	    @Bean(name = "datasource")
	    public DataSource getH2DataSource() {

	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	            
	        dataSource.setUrl("jdbc:h2:tcp://localhost/~/mydb2");

	        dataSource.setDriverClassName("org.h2.Driver");

	        dataSource.setUsername("sa");
	        dataSource.setPassword("");
	        
	        
	        return dataSource;
	    }
	    
	   private Properties getHibernateProperties() {
	        Properties properties = new Properties();
	        properties.put("hibernate.show_sql", "true");
	        properties.put("hibernate.hbm2ddl.auto", "update");
	        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	        properties.put("hibernate.format_sql", "true");
	        properties.setProperty("hibernate.hbm2ddl.auto", "update");
	        return properties;
	    }
	   @Autowired
	    @Bean(name = "sessionFactory")
	    public SessionFactory getSessionFactory(DataSource dataSource) {

	        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	        sessionBuilder.addProperties(getHibernateProperties());
	        sessionBuilder.addAnnotatedClass(Telemodel.class);
	        sessionBuilder.addAnnotatedClass(Categorymodel.class);
	        sessionBuilder.addAnnotatedClass(Cartmodel.class);
	        sessionBuilder.addAnnotatedClass(Ordersmodel.class);
	        sessionBuilder.addAnnotatedClass(Suppliermodel.class);
	        sessionBuilder.addAnnotatedClass(Usermodel.class);
	        return sessionBuilder.buildSessionFactory();
	    }

	    @Autowired
	    @Bean(name = "transactionManager")
	    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
	        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

	        return transactionManager;
	    }

	    
	    
	   /*@Autowired
	    @Bean(name = "Telemodel")
	    public Teledao getTeledao(SessionFactory sessionFactory) {
	        return new Teledaoimpl(sessionFactory);
	    }*/
	    
/*	    @Autowired
	    @Bean(name = "Categorydao")
	    public Categorydao getCategorydao(SessionFactory sessionFactory) {
	        return new Categorydaoimpl(sessionFactory);
	    }*/
	    
	   /*@Autowired
	    @Bean(name = "Telemodel")
	    public Teledao getTeledao(SessionFactory sessionFactory) {
	        return new Teledaoimpl(sessionFactory);
	    }*/
}
	   
































/*import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import com.niit.entertainment_backend.model.*;

public class HibernateConfiguration {
private static final SessionFactory concreteSessionFactory;
static {
try {
Properties prop= new Properties();
prop.setProperty("hibernate.connection.url", "jdbc:h2:tcp://localhost/~/test1");
prop.setProperty("hibernate.connection.username", "sa");
prop.setProperty("hibernate.connection.password", "");
prop.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
prop.setProperty("hibernate.hbm2ddl.auto", "create");

concreteSessionFactory = new AnnotationConfiguration()
  .addPackage("com.concretepage.persistence")
  .addProperties(prop)
  .addAnnotatedClass(Telemodel.class)
  .buildSessionFactory();
} catch (Throwable ex) {
throw new ExceptionInInitializerError(ex);
}
}
public static SessionFactory getSessionFactory()
throws HibernateException {
return concreteSessionFactory;
}
}*/