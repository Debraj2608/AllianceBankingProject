package com.alliance.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alliance.bo.AddBranchCodeBO;
import com.alliance.model.BranchModel;
import com.alliance.util.AutoGenBranchCode;

/**
 * Servlet implementation class GenerateBranchCodeController
 */
public class GenerateBranchCodeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateBranchCodeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		String city = request.getParameter("city");
		BranchModel branchModel = new BranchModel();
		branchModel.setCity(city);
		AutoGenBranchCode autoGenBranchCode = new AutoGenBranchCode();
		String branchCode = autoGenBranchCode.getGeneratedBranchCode();
		branchModel.setBranchCode(branchCode);
		AddBranchCodeBO addBranchCodeBO = new AddBranchCodeBO();
		BranchModel details = addBranchCodeBO.addBranch(branchModel);
		RequestDispatcher view = null;
		if(details == null)
		{
			String message = "The branch could not be added.";
			request.setAttribute("message", message);		
			view = request.getRequestDispatcher("views/adminerror.jsp");
		}
		else
		{
			request.setAttribute("message", details);
			view = request.getRequestDispatcher("views/admincityadded.jsp");
		}
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
