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
		
		System.out.println("");
		System.out.println("Parte 1");
		System.out.println("");
		
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
		
		System.out.println("");
		System.out.println("Parte 2");
		System.out.println("");
		
		//A 4x4 matrix of objects is created
		Object[][] matrix = new Object [4][4];
		
		//Objects are put in the matrix
		for(int i = 0; i<matrix.length; i++)
		{
			for(int j=0; j<matrix[0].length; j++)
			{
				matrix[i][j] = i;
			}
		}
		
		//Creation of the matrix iterator
		MatrixIterator it2 = new MatrixIterator(matrix);
		
		for(int i = 0; i<=matrix.length*matrix[0].length+2; i++)
		{
			Object o = it2.next();
			System.out.println(o.toString());
		}
		
	}

}
