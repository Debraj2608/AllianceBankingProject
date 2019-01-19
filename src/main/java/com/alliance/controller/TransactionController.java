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

import com.alliance.bo.CheckAccountValidityBO;
import com.alliance.bo.CheckDebitAccountBalanceBO;
import com.alliance.bo.TransactionBO;
import com.alliance.dao.GetAccountDAO;
import com.alliance.model.AccountModel;
import com.alliance.model.TransactionModel;
import com.alliance.model.UserModel;
import com.alliance.util.AutogenTransaction;


/**
 * Servlet implementation class TransactionController
 */
public class TransactionController extends HttpServlet 
{
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
		RequestDispatcher view = null;
		HttpSession session = request.getSession(false);
		UserModel user = (UserModel) session.getAttribute("userRecord");

		String debitAccount = user.getAccountModel().getAccount_no();  
		//String debitAccount=getAccountDAO.getAccountNumber(user.getCustomerID());
		System.out.println(debitAccount);
		String creditAccount = request.getParameter("account_number");
		AccountModel accountCredit = new AccountModel();
		accountCredit.setAccount_no(creditAccount);
		
		double t_amount = Double.parseDouble(request.getParameter("t_amount"));
		TransactionModel transactionModelDebit = new TransactionModel();
		TransactionModel transactionModelCredit = new TransactionModel();
		AutogenTransaction autoGenTransaction = new AutogenTransaction();
		
		//Validation for credit account number----------------------------------------------
		CheckAccountValidityBO checkValidityBO = new CheckAccountValidityBO();
		boolean creditAccountValidated = checkValidityBO.checkValidity(creditAccount);
		System.out.println(creditAccountValidated);
		//----------------------------------------------------------------------------------
		//Validation for account balance before making transaction--------------------------
		CheckDebitAccountBalanceBO checkBalanceBO = new CheckDebitAccountBalanceBO();
		String accountNumber = user.getAccountModel().getAccount_no();
		boolean checkDebitAccountBalance = checkBalanceBO.checkDebitAccountBalance(accountNumber, t_amount);
		//System.out.println(checkDebitAccountBalance);
		//----------------------------------------------------------------------------------
		if(creditAccountValidated == true && checkDebitAccountBalance == true)
		{
			List<String> as=autoGenTransaction.getTransactionID();
		
			//Debit Account	------------------------------------------------------------------
			//transactionModel.setAccountModel(acc_no);
			AccountModel accountDebit = new AccountModel();
			accountDebit.setAccount_no(debitAccount);
			transactionModelDebit.setTransaction_id(as.get(0));
			transactionModelDebit.setTransaction_date(new Date());
			transactionModelDebit.setTransaction_amount(t_amount);
			transactionModelDebit.setTransaction_type("debit");
			//---------------------------------------------------------------------------------
			
			//Credit Account-------------------------------------------------------------------
			//transactionModel1.setAccountModel(account1);
		
			transactionModelCredit.setTransaction_id(as.get(1));
			transactionModelCredit.setTransaction_date(new Date());
			transactionModelCredit.setTransaction_amount(t_amount);
			transactionModelCredit.setTransaction_type("credit");
			//----------------------------------------------------------------------------------
			TransactionBO transactionBO = new TransactionBO();
			boolean status = transactionBO.doTransaction(transactionModelDebit,transactionModelCredit, creditAccount, debitAccount);	
			if(status)
			{
				view = request.getRequestDispatcher("views/success.jsp");
			}
			else
			{
				view = request.getRequestDispatcher("views/error.jsp");
			}
		}
		else
		{
			view = request.getRequestDispatcher("views/error.jsp");
		}
		view.forward(request, response);
	}
}