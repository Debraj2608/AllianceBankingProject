package com.alliance.dao;

import java.util.List;

import org.hibernate.Session;

import com.alliance.model.AccountModel;
import com.alliance.util.HibernateUtil;

public class GetAccountDAO {
	
	
	public AccountModel getAccountNumber(String cust_id)
	{
		String acc_no="";
		
		Session s=HibernateUtil.getSessionFactory();
		
		List s1=s.createQuery("from UserModel where customerID='"+cust_id+"'").list();
		AccountModel am=(AccountModel)s1.get(0);
		acc_no=am.getAccount_no();
		
		return am;
	}
	public AccountModel getAccountObject(String acc_no)
	{	
		Session s=HibernateUtil.getSessionFactory();
		
		List s1=s.createQuery("from UserModel where account_no='"+acc_no+"'").list();
		AccountModel am=(AccountModel)s1.get(0);
		return am;	
	}
}