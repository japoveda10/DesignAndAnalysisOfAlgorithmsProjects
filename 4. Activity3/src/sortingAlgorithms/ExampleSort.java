package sortingAlgorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Main class of part 1 of Activity 3 project
 * @author David Cortes and Julio Poveda
 */
public class ExampleSort
{
	//-----------------------------------------------------------
	// Constants
	//-----------------------------------------------------------
	/**
	 * Number of elements to sort
	 */
	public final static int ELEMENTS_QUANTITY = 1000000;
	
	//-----------------------------------------------------------
	// Main
	//-----------------------------------------------------------
	/**
	 * Main method for the numbers sorter example. It requires three parameters:
	 * args[0]: Input file with numbers to sort. It must be a text file with one number per line
	 * args[1]: Output file to save the sorted numbers
	 * args[2]: (Optional) fully qualified class name of the algorithm to run. If not provided, the default
	 * algorithm implemented in the static method sort of the class java.util.Arrays is used
	 * @param args Array with the arguments described above 
	 * @throws Exception if the input file does not exist or it can not be read
	 * @throws Exception If the algorithm class can not be loaded
	 */
	public static void main(String[] args) throws Exception
	{
		// Read parameters
		String inFilename = args[0];
		String outFilename = args[1];
		String algorithmClassName = null;
		if (args.length > 2)
			algorithmClassName = args[2];

		// Writes random numbers from 0 to 100 in inFilename
		BufferedWriter writer = null;
		try {
			File archivo = new File(inFilename);
			writer = new BufferedWriter(new FileWriter(archivo));
			Random random = new Random();

			for (int i = 0; i < ELEMENTS_QUANTITY; i++) {
				int number = random.nextInt(100);
				writer.write(number + System.lineSeparator());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Close the writer regardless of what happens...
				writer.close();
			} catch (Exception e) {

			}
		}

		// Read input file
		List<Double> numbersList = new ArrayList<>();
		FileReader reader = null;
		BufferedReader in = null;
		try {
			reader = new FileReader(inFilename);
			in = new BufferedReader(reader);
			String line = in.readLine();
			for (int i = 0; line != null; i++) {
				try {
					numbersList.add(Double.parseDouble(line));
				} catch (Exception e) {
					System.err.println("Can not read number from line " + i + " content: " + line);
					e.printStackTrace();
				}
				line = in.readLine();
			}
		} finally {
			if (in != null)
				in.close();
			if (reader != null)
				reader.close();
		}
		double[] numbers = new double[numbersList.size()];
		for (int i = 0; i < numbers.length; i++)
			numbers[i] = numbersList.get(i);

		// Sort values
		long startTime;
		long endTime;
		if (algorithmClassName == null) {
			startTime = System.currentTimeMillis();
			Arrays.sort(numbers);
			endTime = System.currentTimeMillis();
		} else {
			NumbersArraySorter sortAlgorithm = (NumbersArraySorter) Class.forName(algorithmClassName).newInstance();
			startTime = System.currentTimeMillis();
			sortAlgorithm.sort(numbers);
			endTime = System.currentTimeMillis();
		}

		// Output answer
		PrintStream out = null;
		try {
			out = new PrintStream(outFilename);
			for (int i = 0; i < numbers.length; i++) {
				if (i > 0 && (numbers[i] < numbers[i - 1]))
					throw new RuntimeException("ERROR: Disorder detected at position " + i + " values: "
							+ numbers[i - 1] + "," + numbers[i]);
				out.println(numbers[i]);
			}
		} finally {
			if (out != null)
				out.close();
		}
		System.out.println("Numbers sorted. Total time(milliseconds): " + (endTime - startTime));
	}
}
