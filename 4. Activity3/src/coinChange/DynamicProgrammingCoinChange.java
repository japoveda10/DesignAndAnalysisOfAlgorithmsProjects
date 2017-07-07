package coinChange;

public class DynamicProgrammingCoinChange implements CoinChangeCalculator
{
	//-------------------------------------------------------------------------
	// Main
	//-------------------------------------------------------------------------
	public static void main(String[] args)
	{
		DynamicProgrammingCoinChange program = new DynamicProgrammingCoinChange();
		
		int[] denominations = {1,2,3,4,5};
		int totalValue = 103;
		
		int[] answer = program.calculateOptimalChange(totalValue, denominations);
		
		for(int i: answer)
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
		int[] answer = new int[denominations.length];
		
		if(totalValue == 0)
		{
			return answer;
		}
		else if(totalValue / denominations[denominations.length-1] >0)
		{
			int number = totalValue / denominations[denominations.length-1];
			int residual = totalValue - (denominations[denominations.length-1] * number);
			
			if(residual == 0)
			{
				answer[denominations.length-1] += (totalValue / denominations[denominations.length-1]);
			}
			else
			{
				for(int i = denominations.length-1; i<denominations.length && totalValue != 0; i--)
				{
					if(denominations[i]<=totalValue)
					{
						answer[i] += totalValue / denominations[i];
						totalValue -= answer[i] * denominations[i];
						
						answer = calculateOptimalChange(totalValue, denominations);
					}
				}
			}
		}
		
		return answer;
	}
}
