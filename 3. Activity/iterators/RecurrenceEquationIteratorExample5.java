package iterators;

import java.util.Iterator;

/**
 * Class that represents the prime numbers iterator
 * @author David Cortes and Julio Poveda
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
		n++;		

		if((int)n % 2 == 0)
		{
			//if n is not prime, go and search for the next prime
			n = (int)next();
		}		
				
		return n;
	}
}
