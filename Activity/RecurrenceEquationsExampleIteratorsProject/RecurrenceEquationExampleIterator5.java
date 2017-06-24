package RecurrenceEquationsExampleIteratorsProject;

import java.util.Iterator;

/**
 * Class that represents the iterator of prime numbers
 * @author David Cortés and Julio Poveda
 */
public class RecurrenceEquationExampleIterator5 implements Iterator
{
	
	int n = 1;
	
	@Override
	public boolean hasNext() 
	{
		return n>=0;
	}

	@Override
	public Object next() 
	{
		Object answer = n;
		
		if((int)answer % 2 == 0)
		{
			answer = "";
		}
		
		n++;
		
		return answer;
	}
}
