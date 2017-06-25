import java.util.Iterator;

import RecurrenceEquationsExampleIteratorsProject.RecurrenceEquationExampleIterator5;
import Matrix.MatrixIterator1;
import Matrix.MatrixIterator2;


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
	
		RecurrenceEquationExampleIterator5 it = new RecurrenceEquationExampleIterator5();
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
		
		if(iteratorClassName.equals("Matrix.MatrixIterator1"))
		{
			//Iterator is MatrixIterator1
			it2 = new MatrixIterator1(matrix);
			
			
			for(int i = 0; i<=matrix.length*matrix[0].length+2; i++)
			{
				Object o = it2.next();
				System.out.println(o.toString());
			}
		}
		else if(iteratorClassName.equals("Matrix.MatrixIterator2"))
		{
			//Iterator is MatrixIterator2
			it2 = new MatrixIterator2(matrix);
			
			for(int i = 0; i<=matrix.length*matrix[0].length+2; i++)
			{
				Object o = it2.next();
				System.out.println(o.toString());
			}
		}
				
		//Visit the elements of the matrix in the main diagonal
		for(int i = 0; i<matrix[0].length && i<matrix.length;i++)
		{
			System.out.println(matrix[i][i]);
		}
	}

}
