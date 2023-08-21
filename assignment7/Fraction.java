package assignment7;

public class Fraction 
{
	//Initialize variables
	private int numerator;
	private int denominator;
	private static int count;
	
	//Overloaded Fraction Constructor
	public Fraction(int n, int d) throws FractionException
	{
		try
		{
			setNumerator(n);
			setDenominator(d);
			simplify();
			count++;
		}
		catch(FractionException e)
		{
			throw new FractionException(e.getMessage());
		}
	}
	
	//Copy Contructor
	public Fraction(Fraction x) throws FractionException
	{
		try
		{
			setNumerator(x.getNumerator());
			setDenominator(x.getDenominator());
			simplify();
			count++;
		}
		catch(FractionException e)
		{
			throw new FractionException(e.getMessage());
		}
	}
	
	//Get Numerator
	public int getNumerator()
	{
		return numerator;
	}
	
	//Set Numerator
	public void setNumerator(int n)
	{
		numerator = n;
	}
	
	//Get Denominator
	public int getDenominator()
	{
		return denominator;
	}
	
	//Set Denominator
	public void setDenominator(int d) throws FractionException
	{
		if(d != 0)
			denominator = d;
		else
			throw new FractionException("Error. Attempt to set denominator to 0.");
	}
	
	//Simplify fraction
	public void simplify()
	{
		int gcd = GCD(numerator, denominator);
		if(gcd != 1)
		{
			numerator = numerator / gcd;
			denominator = denominator/ gcd;
		}
	}
	
	//Greatest Common Divisor
	public int GCD(int n, int d)
	{
		if(d == 0)
		{
			if(numerator % n != 0 || denominator % n != 0)
				return 1;
			else
				return n;
		}
		else
		{
			int temp = n;
			n = d;
			d = temp % d;
			return GCD(n, d);
		}
	}
	
	//Change to opposite sign
	public void opposite()
	{
		numerator = numerator * -1;
	}
	
	//Swap numerator and denominator
	public void inverse() throws FractionException
	{
		int temp = numerator;
		try
		{
			setNumerator(denominator);
			setDenominator(temp);
		}
		catch(FractionException e)
		{
			throw new FractionException("Error when trying to set denominator to 0");
		}
	}
	
	//Add a fraction to this one
	public void add(Fraction f)
	{
		try
		{
			Fraction temp = new Fraction(numerator, denominator);
			setNumerator(numerator * f.getDenominator());
			setDenominator(denominator * f.getDenominator());
			temp.setNumerator(temp.getDenominator() * f.getNumerator());
			temp.setDenominator(temp.getDenominator() * f.getDenominator());
			
			
			setNumerator(numerator + temp.getNumerator());
			simplify();
		}
		catch(FractionException e)
		{
			System.out.println("FractionException: " + e.getMessage());
		}
		
	}
	
	//Add two fractions together
	public static Fraction add(Fraction x, Fraction y)
	{
		try
		{
			Fraction xCopy = new Fraction(x);
			Fraction yCopy = new Fraction(y);
			xCopy.add(yCopy);
			return xCopy;
		}
		catch(FractionException e)
		{
			System.out.println("FractionException: " + e.getMessage());
			return null;
		}
	}
	
	//Subtract a fraction from this one
	public void subtract(Fraction f)
	{
		try
		{
			Fraction temp = new Fraction(numerator, denominator);
			setNumerator(numerator * f.getDenominator());
			setDenominator(denominator * f.getDenominator());
			temp.setNumerator(temp.getDenominator() * f.getNumerator());
			temp.setDenominator(temp.getDenominator() * f.getDenominator());
			
			
			setNumerator(numerator - temp.getNumerator());
			simplify();
		}
		catch(FractionException e)
		{
			System.out.println("FractionException: " + e.getMessage());
		}
	}
	
	//Subtract two seperate fractions
	public static Fraction subtract(Fraction x, Fraction y)
	{
		try
		{
			Fraction xCopy = new Fraction(x);
			Fraction yCopy = new Fraction(y);
			xCopy.subtract(yCopy);
			return xCopy;
		}
		catch(FractionException e)
		{
			System.out.println("FractionException: " + e.getMessage());
			return null;
		}
	}
	
	//Multiply one fraction to this one
	public void multiply(Fraction f)
	{
		try
		{
			setNumerator(numerator * f.getNumerator());
			setDenominator(denominator * f.getDenominator());
			simplify();
		}
		catch(FractionException e)
		{
			System.out.println("FractionException: " + e.getMessage());
		}
	}
	
	//Multiply two fractions to one another
	public static Fraction multiply(Fraction x, Fraction y)
	{
		try
		{
			Fraction ans = new Fraction(1, 1);
			ans.setNumerator(x.numerator * y.getNumerator());
			ans.setDenominator(x.denominator * y.getDenominator());
			ans.simplify();
			return ans;
		}
		catch(FractionException e)
		{
			System.out.println("FractionException: " + e.getMessage());
			return null;
		}
	}
	
	//Divide one fraction from this one
	public void devide(Fraction f)
	{
		try
		{
			setNumerator(numerator * f.getDenominator());
			setDenominator(denominator * f.getNumerator());
			simplify();
		}
		catch(FractionException e)
		{
			System.out.println("FractionException: " + e.getMessage());
		}
	}
	
	//Divide two fractions form one another
	public static Fraction devide(Fraction x, Fraction y)
	{
		try
		{
			Fraction ans = new Fraction(1, 1);
			ans.setNumerator(x.numerator * y.getDenominator());
			ans.setDenominator(x.denominator * y.getNumerator());
			ans.simplify();
			return ans;
		}
		catch(FractionException e)
		{
			System.out.println("FractionException: " + e.getMessage());
			return null;
		}
	}
	
	//Change fraction to double value
	public double toDouble()
	{
		double temp = numerator * 1.0;
		return (temp / denominator);
	}
	
	//Change fraction to Integer value
	public int toInt()
	{
		return (numerator / denominator);
	}
	
	//Change fraction to percent value
	public double toPercent()
	{
		return toDouble() * 100;
	}
	
	//Change fraction to mixed value
	public String toMixed()
	{
		int r = numerator % denominator;
		if((numerator >= 0 && denominator >= 0) || (numerator < 0 && denominator < 0))
			return "[ + " + Math.abs(numerator / denominator) + " " + r + " / " + Math.abs(denominator) + "]";
		else
			return "[ - " + Math.abs(numerator / denominator) + " " + r + " / " + Math.abs(denominator) + "]";
	}
	
	//Get current count of objects
	public int getCount()
	{
		return count;
	}
	
	//Return string representation of Fraction
	public String toString()
	{
		if((numerator >= 0 && denominator >= 0) || (numerator < 0 && denominator < 0))
			return "[ + " + Math.abs(numerator) + " / " + Math.abs(denominator) + "]";
		else
			return "[ - " + Math.abs(numerator) + " / " + Math.abs(denominator) + "]";
	}
	
	//Clone this object
	public Object clone()
	{
		try
		{
			return super.clone();
		}
		catch(Exception e)
		{
			return this;
		}
	}
	
	//Release resources
	protected void finalize()
	{
		count--;
	}
}
