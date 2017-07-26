
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
		
		String sequence1Description = fastaFile.getDescription();
		String sequence2Description = fastaFile.getDescription(1);
		
		//Sequences alignment
		SequenceAlignment alignSequences = new SequenceAlignment(sequence1, sequence2);
		
		String newSequence1 = alignSequences.getNewSequence1();
		String newSequence2 = alignSequences.getNewSequence2();
		
		//Writes aligned sequences in output file
		WriteOutputFile outputFile = new WriteOutputFile(sequence1, sequence1Description, sequence2, sequence2Description, newSequence1, newSequence2);
	}
}
