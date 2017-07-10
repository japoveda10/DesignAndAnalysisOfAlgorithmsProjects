package coinChange;

/**
 * Dynamic Programming algorithm that solves minimum coin change
 * @author David Cortes and Julio Poveda
 */
public class DynamicProgrammingCoinChange implements CoinChangeCalculator
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
	
	/**
	 * Matrix. First index represents denomination index, second index represents total value
	 */
	private static int[][] matrix;
	
	//-------------------------------------------------------------------------
	// Main
	//-------------------------------------------------------------------------
	public static void main(String[] args)
	{
		DynamicProgrammingCoinChange program = new DynamicProgrammingCoinChange();
		
		int[] array = {1,2,3,4,5};
		int totalValue = 20;
		
		matrix = new int[100][100];
				
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
			matrix[pI][pValue] = 0;
			return resultArray;
		}
		else if(pI == 0)
		{
			matrix[pI][pValue] = pValue;
			resultArray[pI] = pValue;
		}
		else
		{			
			if(pValue < denominationsArray[pI])
			{
				if(matrix[pI-1][pValue] >0)
				{
					resultArray[pI-1] = matrix[pI-1][pValue];
				}
				else
				{
					return dynamicProgramming(pI-1, pValue);
				}
			}
			else
			{
				if(pValue % denominationsArray[pI] == 0)
				{
					matrix[pI][pValue] = (pValue / denominationsArray[pI]);
					resultArray[pI] = (pValue / denominationsArray[pI]);
				}
				else
				{
					resultArray[pI] = (pValue / denominationsArray[pI]);
					
					if(matrix[pI-1][pValue-(resultArray[pI]*denominationsArray[pI])] > 0)
					{
						resultArray[pI-1] = matrix[pI-1][pValue];
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
