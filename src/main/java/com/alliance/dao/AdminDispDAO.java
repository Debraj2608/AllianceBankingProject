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
		
		al=s.createQuery("from UserModel where customerID not in(select userModel from AccountModel)").list();
		System.out.println(al.size());
		return al;
	}

}
