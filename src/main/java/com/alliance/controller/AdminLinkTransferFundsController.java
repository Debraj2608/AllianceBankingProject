package com.alliance.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alliance.bo.AdminLinkTransferFundsBO;

/**
 * Servlet implementation class AdminLinkTransferFundsController
 */
public class AdminLinkTransferFundsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLinkTransferFundsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		AdminLinkTransferFundsBO adLinkTrFundsBO = new AdminLinkTransferFundsBO();
		String customerID = request.getParameter("module");
		boolean status = adLinkTrFundsBO.activate(customerID);
		RequestDispatcher view = null;
		if(status)
		{
			view = request.getRequestDispatcher("views/success.jsp");
		}
		else
		{
			view = request.getRequestDispatcher("views/error.jsp");
		}
		view.forward(request, response);
	}
}