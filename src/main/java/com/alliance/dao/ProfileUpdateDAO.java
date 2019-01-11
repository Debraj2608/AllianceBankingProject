package com.alliance.dao;

import org.hibernate.Session;
import com.alliance.model.UserModel;
import com.alliance.util.HibernateUtil;

public class ProfileUpdateDAO {

	public boolean update(UserModel um) {
		boolean status = false;
		Session session = HibernateUtil.getSessionFactory();
		String city = um.getCity();
		String cno = um.getContactNumber();
		String cid = um.getCustomerID();
		String occu = um.getOccupation();
		String pass = um.getPassword();
		try {
			if (city != null || city.length() > 0) {
				session.createQuery("update UserModel SET city='" + city + "'WHERE userID='" + cid + "'");
				status = true;

			}
			if (cno != null || cno.length() > 0) {
				session.createQuery("update UserModel SET contactNumber='" + cno + "'WHERE userID='" + cid + "'");
				status = true;

			}
			if (pass != null || pass.length() > 0) {
				session.createQuery("update UserModel SET password='" + pass + "'WHERE userID='" + cid + "'");
				status = true;

			}
			if (occu != null || occu.length() > 0) {
				session.createQuery("update UserModel SET occupation='" + occu + "'WHERE userID='" + cid + "'");
				status = true;

			}
		} catch (Exception e) {
			status=false;
		}
		finally {
			session.close();
		}
		return status;
	}
}