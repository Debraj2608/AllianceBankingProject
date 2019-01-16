package com.alliance.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alliance.bo.TransactionBO;
import com.alliance.dao.GetAccountDAO;
import com.alliance.model.AccountModel;
import com.alliance.model.TransactionModel;
import com.alliance.model.UserModel;
import com.alliance.util.AutogenTransaction;


/**
 * Servlet implementation class TransactionController
 */
public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionController() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		UserModel user = (UserModel) session.getAttribute("userRecord");
		GetAccountDAO getAccountDAO= new GetAccountDAO();
		String custID = user.getAccountModel().getAccount_no();
		AccountModel acc_no=getAccountDAO.getAccountNumber(custID);
		
		String account=request.getParameter("account_number");
		AccountModel account1=new AccountModel();
		account1.setAccount_no(account);
		double t_amount=Double.parseDouble(request.getParameter("t_amount"));
		TransactionModel transactionModel= new TransactionModel();
		TransactionModel transactionModel1= new TransactionModel();
		AutogenTransaction autoGenTransaction=new AutogenTransaction();
		
		List<String> as=autoGenTransaction.getTransactionID();
		AccountModel accountModel = new AccountModel();
		//for from-------------------------------------------------------
		transactionModel.setAccountModel(acc_no);
		Date d= new Date();
		transactionModel.setTransaction_id(as.get(0));
		transactionModel.setTransaction_date(d);
		transactionModel.setTransaction_amount(t_amount);
		transactionModel.setTransaction_type("Withdrawal");
		//-----------------------------------------------------------------
		
		//for to----------------------------------------------------------
		transactionModel1.setAccountModel(account1);
		Date d1= new Date();
		transactionModel1.setTransaction_id(as.get(1));
		transactionModel1.setTransaction_date(d1);
		transactionModel1.setTransaction_amount(t_amount);
		transactionModel1.setTransaction_type("Deposit");
		TransactionBO tb= new TransactionBO();
		boolean status= tb.doTransaction(tm,transactionModel1, account);
		RequestDispatcher view = null;
		if(status)
		{
			view = request.getRequestDispatcher("views/success.jsp");
		}
		else
		{
			view = request.getRequestDispatcher("views/error.jsp");
		}
	}
}