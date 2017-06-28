package matrix;

import java.util.Iterator;

/**
 * Class that represents an objects matrix iterator
 * Goes through each element of the matrix by columns
 * @author David Cortes and Julio Poveda
 */
public class MatrixIterator2 implements Iterator
{
	Object[][] matrix;
	int i;
	int j;
	
	public MatrixIterator2(Object[][] pObjectsMatrix)
	{
		matrix = pObjectsMatrix;
		i = 0;
		j = 0;
	}
	
	@Override
	public boolean hasNext() 
	{
		return j<matrix[0].length;
	}

	@Override
	public Object next() 
	{
		Object object = matrix[i][j];
		
		if(i < matrix.length-1)
		{
			i += 1;			
		}
		else
		{
			i = 0;
			j += 1;
		}
		
		return object;
	}
}
