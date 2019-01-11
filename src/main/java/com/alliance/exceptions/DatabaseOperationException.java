package com.alliance.exceptions;


public class DatabaseOperationException extends Exception
{
public DatabaseOperationException(String arg0,Throwable arg1)
{
	super(arg0,arg1);
}
public DatabaseOperationException(String arg0)
{
	super(arg0);
}
public DatabaseOperationException(Throwable arg1)
{
	super(arg1);
}
}
