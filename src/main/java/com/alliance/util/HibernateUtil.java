package com.alliance.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;


@SuppressWarnings("deprecation")
public class HibernateUtil 
{
	 private static final SessionFactory sessionFactory;
     
	    static{
	        try{
	            sessionFactory = new Configuration().configure().buildSessionFactory();
	 
	        }catch (Throwable ex) {
	            System.out.println("cannot initialize sessionfactory"+ex);
	            throw new ExceptionInInitializerError(ex);
	        }   
	    }
	     
	    public static Session getSessionFactory() 
	    {
	    	Session session = sessionFactory.openSession();
	        return session;
	    }
}