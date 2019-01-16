package com.alliance.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alliance.bo.AdminLinkBO;
import com.alliance.model.AccountModel;
import com.alliance.model.UserModel;
import com.alliance.util.AutoGenAccno;
import com.alliance.util.SendMail;

/**
 * Servlet implementation class AdminLinkController
 */
public class AdminLinkController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLinkController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminLinkBO adminLinkBO=new AdminLinkBO();
		AccountModel accountModel=new AccountModel();
		UserModel userModel = new UserModel();
		AutoGenAccno autoGenAccountNo=new AutoGenAccno();
		userModel.setCustomerID(request.getParameter("module"));
		accountModel.setAccount_no(autoGenAccountNo.getAccountNumber());
		Boolean status=adminLinkBO.insertDetails(accountModel,userModel);
		RequestDispatcher rs=null;
		String ys="This user is Linked";
		String no="Unable to link this User";
		if(status)
		{
			 rs= request.getRequestDispatcher("views/AccountApproved.jsp");
			 request.setAttribute("msg",ys);
		}
		else
		{
			 rs= request.getRequestDispatcher("views/AccountNotApproved.jsp");
			 request.setAttribute("msg",no);
		}
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