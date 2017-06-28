import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;

import iterators.RecurrenceEquationIteratorExample5;
import matrix.MatrixIterator1;
import matrix.MatrixIterator2;
import matrix.MatrixIterator3;

/**
 * Main class of part 2 of Activity of the course Design and Analysis of Algorithms
 * @author David Cortes and Julio Poveda
 */
public class MatrixTraversalsMain 
{
	public static void main(String [] args) throws Exception
	{
		
		//----------------------------------------------------------
		// Activity Part 2
		//----------------------------------------------------------
		System.out.println("--------------------------------------");
		System.out.println("Activity Part 2");
		System.out.println("--------------------------------------");
		
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
		
		//Verifies that matrix that wants to be created is squared
		if(length != width)
		{
			throw new Exception("Matrix is not squared");
		}
		
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
		
		Iterator iterator = null;
		
		if(iteratorClassName.equals("matrix.MatrixIterator1"))
		{
			//Iterator is MatrixIterator1
			iterator = new MatrixIterator1(matrix);
			
			System.out.println("This matrix iterator goes through each element of the matrix by rows:");
			System.out.println("");
		}
		else if(iteratorClassName.equals("matrix.MatrixIterator2"))
		{
			//Iterator is MatrixIterator2
			iterator = new MatrixIterator2(matrix);
			
			System.out.println("This matrix iterator goes through each element of the matrix by columns:");
			System.out.println("");
		}
		else if(iteratorClassName.equals("matrix.MatrixIterator3"))
		{
			//Iterator is MatrixIterator3
			iterator = new MatrixIterator3(matrix);
			
			System.out.println("This matrix iterator traverses the matrix diagonally from the upper left corner until the last element of the main diagonal:");
			System.out.println("");
		}
		
		while(iterator.hasNext())
		{
			Object o = iterator.next();
			System.out.println(o.toString());
		}		
	}
}
