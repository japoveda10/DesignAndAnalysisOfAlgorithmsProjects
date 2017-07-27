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
	
	/**
	 * Original sequence 1
	 */
	private String originalSequence1;
	
	/**
	 * Description of originalSequence1
	 */
	private String descriptionSequence1;
	
	/**
	 * Original sequence 2
	 */
	private String originalSequence2;
	
	/**
	 * Description of originalSequence2
	 */
	private String descriptionSequence2;
	
	/**
	 * Aligned originalSequence1
	 */
	private String newSequence1;
	
	/**
	 * Aligned originalSequence2
	 */
	private String newSequence2;
	
	//-----------------------------------------------------------
	// Constructors
	//-----------------------------------------------------------
	
	/**
	 * WriteOutputFile constructor
	 * @param pOriginalSequence1 First sequence
	 * @param pDescriptionSequence1 First sequence description
	 * @param pOriginalSequence2 Second sequence
	 * @param pDescriptionSequence2 Second sequence description
	 * @param pNewSequence1 First sequence aligned
	 * @param pNewSequence2 Second sequence aligned
	 */
	public WriteOutputFile(String pOriginalSequence1, String pDescriptionSequence1, String pOriginalSequence2, String pDescriptionSequence2, String pNewSequence1, String pNewSequence2)
	{
		originalSequence1 = pOriginalSequence1;
		descriptionSequence1 = pDescriptionSequence1;
		originalSequence2 = pOriginalSequence2;
		descriptionSequence2 = pDescriptionSequence2;
		newSequence1 = pNewSequence1;
		newSequence2 = pNewSequence2;
		
		BufferedWriter writer = null;
		try
		{
			File file = new File("data/outputFile.fa");
			writer = new BufferedWriter(new FileWriter(file,true));
			
			writer.write(descriptionSequence1);
			writer.write("\n");
			writer.write(newSequence1);
			writer.write("\n");
			writer.write(descriptionSequence2);
			writer.write("\n");
			writer.write(newSequence2);
			writer.write("\n");
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
