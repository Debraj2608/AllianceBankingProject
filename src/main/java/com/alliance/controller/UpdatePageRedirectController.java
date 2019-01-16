package com.alliance.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alliance.bo.ProfileUpdateBO;
import com.alliance.bo.UpdatePageRedirectBO;
import com.alliance.model.UserModel;

/**
 * Servlet implementation class UpdatePageRedirectController
 */
public class UpdatePageRedirectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdatePageRedirectController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		UserModel um = new UserModel();
		HttpSession session=request.getSession();
		UserModel u1 = (UserModel) session.getAttribute("userRecord");
		String customerID=u1.getCustomerID();		
		UpdatePageRedirectBO uprbo=new UpdatePageRedirectBO();
		um=uprbo.initialize(customerID);
		request.setAttribute("user",um);
		rd=request.getRequestDispatcher("views/profileupdate.jsp");
		rd.forward(request, response);
	}
}
