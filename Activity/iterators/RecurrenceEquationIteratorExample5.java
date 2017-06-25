package iterators;


import java.util.Iterator;

/**
 * Class that represents the iterator of prime numbers
 * @author David Cortés and Julio Poveda
 */
public class RecurrenceEquationIteratorExample5 implements Iterator
{
	int n = 0;
	
	@Override
	public boolean hasNext() 
	{
		return n>=0;
	}

	@Override
	public Object next() 
	{
		Object answer = n;
		
		n++;
		
		if((int)answer % 2 == 0)
		{
			//if n is not prime, go and search for the next prime
			answer = next();
		}
				
		return answer;
	}
}
