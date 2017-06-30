package matrix;

import java.util.Iterator;

/**
 * Class that represents an objects matrix iterator
 * Goes through each element of the matrix by rows
 * @author David Cortes and Julio Poveda
 */
public class MatrixIterator1 implements Iterator
{
	Object[][] matrix;
	int i;
	int j;
	
	public MatrixIterator1(Object[][] pObjectsMatrix)
	{
		matrix = pObjectsMatrix;
		i = 0;
		j = 0;
	}
	
	@Override
	public boolean hasNext() 
	{
		return i<matrix.length;
	}

	@Override
	public Object next() 
	{
		Object object = matrix[i][j];
		
		if(j < matrix[0].length-1)
		{
			j += 1;			
		}
		else
		{
			j = 0;
			i += 1;
		}
		
		return object;
	}
}
