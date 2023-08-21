package assignment7;

public class FractionException extends Exception
{
	//Initialize Variable
	private String msg;
	
	//Overloaded Constructor
	public FractionException(String m)
	{
		msg = m;
	}
	
	//Get Message
	public String getMessage()
	{
		return msg;
	}
	
	//Set the message
	public void setMessage(String m)
	{
		msg = m;
	}
}
