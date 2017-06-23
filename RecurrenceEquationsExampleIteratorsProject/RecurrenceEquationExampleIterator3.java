package RecurrenceEquationsExampleIteratorsProject;

import java.util.Iterator;

/**
 * Class that represents the iterator of the next recurrence equation
 * Xn=X(n-1)+X(n-2) X0=0 and X1=1
 * @author David Cortés and Julio Poveda
 */
public class RecurrenceEquationExampleIterator3 implements Iterator
{
	
	int xn;
	
	@Override
	public boolean hasNext() 
	{
		return xn>=0;
	}

	@Override
	public Object next() 
	{
		int answer = fibonacci(xn);
		xn++;

		return answer;
	}
	
	public int fibonacci(int pNumber)
	{
		if(pNumber == 0)
		{
			return 0;
		}
		else if(pNumber == 1)
		{
			return 1;
		}
		else
		{
			return fibonacci(pNumber-1) + fibonacci(pNumber-2);
		}
	}
}
