package com.alliance.dao;

import java.util.List;

import org.hibernate.Session;

import com.alliance.model.BranchModel;
import com.alliance.util.HibernateUtil;

public class AutoGenBranchCodeDAO 
{
	public String getLastId()
	{	String s1 = "";
	
		Session sf = HibernateUtil.getSessionFactory();
		List s = sf.createQuery("from BranchModel ORDER BY branchCode DESC").list();
		BranchModel um = (BranchModel)s.get(0);
		s1=um.getBranchCode();
		return s1;
	}
}
