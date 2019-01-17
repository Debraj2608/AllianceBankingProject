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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		UserModel user = (UserModel) session.getAttribute("userRecord");
		GetAccountDAO getAccountDAO= new GetAccountDAO();
		String debitAccount = user.getAccountModel().getAccount_no();  
		//String debitAccount=getAccountDAO.getAccountNumber(custID);
		
		String creditAccount=request.getParameter("account_number");
		AccountModel accountCredit=new AccountModel();
		accountCredit.setAccount_no(creditAccount);
		double t_amount=Double.parseDouble(request.getParameter("t_amount"));
		TransactionModel transactionModelDebit= new TransactionModel();
		TransactionModel transactionModelCredit= new TransactionModel();
		AutogenTransaction autoGenTransaction=new AutogenTransaction();
		
		List<String> as=autoGenTransaction.getTransactionID();
		AccountModel accountDebit = new AccountModel();
		//for from-----------------------------------------------------------
		//transactionModel.setAccountModel(acc_no);
 
		transactionModelDebit.setTransaction_id(as.get(0));
		transactionModelDebit.setTransaction_date(new Date());
		transactionModelDebit.setTransaction_amount(t_amount);
		transactionModelDebit.setTransaction_type("Withdrawal");
		//-------------------------------------------------------------------
		
		//for to-------------------------------------------------------------
		//transactionModel1.setAccountModel(account1);
		
		transactionModelCredit.setTransaction_id(as.get(1));
		transactionModelCredit.setTransaction_date(new Date());
		transactionModelCredit.setTransaction_amount(t_amount);
		transactionModelCredit.setTransaction_type("Deposit");
		TransactionBO tb= new TransactionBO();
		boolean status= tb.doTransaction(transactionModelDebit,transactionModelCredit, creditAccount, debitAccount);
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