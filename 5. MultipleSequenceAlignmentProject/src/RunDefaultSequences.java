import java.util.ArrayList;

/**
 * Runs default sequences alignment
 * @author David Cortes and Julio Poveda
 */
public class RunDefaultSequences
{
	//-----------------------------------------------------------
	// Attributes
	//-----------------------------------------------------------
	
	/**
	 * Sequence 1
	 */
	private String sequence1 = "CCATTGACAA";
	
	/**
	 * Sequence 2
	 */
	private String sequence2 = "ACTGGAAT";
	
	/**
	 * Sequence 3
	 */
	private String sequence3 = "CAGTGC";
	
	/**
	 * Sequence 4
	 */
	private String sequence4 = "GAATTTC";
	
	/**
	 * Sequences ArrayList
	 */
	private ArrayList<String> sequences;
	
	/**
	 * Aligned sequences ArrayList
	 */
	private ArrayList<String> newSequences;
	
	/**
	 * Instance of class that aligns sequences
	 */
	private SequenceAlignment alignSequences;
	
	//-----------------------------------------------------------
	// Constructors
	//-----------------------------------------------------------
	
	/**
	 * RunDefaultSequences constructor
	 */
	public RunDefaultSequences()
	{
		sequences = new ArrayList<String>();
		sequences.add(sequence1);
		sequences.add(sequence2);
		sequences.add(sequence3);
		sequences.add(sequence4);
		
		newSequences = new ArrayList<String>();
		
		alignSequences = null;
		
		int j = 1;
		
		System.out.println("2. Sequences alignment");
		System.out.println();
		
		for(int i = 0; i<sequences.size() && j<sequences.size(); i++)
		{
			System.out.println("------------------------------------------------");
			System.out.println("Comparing sequence " + i + " and sequence " + j);
			System.out.println("------------------------------------------------");
			
			if(i == 0 && j == 1)
			{
				//Enters in first iteration
				alignSequences = new SequenceAlignment(sequences.get(i), sequences.get(j));
			}
			else
			{
				alignSequences = new SequenceAlignment(newSequences.get(i), sequences.get(j));
			}
			
			System.out.println();
			String newSequence1 = alignSequences.getNewSequence1();
			String newSequence2 = alignSequences.getNewSequence2();
			
			if(i == 0)
			{
				//Enters in first iteration
				newSequences.add(newSequence1);
				newSequences.add(newSequence2);
			}
			else
			{
				newSequences.add(newSequence2);
			}
			
			String sequence1Description = ">Sequence " + i + " example description";
			String sequence2Description = ">Sequence " + j + " example description";
			
			//Writes aligned sequences in output file
			WriteOutputFile outputFile = new WriteOutputFile(sequence1, sequence1Description, sequence2, sequence2Description, newSequence1, newSequence2);
			j++;
		}
	}
	
	//-----------------------------------------------------------
	// Methods
	//-----------------------------------------------------------
	
	/**
	 * Returns newSequences ArrayList size
	 * @return newSequences.size()
	 */
	public int getNewSequencesSize()
	{
		return newSequences.size();
	}
	
	/**
	 * Returns aligned sequences in pI position
	 * @param pI Index of sequence
	 * @return newSequences.get(pI)
	 */
	public String getNewSequence(int pI)
	{
		return newSequences.get(pI);
	}
}
