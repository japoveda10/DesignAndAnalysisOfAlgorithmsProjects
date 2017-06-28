import java.util.Iterator;

import iterators.RecurrenceEquationIteratorExample5;

/**
 * Main class of part 1 of Activity of the course Design and Analysis of Algorithms
 * @author David Cortes and Julio Poveda
 */
public class LinearSearchWithCertaintyMain 
{
	/**
	 * Main method
	 * @param args Arguments of the program
	 */
	public static void main(String [] args)
	{		
		//----------------------------------------------------------
		// Activity Part 1
		//----------------------------------------------------------
		System.out.println("--------------------------------------");
		System.out.println("Activity Part 1");
		System.out.println("--------------------------------------");
		
		//User enters number
		String numberForPredicate = args[0];
		int numForPredicate = Integer.parseInt(numberForPredicate);
		
		//Class that implements Predicate interface
		Algorithm algorithm = new Algorithm();
		
		algorithm.setNumber(numForPredicate);
		
		//Prime numbers iterator
		RecurrenceEquationIteratorExample5 it = new RecurrenceEquationIteratorExample5();
		
		Object ob = 0;
		
		for(int i = 0; !algorithm.truePredicate(ob); i++)
		{
			Object o = it.next();
			ob = o;
		}
		
		System.out.println("The object that fulfills the predicate is " + ob.toString());
	}	
}
