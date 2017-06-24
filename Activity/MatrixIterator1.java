import java.util.Iterator;

/**
 * Class that represents an objects matrix iterator
 * Goes through each element of the matrix by rows
 * @author David Cortés and Julio Poveda
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
		return j>=0;
	}

	@Override
	public Object next() 
	{
		Object object = null;
		
		if(j < matrix[0].length)
		{
			System.out.println("index i = " + i);
			System.out.println("index j = " + j);
			object = matrix[i][j];
			j += 1;			
		}
		else if(j == matrix.length)
		{
			System.out.println("else if");
			j = 0;
			i += 1;
			object = matrix[i][j];			
		}
		
		return object;
	}
}
