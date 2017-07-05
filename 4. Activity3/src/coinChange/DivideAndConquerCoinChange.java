package coinChange;

public class DivideAndConquerCoinChange implements CoinChangeCalculator
{

	@Override
	public int[] calculateOptimalChange(int totalValue, int[] denominations)
	{
		//Quantity array
		int[] m = new int[denominations.length-1];
		
		//Initialization of array
		for(int i = 0; i<m.length; i++)
		{
			m[i] = 0;
		}
		
		//Greatest denomination of ordered array
		int greater = denominations[denominations.length-1];
		
		if(totalValue == 0)
		{
			return m;
		}
		else if(totalValue / greater >0)
		{
			m[denominations.length-1] = (totalValue / greater);
		}
		else
		{
			for(int i = 0; i<denominations.length; i++)
			{
				if(denominations[i] <= totalValue)
				{
					m = calculateOptimalChange(totalValue - denominations[i], denominations);
				}
			}
		}
						
		return m;
	}
	
	public static int[] calculateOptimalChange1(int totalValue, int[] denominations)
	{
		//Quantity array
		int[] m = new int[denominations.length];
		
		//Initialization of array
		for(int i = 0; i<m.length; i++)
		{
			m[i] = 0;
		}
		
		//Greatest denomination of ordered array
		int greater = denominations[denominations.length-1];
		
		int result = (totalValue / greater);
		
		if(totalValue == 0)
		{
			return m;
		}
		else if((result * greater) == totalValue)
		{
			m[denominations.length-1] = (totalValue / greater);
		}
		else
		{
			m[denominations.length-1] = (totalValue / greater);
			int residue = totalValue - ((totalValue/greater)*greater);
			boolean finish = false;
			
			for(int i = 0; i<denominations.length && !finish; i++)
			{
				if(denominations[i] == residue)
				{
					m[i] = 1;
					finish = true;
				}
			}
		}
						
		return m;
	}
	
	public static int[] calculateOptimalChange2(int totalValue, int[] denominations)
	{
		//Quantity array
		int[] m = new int[denominations.length];
		
		//Initialization of array
		for(int i = 0; i<m.length; i++)
		{
			m[i] = 0;
		}
		
		//Greatest denomination of ordered array
		int greater = denominations[denominations.length-1];
		
		int result = (totalValue / greater);
		
		if(totalValue == 0)
		{
			return m;
		}
		else if((result * greater) == totalValue)
		{
			m[denominations.length-1] = (totalValue / greater);
		}
		else
		{
			int middle = denominations.length / 2;
			int[] leftArray = new int[middle];
			int[] rightArray = new int[middle];
			
			System.arraycopy(denominations, 0, leftArray, 0, leftArray.length);
			System.arraycopy(denominations, leftArray.length, rightArray, 0, rightArray.length);
			
			int[] second = calculateOptimalChange2(totalValue / 2, rightArray);
			//If to determine if it is necessary to revise second part of array
			
			int[] first = calculateOptimalChange2(totalValue / 2, leftArray);
			
			System.arraycopy(first, 0, m, 0, first.length);
			System.arraycopy(second, 0, m, first.length, second.length);
		}
						
		return m;
	}
	
	public static void main(String[] args)
	{
		int[] array = {1,2,3,4,5};
		int[] values = calculateOptimalChange1(36, array);
		
		for(int i: values)
		{
			System.out.println(i);
		}
	}
	
}
