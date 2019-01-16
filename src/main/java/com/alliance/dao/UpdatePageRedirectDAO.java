package com.alliance.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.alliance.model.UserModel;
import com.alliance.util.HibernateUtil;

public class UpdatePageRedirectDAO {

	public UserModel initialize(String customerID) {
		Transaction tx = null;
		UserModel um = new UserModel();
		Session session = HibernateUtil.getSessionFactory();
		tx = session.beginTransaction();
		UserModel u = (UserModel) session.get(UserModel.class, customerID);
		try {
			um.setCustomerID(customerID);
			um.setCity(u.getCity());
			um.setContactNumber(u.getContactNumber());
			um.setOccupation(u.getOccupation());
			um.setPassword(u.getPassword());
			tx.commit();

			/*
			 * try { if (city != null || city.length() > 0) { Query
			 * qu=session.createQuery("update UserModel SET city=:p1 WHERE customerID=:p2");
			 * qu.setParameter("p1",city); qu.setParameter("p2",cid); tx =
			 * session.beginTransaction(); int n=qu.executeUpdate(); tx.commit(); status =
			 * true; } if (cno != null || cno.length() > 0) { Query qu=session.
			 * createQuery("update UserModel SET contactNumber=:p1 WHERE customerID=:p2");
			 * qu.setParameter("p1",cno); qu.setParameter("p2",cid); tx =
			 * session.beginTransaction(); int n=qu.executeUpdate(); tx.commit(); status =
			 * true;
			 * 
			 * } if (pass != null || pass.length() > 0) { Query qu=session.
			 * createQuery("update UserModel SET password=:p1 WHERE customerID=:p2");
			 * qu.setParameter("p1",pass); qu.setParameter("p2",cid); tx =
			 * session.beginTransaction(); int n=qu.executeUpdate(); tx.commit(); status =
			 * true;
			 * 
			 * } if (occu != null || occu.length() > 0) { Query qu=session.
			 * createQuery("update UserModel SET occupation=:p1 WHERE customerID=:p2");
			 * qu.setParameter("p1",occu); qu.setParameter("p2",cid); tx =
			 * session.beginTransaction(); int n=qu.executeUpdate(); tx.commit(); status =
			 * true;
			 * 
			 * }
			 */
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return um;
	}
}