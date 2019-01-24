package com.alliance.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alliance.bo.SearchBO;
import com.alliance.model.UserModel;

/**
 * Servlet implementation class CustomerSearch
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    SearchBO sbo= new SearchBO();
	 String stype=request.getParameter("stype");
	 String user=request.getParameter("user");
	 RequestDispatcher view = null;	
	 
	 List<UserModel> lum= sbo.getUserList(stype,user);
	 if(lum.size()>0) {
		request.setAttribute("ulist", lum);
		request.setAttribute("stype", stype);
		view=request.getRequestDispatcher("views/searchdetails.jsp");
	 }
	 else {
		 view=request.getRequestDispatcher("views/error.jsp");
		
	 }
	 view.forward(request, response);
	 

	 
	}

}
