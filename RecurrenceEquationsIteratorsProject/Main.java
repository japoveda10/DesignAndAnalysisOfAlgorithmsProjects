

import iterators.RecurrenceEquationIteratorExample1;
import iterators.RecurrenceEquationIteratorExample2;
import iterators.RecurrenceEquationIteratorExample3;
import iterators.RecurrenceEquationIteratorExample4;
import iterators.RecurrenceEquationIteratorExample5;
import iterators.SquareNumbersIterator;


import java.util.Iterator; 

/**
 * Main class of the project that has some recurrence equations iterators
 * @author David Cortés and Julio Poveda
 */
public class Main 
{
	public static void main(String[] args) throws Exception
	{
		
		System.out.println("----------------------------------------------");
		System.out.println("Recurrence equations example iterators project");
		System.out.println("----------------------------------------------");
		
		//args[0] has iterator name
		String iteratorClassName = args[0];
		
		//The iterator is created
		Iterator it = (Iterator)Class.forName(iteratorClassName).newInstance();
		
		//args[1] has number of elements to iterate
		int n = Integer.parseInt(args[1]);
		
		for(int i = 0; i<n && it.hasNext() ; i++)
		{
			Object o = it.next();
			System.out.println(o.toString());
		}
	}
}
