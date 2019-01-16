package com.alliance.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.alliance.model.UserModel;
import com.alliance.util.HibernateUtil;

public class AdminDispDAO {
	
	@SuppressWarnings("unchecked")
	public List<UserModel> returnUnapproved()
	{ 
		List<UserModel> al=new ArrayList<UserModel>();
		Session s=HibernateUtil.getSessionFactory();
		
		al=s.createQuery("from UserModel where accountModel_account_no ="+null).list();
		System.out.println(al.size());
		return al;
	}

}
