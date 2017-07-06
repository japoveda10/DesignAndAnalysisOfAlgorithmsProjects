package coinChange;

public class DynamicProgrammingCoinChange implements CoinChangeCalculator
{
	public static void main(String[] args)
	{
		int[] denominations = {1,2,3,4,5};
		int totalValue = 103;
		
		int[] answer = calculateOptimalChange1(totalValue, denominations);
		
		for(int i: answer)
		{
			System.out.println(i);
		}
	}
	
	@Override
	public int[] calculateOptimalChange(int totalValue, int[] denominations)
	{
		int[] answer = new int[denominations.length];
		
		return answer;
	}
	
	public static int[] calculateOptimalChange1(int totalValue, int[] denominations)
	{
		int[] answer = new int[denominations.length];
		
		if(totalValue == 0)
		{
			return answer;
		}
		else if(totalValue / denominations[denominations.length-1] >0)
		{
			int number = totalValue / denominations[denominations.length-1];
			int residual = totalValue - number;
			
			if(residual == 0)
			{
				answer[denominations.length-1] = denominations[denominations.length-1];
			}
			else
			{
				//Recursive call
			}
		}
		
		return answer;
	}
	
}
