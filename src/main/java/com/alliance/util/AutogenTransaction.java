package com.alliance.util;

import java.util.*;
import com.alliance.dao.GenerateTidDAO;

public class AutogenTransaction 
{
	public List<String> getTransactionID()
	{
		List<String> as= new ArrayList<String>();
		
		GenerateTidDAO gtd= new GenerateTidDAO();
		
		String numeric="";
		String num1="";
		String alpha="";
		String alpha2="";
		String num3="";
		String last=gtd.getLastID();
		
		if(last.isEmpty()==false)
		{
			 alpha=alpha+last.charAt(0);
			 alpha2=alpha+last.charAt(0);
			 for(int i=1; i<last.length();i++)
				{
					
					 numeric=numeric+last.charAt(i);
				}
			int num=Integer.parseInt(numeric);
			num=num+1;
			int num2=num+2;
			//System.out.println(num);
			if(num<10)
			{
				char c='0';
				alpha=alpha+c+c;
				alpha2=alpha2+c+c;
				 num1=num1.valueOf(num);
				 num3=num3.valueOf(num2);
				 alpha=alpha+num1;
				alpha2=alpha2+num3;
			}
			else if(num<100)
			{
				char c='0';
				alpha=alpha+c;
				alpha2=alpha2+c;
				 num1=num1.valueOf(num);
				 num3=num3.valueOf(num2);
				alpha=alpha+num1;
				alpha2=alpha2+num3;
			}
			else if(num<1000)
			{
				
				 num1=num1.valueOf(num);
				 num3=num3.valueOf(num2);
				alpha=alpha+num1;
				alpha2=alpha2+num3;		
			}
			else
			{
				 num1=num1.valueOf(num);
				 num3=num3.valueOf(num2);
				 alpha2=alpha2+num3;
					alpha=alpha+num1;
			}
				
		}
		else
		{
			alpha="T001";
		}
		as.add(alpha);
		as.add(alpha2);
		return as;
	}
}