package com.alliance.util;

import com.alliance.dao.AutoGenBranchCodeDAO;


public class AutoGenBranchCode
{
	public String getGeneratedBranchCode()
	{
		
		String numeric="";
		String num1="";
		String alpha="";
		
		AutoGenBranchCodeDAO autoGenBranchCodeDAO = new AutoGenBranchCodeDAO();
		String last=autoGenBranchCodeDAO.getLastId();
		
		if(last.isEmpty()==false)
		{
			 alpha=alpha+last.charAt(0);
			for(int i=1; i<last.length();i++)
				{
					
					 numeric=numeric+last.charAt(i);
						 
				
				
				
			}
			int num=Integer.parseInt(numeric);
			num=num+1;
			//System.out.println(num);
			if(num<10)
			{
				char c='0';
				alpha=alpha+c+c;
				 num1=num1.valueOf(num);
				alpha=alpha+num1;
				
			}
			else if(num<100)
			{
				char c='0';
				alpha=alpha+c;
				 num1=num1.valueOf(num);
				alpha=alpha+num1;
				
			}
			else if(num<1000)
			{
				
				 num1=num1.valueOf(num);
				alpha=alpha+num1;
				
			}
			else
			{
				 num1=num1.valueOf(num);
					alpha=alpha+num1;
			}
				
		}
		else
		{
			alpha="B001";
		}
		return alpha;
		
	}
}
