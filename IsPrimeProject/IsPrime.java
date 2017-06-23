package IsPrimeProject;

/**
 * Class that determines if a number is prime
 * @author Julio Poveda
 */
public class IsPrime 
{
	public IsPrime(int pNumber)
	{
		if(pNumber % 2 >0)
		{
			System.out.println(pNumber + " " + "is prime");
		}
		else
		{
			System.out.println(pNumber + " " + " is not prime");
		}
	}

}
