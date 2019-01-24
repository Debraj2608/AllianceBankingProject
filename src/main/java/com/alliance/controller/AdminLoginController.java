package com.alliance.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alliance.bo.AdminLoginBO;
import com.alliance.model.AdminModel;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLoginCntroller
 */
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean status=false;
		String Adminid=request.getParameter("username");
		String Password=request.getParameter("password");
		
		AdminModel am= new AdminModel();
		AdminLoginBO alb=new AdminLoginBO();
		
		am.setAdminID(Adminid);
		am.setPassword(Password);
		
		status=alb.validateAdmin(am);
		
		if(status)
		{
			HttpSession session = request.getSession();
			session.setAttribute("admin", am);
			RequestDispatcher rs= request.getRequestDispatcher("views/admin.jsp");
			rs.forward(request, response);
		}
		else
		{
			RequestDispatcher rs= request.getRequestDispatcher("views/adminLogin.jsp");
			rs.forward(request, response);
		}	
	}
}