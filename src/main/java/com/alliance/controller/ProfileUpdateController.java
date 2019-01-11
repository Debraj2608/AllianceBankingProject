package com.alliance.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alliance.bo.ProfileUpdateBO;
import com.alliance.model.UserModel;

public class ProfileUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProfileUpdateController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		ProfileUpdateBO pubo = new ProfileUpdateBO();
		UserModel um = new UserModel();
		HttpSession session=request.getSession();
		String userid=(String) session.getAttribute("userID");
		String passold=(String) session.getAttribute("password");
		String cno = request.getParameter("cno");
		String city = request.getParameter("city");
		String occu = request.getParameter("occupation");
		String passnew = request.getParameter("password1");
		um.setCity(city);
		um.setContactNumber(cno);
		um.setOccupation(occu);
		um.setPassword(passnew);
		um.setCustomerID(userid);
		boolean b=pubo.update(um);
		if(b) {
			rd=request.getRequestDispatcher("views/success.jsp");
		}
		else {
			rd=request.getRequestDispatcher("views/error.jsp");
		}
	}

}
