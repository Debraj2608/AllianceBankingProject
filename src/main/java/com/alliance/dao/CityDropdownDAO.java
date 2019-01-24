package com.alliance.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alliance.model.BranchModel;
import com.alliance.util.HibernateUtil;

public class CityDropdownDAO 
{
	public List<BranchModel> getCityList()
	{
		List<BranchModel> list = new ArrayList<BranchModel>();
		Session session = HibernateUtil.getSessionFactory();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			list = session.createQuery("from BranchModel").list();
			tx.commit();
		}
		catch(Exception e)
		{
			tx.rollback();
			System.out.println(e);
			list = null;
		}
		finally
		{
			session.close();
		}
		return list;
	}
}
