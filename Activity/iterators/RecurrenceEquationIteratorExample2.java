package iterators;


import java.util.Iterator;

/**
 * Class that represents the iterator of the next recurrence equation
 * Xn=sqrt(n)
 * @author David Cortés and Julio Poveda
 */
public class RecurrenceEquationIteratorExample2 implements Iterator
{
	double n = 1;
	
	@Override
	public boolean hasNext() 
	{
		return n>=0;
	}

	@Override
	public Object next() 
	{
		double answer = Math.sqrt(n);
		n++;
		return answer;
	}
}
