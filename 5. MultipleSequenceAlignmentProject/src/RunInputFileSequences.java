import java.util.ArrayList;

public class RunInputFileSequences
{
	private String fileName;
	
	private ArrayList<String> sequences;
	
	private ArrayList<String> newSequences;
	
	private ReadFastaFile fastaFile;
	
	public RunInputFileSequences(String pFileName)
	{
		fileName = pFileName;
		sequences = new ArrayList<String>();
		newSequences = new ArrayList<String>();
		
		//Reads input file
		fastaFile = new ReadFastaFile(fileName);
		
		for(int i = 0; i<fastaFile.size(); i++)
		{
			String sequence = fastaFile.getSequence(i);
			sequences.add(sequence);
		}
	}
	
	public void alignSequences()
	{
		SequenceAlignment alignSequences = null;
		int j = 1;
		
		System.out.println("2. Sequences alignment");
		System.out.println();
		
		for(int i = 0; i<sequences.size() && j<sequences.size(); i++)
		{
			System.out.println("------------------------------------------------");
			System.out.println("Comparing sequence " + i + " and sequence " + j);
			System.out.println("------------------------------------------------");
			
			String sequence1 = fastaFile.getSequence(i);
			String sequence2 = fastaFile.getSequence(j);
			
			if(i == 0 && j == 1)
			{
				alignSequences = new SequenceAlignment(sequences.get(i), sequences.get(j));
			}
			else
			{
				alignSequences = new SequenceAlignment(newSequences.get(i), sequences.get(j));
			}
			
			System.out.println();
			String newSequence1 = alignSequences.getNewSequence1();
			String newSequence2 = alignSequences.getNewSequence2();
			
			if(i > 0)
			{
				newSequences.add(newSequence2);
			}
			else
			{
				newSequences.add(newSequence1);
				newSequences.add(newSequence2);
			}
			
			String sequence1Description = fastaFile.getDescription(i);
			String sequence2Description = fastaFile.getDescription(j);
			
			//Writes aligned sequences in output file
			WriteOutputFile outputFile = new WriteOutputFile(sequence1, sequence1Description, sequence2, sequence2Description, newSequence1, newSequence2);
			j++;
		}
	}
	
	public int getNewSequencesSize()
	{
		return newSequences.size();
	}
	
	public String getNewSequence(int pI)
	{
		return newSequences.get(pI);
	}
}
