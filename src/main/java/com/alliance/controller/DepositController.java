package com.alliance.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alliance.bo.DepositBO;
import com.alliance.model.UserModel;

/**
 * Servlet implementation class DepositController
 */
public class DepositController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepositController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		DepositBO depositBO = new DepositBO();
		HttpSession session = request.getSession();
		UserModel user = (UserModel) session.getAttribute("userRecord");
		String amt = request.getParameter("deposit_amount");
		double amount = Double.parseDouble(amt);
		boolean status = depositBO.deposited(user,amount);
		RequestDispatcher view = null;
		if(status)
		{
			String success = "Your amount has been successfully deposited.";
			request.setAttribute("message", success);
			view = request.getRequestDispatcher("views/userSuccess.jsp");
		}
		else
		{
			String error = "Your request is not successful. Please try after some time.";
			request.setAttribute("message", error);
			view = request.getRequestDispatcher("views/userError.jsp");
		}
		view.forward(request, response);
	}
}