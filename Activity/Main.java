import java.util.Iterator;

import RecurrenceEquationsExampleIteratorsProject.RecurrenceEquationExampleIterator1;
import RecurrenceEquationsExampleIteratorsProject.RecurrenceEquationExampleIterator2;
import RecurrenceEquationsExampleIteratorsProject.RecurrenceEquationExampleIterator3;
import RecurrenceEquationsExampleIteratorsProject.RecurrenceEquationExampleIterator4;
import RecurrenceEquationsExampleIteratorsProject.RecurrenceEquationExampleIterator5;
import RecurrenceEquationsExampleIteratorsProject.SquareNumbersIterator;

/**
 * Activity of the course Design and Analysis of Algorithms
 * @author David Cortés and Julio Poveda
 */
public class Main 
{
	
	public static void main(String [] args) throws Exception
	{
		
		//----------------------------------------------------------
		// Activity
		//----------------------------------------------------------
		System.out.println("--------------------------------------");
		System.out.println("Activity");
		System.out.println("--------------------------------------");
		
		Algorithm algorithm = new Algorithm();
	
		RecurrenceEquationExampleIterator5 it = new RecurrenceEquationExampleIterator5();
		Object ob = 0;
		
		for(int i = 0; !algorithm.truePredicate(i); i++)
		{
			Object o = it.next();
			ob = o;
			System.out.println(o.toString());
		}
		
		System.out.println("");
		System.out.println("El objeto que cumple el predicado es " + ob.toString());
	}

}
