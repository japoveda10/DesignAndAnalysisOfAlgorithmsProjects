package src;

/**
 * Class that aligns 2 sequences
 * @author David Cortes and Julio Poveda
 */
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
	
	/**
	 * Original sequence 1
	 */
	private String sequence1;
	
	/**
	 * Original sequence 2
	 */
	private String sequence2;
	
	/**
	 * Penalty
	 */
	private int penalty;
	
	/**
	 * Aligned sequence 1
	 */
	private String newSequence1;
	
	/**
	 * Aligned sequence 2
	 */
	private String newSequence2;
	
	//-----------------------------------------------------------
	// Constructors
	//-----------------------------------------------------------
	
	/**
	 * SequenceAlignment constructor
	 * @param pSequence1 First sequence to align
	 * @param pSequence2 Second sequence to align
	 */
	public SequenceAlignment(String pSequence1, String pSequence2)
	{
		sequence1 = pSequence1;
		sequence2 = pSequence2;
		newSequence1 = "";
		newSequence2 = "";
		
		penalty = 0;
		
		alignSequences();
	}
	
	//-----------------------------------------------------------
	// Methods
	//-----------------------------------------------------------
	
	/**
	 * Align sequences
	 */
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
		
		//Nested loops to fill matrix with scores
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
				
				//matrix[i][j] will store the smallest score
				matrix[i][j] = Math.min(Math.min(comingFromDiagonalScore, comingFromLeftScore), comingFromUpScore);
			}
		}
		
		System.out.println();
		System.out.println("Score-filled matrix");
		System.out.println();
		
		//Prints score-filled matrix
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
		
		System.out.println();
		System.out.println("Traceback");
		System.out.println();
		
		System.out.print(matrix[i][j]);
		System.out.println();
		
		while(i >= 0 && j >= 0 && matrix[i][j] != 0)
		{
			if(i == 0)
			{
				System.out.println(matrix[i][j-1]);
				
				newSequence1 += "-";
				
				if(sequence2.length() == newSequence2.length())
				{
					newSequence2 += sequence1.charAt(j-1);
					j = j-1;
				}
				else
				{
					newSequence2 += "-";
					j = j-1;
				}
			}
			else if(j == 0)
			{
				System.out.println(matrix[i-1][j]);
				
				newSequence2 += "-";
				
				if(sequence1.length() == newSequence2.length())
				{
					newSequence1 += sequence2.charAt(i-1);
					i = i-1;
				}
				else
				{
					newSequence1 += "-";
					i = i-1;
				}
			}
			else
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
					System.out.println(matrix[i-1][j]);
					
					newSequence2 += "-";
					newSequence1 += sequence1.charAt(i-1);
					i = i-1;
				}
				else if(matrix[i][j-1] + GAP < matrix[i-1][j-1] + penalty && matrix[i][j-1] + GAP < matrix[i-1][j] + GAP)
				{
					System.out.println(matrix[i][j-1]);
					
					newSequence1 += "-";
					newSequence2 += sequence1.charAt(j-1);
					j = j-1;
				}
			}
		}
		
		System.out.println();
		System.out.println("Aligned sequences");
		System.out.println();
		System.out.println(new StringBuilder(newSequence1).reverse().toString());
		System.out.println(new StringBuilder(newSequence2).reverse().toString());
		System.out.println();
	}
	
	/**
	 * Returns aligned sequence 1
	 * @return newSequence1 but in reverse
	 */
	public String getNewSequence1()
	{
		return new StringBuilder(newSequence1).reverse().toString();
	}
	
	/**
	 * Returns aligned sequence 2
	 * @return newSequence2 but in reverse
	 */
	public String getNewSequence2()
	{
		return new StringBuilder(newSequence2).reverse().toString();
	}
}
