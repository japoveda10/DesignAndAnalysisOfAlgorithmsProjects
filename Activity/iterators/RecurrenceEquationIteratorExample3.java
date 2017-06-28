package iterators;

import java.util.Iterator;

/**
 * Class that represents the iterator of the next recurrence equation
 * Xn=X(n-1)+X(n-2) X0=0 and X1=1
 * @author David Cortes and Julio Poveda
 */
public class RecurrenceEquationIteratorExample3 implements Iterator
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
		//answer is fibonacci(xn) because the recurrence equation is Fibonacci´s sequence
		int answer = fibonacci(xn);
		xn++;

		return answer;
	}
	
	/**
	 * Calculates the Fibonacci number of a position in the sequence
	 * @param pNumber Position in the Fibonacci sequence
	 * @return 0 or 1 if pNumber is equal to 0 or 1 (base cases) 
	 * or Fibbonacci number according to the position
	 */
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
