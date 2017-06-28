
/**
 * Class that implements the Predicate interface
 * @author David Cortes and Julio Poveda
 */
public class Algorithm implements Predicate
{
	int number = 0;
	
	/**
	 * Sets number as the value that enters as parameter
	 * @param pNumber New number
	 */
	public void setNumber(int pNumber)
	{
		number = pNumber;
	}
	
	@Override
	public boolean truePredicate(Object pObject) 
	{
		if((int)pObject>number)
		{
			return true;
		}
		
		return false;
	}
}
