import java.util.ArrayList;

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
		
		//Reads input file
		ReadFastaFile fastaFile = new ReadFastaFile(args[0]);
		
		String sequence1 = "CCATTGACAA";
		String sequence2 = "ACTGGAAT";
		String sequence3 = "CAGTGC";
		String sequence4 = "GAATTTC";
		
		String sequence1Description = fastaFile.getDescription();
		String sequence2Description = fastaFile.getDescription(1);
		String sequence3Description = fastaFile.getDescription(2);
		String sequence4Description = fastaFile.getDescription(3);
		
		ArrayList<String> sequences = new ArrayList<String>();
		sequences.add(sequence1);
		sequences.add(sequence2);
		sequences.add(sequence3);
		sequences.add(sequence4);
		
		SequenceAlignment alignSequences = null;
		int j = 1;
		
		for(int i = 0; i<sequences.size() && j<sequences.size(); i++)
		{
			System.out.println("------------------------------------------------");
			System.out.println("Comparing sequence " + i + " and sequence " + j);
			System.out.println("------------------------------------------------");
			alignSequences = new SequenceAlignment(sequences.get(i), sequences.get(j));
			System.out.println();
			String newSequence1 = alignSequences.getNewSequence1();
			String newSequence2 = alignSequences.getNewSequence2();
			
			//Writes aligned sequences in output file
			WriteOutputFile outputFile = new WriteOutputFile(sequence1, sequence1Description, sequence2, sequence2Description, newSequence1, newSequence2);
			j++;
		}
	}
}
