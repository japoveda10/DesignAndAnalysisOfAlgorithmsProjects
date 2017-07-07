package coinChange;

public class DynamicProgrammingCoinChange implements CoinChangeCalculator
{
	//-------------------------------------------------------------------------
	// Attributes
	//-------------------------------------------------------------------------
	private int[] denominationsArray;
	
	private int [] resultArray;
	
	private static int[][] matrix;
	
	//-------------------------------------------------------------------------
	// Main
	//-------------------------------------------------------------------------
	public static void main(String[] args)
	{
		DynamicProgrammingCoinChange program = new DynamicProgrammingCoinChange();
		
		int[] array = {1,2,3,4,5};
		int totalValue = 20;
		
		matrix = new int[totalValue][array.length+1];
				
		int[] answer = program.calculateOptimalChange(totalValue, array);
		
		System.out.println("Matrix");
		
		for(int i = 0; i<totalValue; i++)
		{
			for(int j=0; j<array.length+1; j++)
			{
				System.out.println(matrix[i][j]);
			}
		}
		
		System.out.println("Answer");
		
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
		denominationsArray = denominations;
		resultArray = new int[denominations.length];
		
		return dynamicProgramming(denominations.length-1, totalValue);
	}
	
	public int[] dynamicProgramming(int pI, int pValue)
	{
		if(pValue == 0)
		{
			matrix[pValue][pI] = 0;
			return resultArray;
		}
		else if(pI == 0)
		{
			matrix[pValue][pI] = pValue;
			resultArray[pI] = pValue;
		}
		else
		{			
			if(pValue < denominationsArray[pI])
			{
				return dynamicProgramming(pI-1, pValue);
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
					
					if(matrix[pValue-(resultArray[pI]*denominationsArray[pI])][pI-1] > 0)
					{
						resultArray[pI-1] = matrix[pValue][pI-1];
					}
					else
					{
						return dynamicProgramming(pI-1, pValue-(resultArray[pI]*denominationsArray[pI]));
					}
				}
			}
		}
		
		return resultArray;
	}
}
