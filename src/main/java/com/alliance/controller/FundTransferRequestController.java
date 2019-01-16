package com.alliance.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alliance.bo.FundTransferRequestBO;
import com.alliance.model.FundTransferRequestModel;
import com.alliance.model.UserModel;

/**
 * Servlet implementation class FundTransferRequestController
 */
public class FundTransferRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FundTransferRequestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserModel user = (UserModel) session.getAttribute("userRecord");
		String customerID = user.getCustomerID();
		FundTransferRequestBO fTrReqBO = new FundTransferRequestBO();
		Date d = new Date();
		FundTransferRequestModel fTrRequestModel = new FundTransferRequestModel();
		fTrRequestModel.setUserModel(user);
		fTrRequestModel.setRequestTime(d);
		boolean status = fTrReqBO.requestSent(fTrRequestModel);
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