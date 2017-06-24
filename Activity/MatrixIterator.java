import java.util.Iterator;

/**
 * Class that represents an objects matrix iterator
 * @author David Cortés and Julio Poveda
 */
public class MatrixIterator implements Iterator
{
	
	Object[][] matrix;
	int i;
	int j;
	
	public MatrixIterator(Object[][] pObjectsMatrix)
	{
		matrix = pObjectsMatrix;
		i = 0;
		j = 0;
	}
	
	@Override
	public boolean hasNext() 
	{
		return i>=0;
	}

	@Override
	public Object next() 
	{
		Object object = null;
		
		if(i < matrix.length)
		{
			System.out.println("index i = " + i);
			System.out.println("index j = " + j);
			object = matrix[i][j];
			i += 1;			
		}
		else if(i == matrix.length)
		{
			System.out.println("else if");
			i = 0;
			j += 1;
			object = matrix[i][j];			
		}
		
		return object;
	}
}
