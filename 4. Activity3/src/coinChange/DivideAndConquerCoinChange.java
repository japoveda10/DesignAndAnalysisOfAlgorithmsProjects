package coinChange;

public class DivideAndConquerCoinChange implements CoinChangeCalculator
{
	public static void main(String[] args)
	{
		int[] array = {1,2,3,4,5};
		int[] values = calculateOptimalChange1(27, array);
		
		for(int i: values)
		{
			System.out.println(i);
		}
	}
	
	@Override
	public int[] calculateOptimalChange(int totalValue, int[] denominations)
	{
		int[] m = new int[denominations.length-1];
						
		return m;
	}
	
	public static int[] calculateOptimalChange1(int totalValue, int[] denominations)
	{
		int[] answer = new int[denominations.length];
		
		//Greatest denomination of ordered array
		int greater = denominations[denominations.length-1];
		
		int result = (totalValue / greater);
		
		if(totalValue == 0)
		{
			return answer;
		}
		else if((result * greater) == totalValue)
		{
			answer[denominations.length-1] = (totalValue / greater);
		}
		else
		{
			int middle = denominations.length / 2;
			int[] leftArray = new int[middle];
			int[] rightArray = new int[middle];
			
			System.arraycopy(denominations, 0, leftArray, 0, leftArray.length);
			System.arraycopy(denominations, leftArray.length, rightArray, 0, rightArray.length);
			
			int[] second = calculateOptimalChange1(totalValue / 2, rightArray);
			//If to determine if it is necessary to revise second part of array
			
			//int[] first = calculateOptimalChange2(totalValue / 2, leftArray);
			
			//System.arraycopy(first, 0, m, 0, first.length);
			//System.arraycopy(second, 0, m, first.length, second.length);
		}
						
		return answer;
	}	
}
