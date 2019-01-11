package com.alliance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.alliance.model.AccountModel;
import com.alliance.util.HibernateUtil;

public class AutoGenDAO {

	public String getLastId()
	{	String s1="";
	
		Session sf=HibernateUtil.getSessionFactory();
		List s=sf.createQuery("from AccountModel ORDER BY account_no DESC").list();
		AccountModel um=(AccountModel)s.get(0);
		s1=um.getAccount_no();
		return s1;
	}
}
