package com.alliance.dao;

import java.util.List;

import org.hibernate.Session;
import com.alliance.model.UserModel;
import com.alliance.util.HibernateUtil;

public class AutoDAO {
	public String getLastId()
	{	String s1="";
	
		Session s=HibernateUtil.getSessionFactory();
		List list=s.createQuery("from UserModel order by customerID DESC").list();
		UserModel um=(UserModel)list.get(0);
		s1=um.getCustomerID();
		return s1;
	}

}
