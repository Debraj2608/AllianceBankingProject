package com.alliance.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alliance.model.UserModel;
import com.alliance.util.HibernateUtil;

public class SearchDAO {

	@SuppressWarnings("unchecked")
	public List<UserModel> getUserList(String stype, String user) {

		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory();
		tx = session.beginTransaction();
		List<UserModel> lum = null;
		if ("acid".equals(stype)) {
			//UserModel u = (UserModel) session.get(UserModel.class, user);
			//lum.add(u);
		lum = session.createQuery("from UserModel where accountModel_account_no = '"+user+"'").list();

		}
		if ("uname".equals(stype)) {
			//UserModel u = (UserModel) session.get(UserModel.class, user);
			//lum.add(u);
			lum = session.createQuery("from UserModel where firstName Like '%"+user+"%'").list();

		}

		tx.commit();

		return lum;
	}
}
