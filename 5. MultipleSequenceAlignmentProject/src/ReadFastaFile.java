import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads Fasta file
 * Built based on http://www.cs.utexas.edu/~mobios/cs329e/rosetta/src/FastaSequence.java
 * @author David Cortes and Julio Poveda
 */
public final class ReadFastaFile
{
	//-----------------------------------------------------------
	// Attributes
	//-----------------------------------------------------------
	
	/**
	 * File name
	 */
	private String fileName;
	
	/**
	 * Descriptions array
	 */
	private String[] description;
	
	/**
	 * Sequences array
	 */
	private String[] sequence;
	
	//-----------------------------------------------------------
	// Constructors
	//-----------------------------------------------------------
	
	public ReadFastaFile(String pFile)
	{
		fileName = pFile;
		readSequence();
	}
	
	//-----------------------------------------------------------
	// Methods
	//-----------------------------------------------------------
	
	/**
	 * Reads Fasta file
	 */
	public void readSequence()
	{
		List desc= new ArrayList();
		List seq = new ArrayList();
		
		try
		{
			BufferedReader in     = new BufferedReader( new FileReader( fileName ) );
			StringBuffer   buffer = new StringBuffer();
			String         line   = in.readLine();
			
			if( line == null )
				throw new IOException( fileName + " is an empty file" );
			
			if( line.charAt( 0 ) != '>' )
				throw new IOException( "First line of " + fileName + " should start with '>'" );
			else
				desc.add(line);
			
			for( line = in.readLine().trim(); line != null; line = in.readLine() )
			{
				if( line.length()>0 && line.charAt( 0 ) == '>' )
				{
					seq.add(buffer.toString());
					buffer = new StringBuffer();
					desc.add(line);
				}
				else
					buffer.append( line.trim() );
			}
			
			if( buffer.length() != 0 )
				seq.add(buffer.toString());
			}
		catch(IOException e)
		{
			System.out.println("Error when reading " + fileName);
			e.printStackTrace();
		}
		
		description = new String[desc.size()];
		sequence = new String[seq.size()];
		
		for (int i=0; i< seq.size(); i++)
		{
			description[i]=(String) desc.get(i);
			sequence[i]=(String) seq.get(i);
		}
		
		int numberOfSequences = 0;
		
		System.out.println();
		System.out.println("1. Sequences");
		System.out.println();
		
		for (int i=0; i< this.size(); i++)
		{
			System.out.println("One sequence read from file with length " + this.getSequence().length() );
			System.out.println("description: \n"+ this.getDescription(i));
			System.out.println("Sequence: \n"+ this.getSequence(i));
			
			numberOfSequences++;
		}
		
		System.out.println("Total number of sequences: " + numberOfSequences);
		System.out.println();
	}
	
	/**
	 * Returns first sequence as a String
	 * @return sequence[0]
	 */
	public String getSequence()
	{
		return sequence[0];
	}
	
	/**
	 * Returns first description as a String
	 * @return description[0]
	 */
	public String getDescription()
	{
		return description[0];
	}
	
	/**
	 * Returns i sequence as a String
	 * @param i sequence index
	 * @return sequence[i]
	 */
	public String getSequence(int i)
	{
		return sequence[i];
	}
	
	/**
	 * Returns i description as a String
	 * @param i description index
	 * @return description[i]
	 */
	public String getDescription(int i)
	{
		return description[i];
	}
	
	/**
	 * Returns sequence array size
	 * @return sequence.length
	 */
	public int size()
	{
		return sequence.length;
	}
}
