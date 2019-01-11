package com.alliance.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alliance.bo.LoginBO;
import com.alliance.model.UserModel;

/**
 * Servlet implementation class RegLogController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginBO loginBO = new LoginBO();
		UserModel loginModel = new UserModel();
		RequestDispatcher view = null;
		String userID = request.getParameter("username");
		String password = request.getParameter("password");
		loginModel.setCustomerID(userID);
		loginModel.setPassword(password);
		boolean validate = false;
		try {
			validate = loginBO.validate(loginModel);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(validate)
		{
			view = request.getRequestDispatcher("views/profile.jsp");
		}
		else
		{
			view = request.getRequestDispatcher("views/login.jsp");
		}
		view.forward(request, response);
	}
}