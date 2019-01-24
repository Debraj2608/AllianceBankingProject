package com.alliance.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alliance.bo.CityDropdownBO;
import com.alliance.model.BranchModel;

/**
 * Servlet implementation class RegisterRedirectController
 */
public class RegisterRedirectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterRedirectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		CityDropdownBO cityDropdownBO = new CityDropdownBO();
		List<BranchModel> cityList = cityDropdownBO.getCityList();
		request.setAttribute("cityList", cityList);
		RequestDispatcher view = request.getRequestDispatcher("views/register.jsp");
		view.forward(request, response);
	}
}
