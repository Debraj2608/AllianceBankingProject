package com.alliance.dao;

import java.util.List;

import org.hibernate.Session;

import com.alliance.model.TransactionModel;
import com.alliance.util.HibernateUtil;

public class GenerateTidDAO {
	
	
	public String getLastID()
	{
		String last="";
		Session sf=HibernateUtil.getSessionFactory();
		List s=sf.createQuery("from TransactionModel DESC Limit 1").list();
		TransactionModel um=(TransactionModel)s.get(0);
		last=um.getTransaction_id();
		
		
		return last;
	}
	

}
