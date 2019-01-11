package com.alliance.dao;

import java.util.List;

import org.hibernate.Session;

import com.alliance.model.UserModel;
import com.alliance.util.HibernateUtil;

public class MailDAO {
	
	public String getMailID(UserModel um)
	{
		String cust_id=um.getCustomerID();
		
		Session s=HibernateUtil.getSessionFactory();
		
		List as=s.createQuery("select email from UserModel where customerID='"+cust_id+"'").list();
		
		String email=(String)as.get(0);
		
	
		return email;
				
		
		
	}

}
