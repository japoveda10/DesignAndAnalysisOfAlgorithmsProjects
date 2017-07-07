package coinChange;

public class DivideAndConquerCoinChange implements CoinChangeCalculator
{
	//-------------------------------------------------------------------------
	// Attributes
	//-------------------------------------------------------------------------
	private int[] denominationsArray;
	
	private int [] resultArray;
	
	//-------------------------------------------------------------------------
	// Main
	//-------------------------------------------------------------------------
	public static void main(String[] args)
	{
		DivideAndConquerCoinChange program = new DivideAndConquerCoinChange();
		
		int[] array = {1,2,3,4,5};
		int[] values = program.calculateOptimalChange(20, array);
		
		for(int i: values)
		{
			System.out.println(i);
		}
	}
	
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
		if(pValue == 0)
		{
			return resultArray;
		}
		else if(pI == 0)
		{
			resultArray[pI] = pValue;
		}
		else
		{			
			if(pValue < denominationsArray[pI])
			{
				return divideAndConquer(pI-1, pValue);
			}
			else
			{
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
