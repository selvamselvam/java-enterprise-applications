package com.siva;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;  
import org.hibernate.service.ServiceRegistry;
  
public class StoreData {  
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

public static void main(String[] args) {  
    Configuration cfg=new Configuration();  
    cfg.configure("hibernate.cfg.xml");  
      
    //creating seession factory object  
    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
    sessionFactory = cfg.buildSessionFactory(serviceRegistry);
    
    //creating session object  
    Session session=sessionFactory.openSession();  
      
    //creating transaction object  
    Transaction t=session.beginTransaction();  
          
    Employee e1=new Employee();  
    e1.setId(333);  
    e1.setFirstName("Selvam");  
    e1.setLastName("Ramasamy");  
      
    session.persist(e1);//persisting the object  
      
    t.commit();//transaction is committed  
    session.close();  
      
    System.out.println("successfully saved");  
      
}  
}  