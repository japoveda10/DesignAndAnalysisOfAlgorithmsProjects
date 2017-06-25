

import java.util.Scanner;

/**
 * Main class of the project that determines if a number is prime
 * @author Julio Poveda
 */
public class Main 
{
	public static void main(String[] args)
	{
		
		System.out.println("--------------------------------");
		System.out.println("Is prime project");
		System.out.println("--------------------------------");
		
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Hi, please enter a number to determine if it is prime or not");
		
		int pNumber = reader.nextInt();
		
		if(pNumber % 2 >0)
		{
			System.out.println(pNumber + " " + "is prime");
		}
		else
		{
			System.out.println(pNumber + " " + " is not prime");
		}
		
		reader.close();
	}
}
