package com.alliance.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alliance.bo.AdminFundTransferActivationBO;
import com.alliance.model.FundTransferRequestModel;

/**
 * Servlet implementation class AdminFundTransferActivationController
 */
public class AdminFundTransferActivationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminFundTransferActivationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher view = null;
		AdminFundTransferActivationBO adFTrActBO = new AdminFundTransferActivationBO();
		List<FundTransferRequestModel> listUnapproved = adFTrActBO.unapprovedList();
		//System.out.println(listUnapproved);
		request.setAttribute("UnApprovedTransferFunds", listUnapproved);
		view = request.getRequestDispatcher("views/AdminUnapprovedTransferFunds.jsp");	
		view.forward(request, response);
	}

}
