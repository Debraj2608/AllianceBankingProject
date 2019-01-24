package com.alliance.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alliance.model.BranchModel;
import com.alliance.util.HibernateUtil;

public class AddBranchCodeDAO 
{
	public BranchModel addBranch(BranchModel branchModel)
	{
		BranchModel details = null;
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			session.save(branchModel);
			tx.commit();
			details = branchModel;
		}
		catch(Exception e)
		{
			tx.rollback();
			System.out.println(e);
			details = null;
		}
		finally
		{
			session.close();
		}
		
		return details; 
		
	}
}
