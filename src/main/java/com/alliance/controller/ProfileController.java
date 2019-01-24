package com.alliance.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alliance.model.AdminModel;
import com.alliance.model.UserModel;

/**
 * Servlet implementation class ProfileController
 */
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProfileController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = null;
		HttpSession session = request.getSession(false);
		UserModel um = null;
		AdminModel am = null;
		um = (UserModel) session.getAttribute("userRecord");
		am = (AdminModel) session.getAttribute("admin");
		if (um == null) {
			if (am == null) {
				view = request.getRequestDispatcher("views/index.jsp");
			} else {
				view = request.getRequestDispatcher("views/admin.jsp");
			}
		} else {
			view = request.getRequestDispatcher("views/profile.jsp");
		}
		view.forward(request, response);
	}

}
