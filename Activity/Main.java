import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;

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
		
		//The information about the matrix is in a file called matrix.properties
		File file = new File("./data/matrix.properties");
		Properties data = new Properties();
		FileInputStream in = new FileInputStream(file);
		
		try
		{
			data.load(in);
			in.close();
		}
		catch(Exception e)
		{
			throw new Exception("Invalid format");
		}
		
		//Properties matrix.length and matrix.width are read from the matrix.properties file
		String matrixLength = data.getProperty("matrix.length");
		String matrixWidth = data.getProperty("matrix.width");
		
		int length = Integer.parseInt(matrixLength);
		int width = Integer.parseInt(matrixWidth);
		
		//matrix of integers
		Integer[][] matrix = new Integer[length][width];
		
		//Array used to store the elements specified in matrix.properties file
		Integer[] elements = new Integer[length*width+2];
		
		//Iteration used to get each element specified in matrix.properties file
		for(int i=0;i<length*width;i++)
		{
			String elementS = data.getProperty("matrix.element"+i);
			int elementI = Integer.parseInt(elementS);
			
			//element from the matrix.properties file is put in the elements array
			elements[i] = elementI;
		}
		
		//index to traverse the elements array
		int index = 0;
		
		//elements are put in the matrix
		for(int i=0; i<matrix.length; i++)
		{
			for(int j=0; j<matrix[0].length; j++)
			{
				//object from the elements array is put in the matrix
				matrix[i][j] = elements[index];
				index++;
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
