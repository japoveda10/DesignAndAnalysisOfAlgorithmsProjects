package coinChange;

/**
 * Greedy algorithm that solves minimum coin change
 * @author David Cortes and Julio Poveda
 */
public class GreedyAlgorithmCoinChange implements CoinChangeCalculator
{	
	//-------------------------------------------------------------------------
	// Methods
	//-------------------------------------------------------------------------
	@Override
	public int[] calculateOptimalChange(int totalValue, int[] denominations)
	{
		//Answer array
		int[] answer = new int[denominations.length];
		
		//Iterate from greatest denomination backwards
		for(int i = denominations.length-1; i<denominations.length && totalValue != 0; i--)
		{
			//denomination i is less than or equal to totalValue
			if(denominations[i]<=totalValue)
			{
				answer[i] = totalValue / denominations[i];
				totalValue -= answer[i] * denominations[i];
			}
		}
		
		return answer;
	}
}
