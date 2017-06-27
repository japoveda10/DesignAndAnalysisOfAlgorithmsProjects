
import iterators.RecurrenceEquationIteratorExample5;


/**
 * Activity of the course Design and Analysis of Algorithms
 * @author David Cortés and Julio Poveda
 */
public class LinearSearchWithCertaintyExample 
{
	public static void main(String [] args) throws Exception
	{
		
		//----------------------------------------------------------
		// Activity
		//----------------------------------------------------------
		System.out.println("--------------------------------------");
		System.out.println("Activity Part 1");
		System.out.println("--------------------------------------");
		
		Algorithm algorithm = new Algorithm();
	
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
