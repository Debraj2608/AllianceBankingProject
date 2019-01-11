package com.alliance.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alliance.bo.Register1BO;
import com.alliance.model.UserModel;
import com.alliance.util.AutoGenerateCustomerID;

/**
 * Servlet implementation class RegisterController
 */
public class Register1Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register1Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Register1BO register1BO = new Register1BO();
		UserModel userModel = new UserModel();
		RequestDispatcher view = null;
		AutoGenerateCustomerID autoGenCID = new AutoGenerateCustomerID();
		String fname = request.getParameter("firstname");
		String mname = request.getParameter("middlename");
		String lname = request.getParameter("lastname");
		String dateOfBirth = request.getParameter("dob");
		String email = request.getParameter("email");
		String contactNo = request.getParameter("cno");
		String city = request.getParameter("city");
		String occupation = request.getParameter("occupation");
		String password = request.getParameter("password1");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try 
		{
			 date = sdf.parse(dateOfBirth);
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		
		String customerID = autoGenCID.generateCustId();
		userModel.setFirstName(fname);
		userModel.setMiddleName(mname);
		userModel.setLastName(lname);
		userModel.setDob(date);
		userModel.setEmail(email);
		userModel.setContactNumber(contactNo);
		userModel.setCity(city);
		userModel.setOccupation(occupation);
		userModel.setPassword(password);
		userModel.setCustomerID(customerID);
		HttpSession session = request.getSession();
		session.setAttribute("userModel", userModel);
		boolean status = register1BO.register1validate(userModel);
		if(status)
		{
			view = request.getRequestDispatcher("views/userDetailsPage.jsp");
		}
		else
		{
			view = request.getRequestDispatcher("views/index.jsp");
		}
		view.forward(request, response);
	}
}