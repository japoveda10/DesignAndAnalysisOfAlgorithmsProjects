
/**
 * Class that implements the Predicate interface
 * @author David Cortés and Julio Poveda
 */
public class Algorithm implements Predicate
{
	@Override
	public boolean truePredicate(Object pObject) 
	{
		if((int)pObject>100000)
		{
			return true;
		}
		
		return false;
	}
}
