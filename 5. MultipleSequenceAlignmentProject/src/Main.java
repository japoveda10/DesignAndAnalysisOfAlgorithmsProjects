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
		System.out.println("-------------------------------------------------");
		System.out.println("Multiple Sequence Alignment Project");
		System.out.println("-------------------------------------------------");
		
		//Read input file
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
		}
		
		char[] sequence1OfChar = new char[sequence1.length()];
		char[] sequence2OfChar = new char[sequence2.length()];
		
		//sequence1 String converted to array
		for(int i = 0; i<sequence1.length(); i++)
		{
			sequence1OfChar[i] = sequence1.charAt(i);
		}
		
		//sequence2 String converted to array
		for(int j = 0; j<sequence2.length(); j++)
		{
			sequence2OfChar[j] = sequence2.charAt(j);
		}
		
		//Sequence with larger size is going to be sequence1OfChar
		if(sequence2OfChar.length > sequence1OfChar.length)
		{
			char[] temp = sequence1OfChar;
			sequence1OfChar = sequence2OfChar;
			sequence2OfChar = temp;
		}
		
		//Matrix used for Dynamic Programming
		int[][] matrix = new int[sequence1OfChar.length][sequence2OfChar.length];
		
		//Matrix traversal
		for(int i = 0; i<matrix.length; i++)
		{
			for(int j=0; j<matrix[0].length; j++)
			{
				//Initialize matrix
			}
		}
	}
}
