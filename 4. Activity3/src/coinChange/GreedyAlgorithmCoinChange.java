package coinChange;

public class GreedyAlgorithmCoinChange implements CoinChangeCalculator
{
	//-------------------------------------------------------------------------
	// Main
	//-------------------------------------------------------------------------
	public static void main(String[] args)
	{
		GreedyAlgorithmCoinChange program = new GreedyAlgorithmCoinChange();
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
		
		for(int i = denominations.length-1; i<denominations.length && totalValue != 0; i--)
		{
			if(denominations[i]<=totalValue)
			{
				answer[i] = totalValue / denominations[i];
				totalValue -= answer[i] * denominations[i];
			}
		}
		
		return answer;
	}
}
