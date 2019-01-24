package com.alliance.dao;

import java.util.List;

import org.hibernate.Session;

import com.alliance.model.UserModel;
import com.alliance.util.HibernateUtil;

public class SearchDAO {

	@SuppressWarnings("unchecked")
	public List<UserModel> getUserList(String stype, String user) {

		Session session = HibernateUtil.getSessionFactory();
		List<UserModel> lum = null;
		if ("acid".equals(stype)) {
		lum = session.createQuery("from UserModel where accountModel_account_no Like '%"+user+"%'").list();
		}
		if ("uname".equals(stype)) {
			lum = session.createQuery("from UserModel where firstName Like '%"+user+"%'").list();
		}
		if ("actype".equals(stype)) {
			lum = session.createQuery("from UserModel where account_type Like '%"+user+"%'").list();
		}
		return lum;
	}
}
