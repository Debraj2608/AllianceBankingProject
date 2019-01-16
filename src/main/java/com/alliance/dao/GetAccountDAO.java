package com.alliance.dao;

import java.util.List;

import org.hibernate.Session;

import com.alliance.model.AccountModel;
import com.alliance.model.UserModel;
import com.alliance.util.HibernateUtil;

public class GetAccountDAO {
	
	
	public String getAccountNumber(String cust_id)
	{
		String acc_no="";
		
		Session s=HibernateUtil.getSessionFactory();
		
		List s1=s.createQuery("from UserModel where customerID='"+cust_id+"'").list();
		UserModel user=(UserModel)s1.get(0);
		acc_no = user.getAccountModel().getAccount_no();
		
		return acc_no;
	}
	public AccountModel getAccountObject(String acc_no)
	{	
		Session s=HibernateUtil.getSessionFactory();
		
		List s1=s.createQuery("from UserModel where account_no='"+acc_no+"'").list();
		AccountModel am=(AccountModel)s1.get(0);
		return am;	
	}
}