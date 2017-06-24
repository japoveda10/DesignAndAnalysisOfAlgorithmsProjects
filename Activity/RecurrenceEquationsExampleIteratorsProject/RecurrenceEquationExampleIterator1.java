package RecurrenceEquationsExampleIteratorsProject;
import java.util.Iterator;

/**
 * Class that represents an iterator of the next recurrence equation
 * Xn=2X(n-1), X0 = 1
 * @author David Cortés and Julio Poveda
 */
public class RecurrenceEquationExampleIterator1 implements Iterator
{
	
	int x = 1;

	@Override
	public boolean hasNext() 
	{
		return x>0;
	}

	@Override
	public Object next() 
	{
		Object answer = x;
		x = 2*x;
		return answer;
	}
}