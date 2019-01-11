package com.alliance.dao;

import java.util.List;

import org.hibernate.Session;
import com.alliance.model.AdminModel;
import com.alliance.util.HibernateUtil;

public class AdminLoginDAO 
{
	public boolean validateAdmin(AdminModel adminModel)
	{
		boolean status = false;
		Session session = HibernateUtil.getSessionFactory();
		String adminID = adminModel.getAdminID();
		String password = adminModel.getPassword();
		List as = session.createQuery("from AdminModel where adminID = '"+adminID+"' and password = '"+password+"'").list();	
		
		if(as.isEmpty())
		{
			status = false;
		}
		else
		{
			status = true;
		}
	return status;
	}
}