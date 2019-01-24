package com.alliance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alliance.model.BranchModel;
import com.alliance.model.UserModel;
import com.alliance.util.HibernateUtil;

public class GetBranchCodeDAO 
{
	public String getBranchCode(UserModel userModel)
	{
		String branchCode = null;
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			UserModel user = session.get(UserModel.class, userModel.getCustomerID());
			String city = user.getCity();
			List<BranchModel> branchCodeList = session.createQuery("from BranchModel where city = '"+city+"'").list();
			BranchModel branch = branchCodeList.get(0);
			branchCode = branch.getBranchCode();
			System.out.println(branchCode);
			tx.commit();
		}
		catch(Exception e)
		{
			tx.rollback();
			System.out.println(e);
			branchCode = null;
		}
		finally
		{
			session.close();
		}
		return branchCode;
	}
}
