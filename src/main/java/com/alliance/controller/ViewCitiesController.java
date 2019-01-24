package com.alliance.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alliance.bo.ViewCitiesBO;
import com.alliance.model.BranchModel;

/**
 * Servlet implementation class ViewCitiesController
 */
public class ViewCitiesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCitiesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BranchModel branchModel = new BranchModel();
		ViewCitiesBO viewCitiesBO = new ViewCitiesBO();
		HttpSession session = request.getSession();
		List<BranchModel> list = viewCitiesBO.branchModelList();
		RequestDispatcher view = null;
		if(list==null)
		{
			String message = "An error occured. Please try later.";
			request.setAttribute("message", message);
			view = request.getRequestDispatcher("views/adminerror.jsp");
		}
		else
		{
			request.setAttribute("list", list);
			view = request.getRequestDispatcher("views/branchlist.jsp");
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
