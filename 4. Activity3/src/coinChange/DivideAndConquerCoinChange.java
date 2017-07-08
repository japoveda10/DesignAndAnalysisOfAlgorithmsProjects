package coinChange;

/**
 * Divide and conquer algorithm that solves minimum coin change
 * @author David Cortes and Julio Poveda
 */
public class DivideAndConquerCoinChange implements CoinChangeCalculator
{
	//-------------------------------------------------------------------------
	// Attributes
	//-------------------------------------------------------------------------
	/**
	 * Denominations array
	 */
	private int[] denominationsArray;
	
	/**
	 * Result array
	 */
	private int [] resultArray;
	
	//-------------------------------------------------------------------------
	// Methods
	//-------------------------------------------------------------------------
	@Override
	public int[] calculateOptimalChange(int totalValue, int[] denominations)
	{		
		denominationsArray = denominations;
		resultArray = new int[denominations.length];
		
		return divideAndConquer(denominations.length-1, totalValue);
	}
	
	public int[] divideAndConquer(int pI, int pValue)
	{
		//Base case
		if(pValue == 0)
		{
			return resultArray;
		}
		//Index corresponds to first position of denominations array
		else if(pI == 0)
		{
			resultArray[pI] = pValue;
		}
		else
		{			
			//denomination pI greater than pValue
			if(pValue < denominationsArray[pI])
			{
				return divideAndConquer(pI-1, pValue);
			}
			else
			{
				//denomination pI is multiple of pValue
				if(pValue % denominationsArray[pI] == 0)
				{
					resultArray[pI] = (pValue / denominationsArray[pI]);
				}
				else
				{
					resultArray[pI] = (pValue / denominationsArray[pI]);
					return divideAndConquer(pI-1, pValue-(resultArray[pI]*denominationsArray[pI]));
				}
			}
		}
		
		return resultArray;
	}
}
