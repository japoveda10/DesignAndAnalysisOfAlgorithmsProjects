
/**
 * Interface that represents a predicate
 * @author David Cortés and Julio Poveda
 */
public interface Predicate 
{
	/**
	 * Receives an object and returns a boolean
	 * @param pObject Object to be evaluated according to predicate
	 * @return true if predicate is true, false if predicate is not true
	 */
	public boolean truePredicate(Object pObject);

}
