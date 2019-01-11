package com.alliance.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alliance.bo.AdminDispBO;
import com.alliance.model.UserModel;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
/**
 * Servlet implementation class AdminDispController
 */
public class AdminDispController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDispController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		AdminDispBO ab=new AdminDispBO();
		
		List<UserModel> as=new ArrayList<UserModel>();
		
		as=ab.returnUnapproved();
		
		
		RequestDispatcher rs=request.getRequestDispatcher("views/adminUnapproved.jsp");
		request.setAttribute("Userdetails",as);
		rs.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

