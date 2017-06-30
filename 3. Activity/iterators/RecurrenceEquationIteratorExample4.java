package iterators;

import java.util.Iterator;

/**
 * Class that represents the iterator of the next recurrence equation
 * Xn=1+2X(n/2) X0=1
 * @author David Cortes and Julio Poveda
 */
public class RecurrenceEquationIteratorExample4 implements Iterator
{
	double n = 0;
	
	@Override
	public boolean hasNext() 
	{
		return n>=0;
	}

	@Override
	public Object next() 
	{
		if(n == 0)
		{
			n++;
			return 1;
		}
		else
		{
			//answer is log(n) because the recurrence equation is the complexity of binary search
			double answer = Math.log(n);
			n++;
			
			return answer;
		}
		
	}
}
