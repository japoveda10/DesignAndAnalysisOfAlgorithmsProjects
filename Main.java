import java.util.Iterator;

import IsPrimeProject.IsPrime;
import RecurrenceEquationsExampleIteratorsProject.RecurrenceEquationExampleIterator1;
import RecurrenceEquationsExampleIteratorsProject.RecurrenceEquationExampleIterator2;
import RecurrenceEquationsExampleIteratorsProject.SquareNumbersIterator;

/**
 * Main class of the Design and Analysis of Algorithms Projects
 * @author Julio Poveda
 */
public class Main 
{
	
	public static void main(String [] args)
	{
		
		//----------------------------------------------------------
		// Is prime program
		//----------------------------------------------------------
		System.out.println("--------------------------------------");
		System.out.println("Is prime program");
		System.out.println("--------------------------------------");
		IsPrime program1 = new IsPrime(5);
		
		System.out.println("");
		//----------------------------------------------------------
		// Example iterator program
		//----------------------------------------------------------
		System.out.println("--------------------------------------");
		System.out.println("Example iterator program");
		System.out.println("--------------------------------------");
		//Iterator it = new SquareNumbersIterator();
		//Iterator it = new RecurrenceEquationExampleIterator1();
		Iterator it = new RecurrenceEquationExampleIterator2();
		
		int n = 4;
				
		for(int i = 0; i<n && it.hasNext() ; i++)
		{
			Object o = it.next();
			System.out.println(o.toString());
		}
	}

}
