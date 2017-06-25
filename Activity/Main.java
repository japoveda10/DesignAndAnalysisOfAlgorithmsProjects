import java.util.Iterator;

import iterators.RecurrenceEquationIteratorExample5;
import matrix.MatrixIterator1;
import matrix.MatrixIterator2;

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
		System.out.println("Part 1");
		System.out.println("");
		
		Algorithm algorithm = new Algorithm();
	
		RecurrenceEquationIteratorExample5 it = new RecurrenceEquationIteratorExample5();
		Object ob = 0;
		
		for(int i = 0; !algorithm.truePredicate(i); i++)
		{
			Object o = it.next();
			ob = o;
			System.out.println(o.toString());
		}
		
		System.out.println("");
		System.out.println("The object that fulfills the predicate is " + ob.toString());
		
		System.out.println("");
		System.out.println("Part 2");
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
				
		//args[0] has iterator name
		String iteratorClassName = args[0];
		
		Iterator it2;
		
		if(iteratorClassName.equals("matrix.MatrixIterator1"))
		{
			//Iterator is MatrixIterator1
			it2 = new MatrixIterator1(matrix);
			
			System.out.println("This matrix iterator goes through each element of the matrix by rows:");
			System.out.println("");
			
			for(int i = 0; i<=matrix.length*matrix[0].length+2; i++)
			{
				Object o = it2.next();
				System.out.println(o.toString());
			}
		}
		else if(iteratorClassName.equals("matrix.MatrixIterator2"))
		{
			//Iterator is MatrixIterator2
			it2 = new MatrixIterator2(matrix);
			
			System.out.println("This matrix iterator goes through each element of the matrix by columns:");
			System.out.println("");
			
			for(int i = 0; i<=matrix.length*matrix[0].length+2; i++)
			{
				Object o = it2.next();
				System.out.println(o.toString());
			}
		}
		
		System.out.println("");
		System.out.println("This is the main diagonal of the matrix: ");
		System.out.println("");
		
		//Visit the elements of the matrix in the main diagonal
		for(int i = 0; i<matrix[0].length && i<matrix.length;i++)
		{
			System.out.println(matrix[i][i]);
		}
	}
}
