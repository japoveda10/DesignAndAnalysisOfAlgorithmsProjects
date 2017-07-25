
public class SequenceAlignment
{
	
	//-----------------------------------------------------------
	// Constants
	//-----------------------------------------------------------
	
	/**
	 * Char match penalty
	 */
	private final static int CHAR_MATCH = 0;
	
	/**
	 * Char mismatch penalty
	 */
	private final static int CHAR_MISMATCH = 1;
	
	/**
	 * Gap penalty
	 */
	private final static int GAP = 2;
	
	//-----------------------------------------------------------
	// Attributes
	//-----------------------------------------------------------
	
	private String sequence1;
	
	private String sequence2;
	
	private int penalty;
	
	//-----------------------------------------------------------
	// Constructors
	//-----------------------------------------------------------
	
	public SequenceAlignment(String pSequence1, String pSequence2)
	{
		sequence1 = pSequence1;
		sequence2 = pSequence2;
		
		penalty = 0;
		
		alignSequences();
	}
	
	//-----------------------------------------------------------
	// Methods
	//-----------------------------------------------------------
	
	public void alignSequences()
	{
		//Matrix used for Dynamic Programming
		int[][] matrix = new int[sequence1.length() + 1][sequence2.length() + 1];
		
		for(int i = 1; i<=sequence1.length(); i++)
		{
			matrix[i][0] = matrix[i-1][0] + GAP;
		}
		
		for(int j = 1; j<=sequence2.length(); j++)
		{
			matrix[0][j] = matrix[0][j-1] + GAP;
		}
		
		for(int i = 1; i<=sequence1.length(); i++)
		{
			for(int j = 1; j<=sequence2.length(); j++)
			{
				if(sequence1.charAt(i-1) == sequence2.charAt(j-1))
				{
					penalty = CHAR_MATCH;
				}
				else
				{
					penalty = CHAR_MISMATCH;
				}
				
				int comingFromDiagonalScore = matrix[i-1][j-1] + penalty;
				
				int comingFromLeftScore = matrix[i][j-1] + GAP;
				
				int comingFromUpScore = matrix[i-1][j] + GAP;
				
				matrix[i][j] = Math.min(Math.min(comingFromDiagonalScore, comingFromLeftScore), comingFromUpScore);
			}
		}
		
		for (int i = 0; i <= sequence1.length(); i++)
		{
			for (int j = 0; j <= sequence2.length(); j++)
			{
				System.out.print(matrix[i][j] + "\t");
			}
			
			System.out.println();
		}
		
		// Traceback
		int i = sequence1.length();
		int j = sequence2.length();
		
		String newSequence1 = "";
		String newSequence2 = "";
		
		System.out.print(matrix[i][j]);
		System.out.println();
		
		while(i > 0 && j > 0)
		{
			if(matrix[i-1][j-1] + penalty <= matrix[i-1][j] + GAP && matrix[i-1][j-1] + penalty <= matrix[i][j-1] + GAP)
			{
				//there is no displacement
				System.out.println(matrix[i-1][j-1]);
				
				newSequence1 += sequence1.charAt(i-1);
				newSequence2 += sequence2.charAt(j-1);
				
				i = i-1;
				j = j-1;
			}
			else if(matrix[i-1][j] + GAP < matrix[i-1][j-1] + penalty && matrix[i-1][j] + GAP < matrix[i][j-1] + GAP)
			{
				//horizontal sequence displacement
				System.out.println(matrix[i-1][j]);
				newSequence1 += "-";
				i = i-1;
			}
			else if(matrix[i][j-1] + GAP < matrix[i-1][j-1] + penalty && matrix[i][j-1] + GAP < matrix[i-1][j] + GAP)
			{
				//vertical sequence displacement
				System.out.println(matrix[i][j-1]);
				newSequence2 += "-";
				j = j-1;
			}
		}
		
		System.out.println("");
		System.out.println(newSequence1);
		System.out.println(newSequence2);
	}
}
