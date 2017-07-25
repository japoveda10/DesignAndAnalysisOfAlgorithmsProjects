
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
		ReadFastaFile fastaFile = new ReadFastaFile(args[0]);
		
		String sequence1 = "AGGCAGCGACGTGCGTCATCGGTCG";
		String sequence2 = "AGGCTGACGTCGGTCAGAATCCGTCG";
		
		//Align sequences
		SequenceAlignment alignSequences = new SequenceAlignment(sequence1, sequence2);
	}
}
