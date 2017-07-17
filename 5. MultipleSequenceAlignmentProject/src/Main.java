import java.io.*;
import java.util.*;

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
		
		String fn ="";
		if (args.length>0) fn=args[0];
		else 
		{
			System.out.print("Enter the name of the FastaFile:");
			fn = (new BufferedReader(new InputStreamReader(System.in))).readLine();
		}
		
		FastaSequence fsf = new FastaSequence(fn);
		
		int numberOfSequences = 0;
		
		for (int i=0; i< fsf.size(); i++)
		{
			System.out.println("One sequence read from file "+ fn +" with length "+fsf.getSequence().length() );
			System.out.println("description: \n"+ fsf.getDescription(i));
			System.out.println("Sequence: \n"+ fsf.getSequence(i));
			
			numberOfSequences++;
		}
		
		System.out.println("Total number of sequences: " + numberOfSequences);
	}
}
