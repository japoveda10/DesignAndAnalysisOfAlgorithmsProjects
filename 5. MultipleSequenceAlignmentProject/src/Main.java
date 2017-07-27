
/**
 * Main class of Multiple Sequence Alignment Project
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
		
		//args[0] is file name
		String fileName = args[0];
		
		//args[1] is the number to decide if program aligns default or input sequences
		int number = Integer.parseInt(args[1]);
		
		if(number == 0)
		{
			//Default sequences
			
			//Aligns default sequences
			RunDefaultSequences defaultSequences = new RunDefaultSequences();
			
			//Writes in console aligned sequences
			for(int i = 0; i<defaultSequences.getNewSequencesSize(); i++)
			{
				System.out.println(defaultSequences.getNewSequence(i));
			}
		}
		else if(number == 1)
		{
			//Input sequences
			
			//Reads input file
			RunInputFileSequences inputFileSequences = new RunInputFileSequences(fileName);
			
			//Aligns input file sequences
			inputFileSequences.alignSequences();
			
			//Writes in console aligned sequences
			for(int i = 0; i<inputFileSequences.getNewSequencesSize(); i++)
			{
				System.out.println(inputFileSequences.getNewSequence(i));
			}
		}
		else
		{
			System.out.println("Type a valid number");
		}
	}
}
