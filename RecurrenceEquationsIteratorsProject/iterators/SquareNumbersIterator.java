package iterators;


import java.util.Iterator;

/**
 * Class that represents a square numbers interator
 * @author David Cortés and Julio Poveda
 */
public class SquareNumbersIterator implements Iterator
{
	int n = 1;

	@Override
	public boolean hasNext() 
	{
		return n*n>0;
	}

	@Override
	public Object next() 
	{
		Integer square = n*n;
		n++;
		return square;
	}
}
