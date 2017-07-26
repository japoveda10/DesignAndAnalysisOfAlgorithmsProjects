import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * Writes aligned sequences in output file
 * @author David Cortes and Julio Poveda
 */
public class WriteOutputFile
{
	//-----------------------------------------------------------
	// Attributes
	//-----------------------------------------------------------
	
	private String originalSequence1;
	
	private String originalSequence2;
	
	private String newSequence1;
	
	private String newSequence2;
	
	//-----------------------------------------------------------
	// Constructors
	//-----------------------------------------------------------
	
	public WriteOutputFile(String pOriginalSequence1, String pOriginalSequence2, String pNewSequence1, String pNewSequence2)
	{
		originalSequence1 = pOriginalSequence1;
		originalSequence2 = pOriginalSequence2;
		newSequence1 = pNewSequence1;
		newSequence2 = pNewSequence2;
		
		BufferedWriter writer = null;
		try
		{
			File file = new File("data/outputFile.txt");
			writer = new BufferedWriter(new FileWriter(file));
			
			writer.write("New sequence 1:");
			writer.newLine();
			writer.write(newSequence1);
			writer.newLine();
			writer.write("New sequence 2:");
			writer.newLine();
			writer.write(newSequence2);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				writer.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
