package com.alliance.util;

import com.alliance.dao.AutoDAO;

public class AutoGenerateCustomerID {

	public String generateCustId() {
		String custID = "";
		String numeric = "";
		String num1 = "";
		String alpha = "";

		AutoDAO ud = new AutoDAO();
		String last = ud.getLastId();
		
		if (last.isEmpty() == false) 
		{
			alpha = alpha + last.charAt(0);
			for (int i = 1; i < last.length(); i++) 
			{
				numeric = numeric + last.charAt(i);
			}
			int num = Integer.parseInt(numeric);
			num = num + 1;
			// System.out.println(num);
			if (num < 10) {
				char c = '0';
				alpha = alpha + c + c;
				num1 = num1.valueOf(num);
				alpha = alpha + num1;
			} 
			else if (num < 100) 
			{
				char c = '0';
				alpha = alpha + c;
				num1 = num1.valueOf(num);
				alpha = alpha + num1;

			} 
			else if (num < 1000) 
			{

				num1 = num1.valueOf(num);
				alpha = alpha + num1;

			} 
			else 
			{
				num1 = num1.valueOf(num);
				alpha = alpha + num1;
			}
		}
		else 
		{
			alpha = "C001";
		}
		return alpha;
	}
}