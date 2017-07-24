import java.io.*;

/**
 * Main class of Multiple Sequence Alignment Project
 * For reading Fasta file, we based on http://www.cs.utexas.edu/~mobios/cs329e/rosetta/src/FastaSequence.java
 * @author David Cortes and Julio Poveda
 */
public class Main
{
	//-----------------------------------------------------------
	// Main
	//-----------------------------------------------------------
	
	public static void main(String[] args) throws Exception
	{
		/*System.out.println("-------------------------------------------------");
		System.out.println("Multiple Sequence Alignment Project");
		System.out.println("-------------------------------------------------");
		
		//-------------------------------------------------------------------------
		// Read input file
		//-------------------------------------------------------------------------
		
		String fn ="";
		if (args.length>0) fn=args[0];
		else 
		{
			System.out.print("Enter the name of the FastaFile:");
			fn = (new BufferedReader(new InputStreamReader(System.in))).readLine();
		}
		
		FastaSequence fsf = new FastaSequence(fn);
		
		int numberOfSequences = 0;
		
		//Sequences to compare
		String sequence1 = "";
		String sequence2 = "";
		
		for (int i=0; i< fsf.size(); i++)
		{
			System.out.println("One sequence read from file "+ fn +" with length "+fsf.getSequence().length() );
			System.out.println("description: \n"+ fsf.getDescription(i));
			System.out.println("Sequence: \n"+ fsf.getSequence(i));
			
			if(i == 0)
			{
				sequence1 = fsf.getSequence(i);
			}
			else if(i == 32)
			{
				sequence2 = fsf.getSequence(i);
			}
			
			numberOfSequences++;
		}
		
		System.out.println("Total number of sequences: " + numberOfSequences);
		
		System.out.println(sequence1);
		System.out.println(sequence1.length());
		System.out.println(sequence2);
		System.out.println(sequence2.length());
		
		if(sequence1.equals(sequence2))
		{
			System.out.println("Sequences are equal");
		}
		else
		{
			System.out.println("Sequences are not equal");
		}*/
		
		//-------------------------------------------------------------------------
		// Sequences analysis
		//-------------------------------------------------------------------------
		
		String sequence1 = "CCATTGACAA";
		String sequence2 = "ACTGGAAT";
		
		//Sequence with larger size is going to be sequence1
		if(sequence1.length() > sequence2.length())
		{
			String temp = sequence1;
			sequence1 = sequence2;
			sequence2 = temp;
		}
		
		//Matrix used for Dynamic Programming
		int[][] matrix = new int[sequence1.length() + 1][sequence2.length() + 1];
		
		//Penalties
		int charMatch = 0;
		int charMismatch = 1;
		int gap = 2;
		
		for(int i = 1; i<=sequence1.length(); i++)
		{
			matrix[i][0] = matrix[i-1][0] + gap;
		}
		
		for(int j = 1; j<sequence2.length(); j++)
		{
			matrix[0][j] = matrix[0][j-1] + gap;
		}
		
		for(int i = 1; i<=sequence1.length(); i++)
		{
			for(int j = 1; j<=sequence2.length(); j++)
			{
				int penalty = 0;
				
				if(sequence1.charAt(i-1) == sequence2.charAt(j-1))
				{
					penalty = charMatch;
				}
				else
				{
					penalty = charMismatch;
				}
				
				int comingFromDiagonalScore = matrix[i-1][j-1] + penalty;
				
				int comingFromLeftScore = matrix[i][j-1] + gap;
				
				int comingFromUpScore = matrix[i-1][j] + gap;
				
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
		
		//Traceback
		int i = sequence1.length();
		int j = sequence2.length();
		boolean finish = false;
		
		System.out.print(matrix[i][j]);
		System.out.println();
		
		while(i > 0 && j > 0)
		{
			if(matrix[i-1][j-1] < matrix[i-1][j] && matrix[i-1][j-1] < matrix[i][j-1])
			{
				//there is no displacement
				System.out.println(matrix[i-1][j-1]);
				i = i-1;
				j = j-1;
				finish = true;
			}
			else if(matrix[i-1][j] < matrix[i-1][j-1] && matrix[i-1][j] < matrix[i][j-1])
			{
				//horizontal sequence displacement
				System.out.println(matrix[i-1][j]);
				i = i-1;
			}
			else
			{
				//vertical sequence displacement
				System.out.println(matrix[i][j-1]);
				j = j-1;
			}
		}
	}
}
