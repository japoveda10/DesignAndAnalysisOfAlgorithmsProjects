package sortingAlgorithms;

/**
 * Class that implements BubbleSort
 * @author David Cortes and Julio Poveda
 */
public class BubbleSort implements NumbersArraySorter 
{
	//-----------------------------------------------------------
	// Methods
	//-----------------------------------------------------------
	@Override
	public void sort(double[] numbers) 
	{
		int n = numbers.length;
		
		//Inv: i is the number of orderer elements
		for(int i = 0; i<n-2; i++)
		{
			for(int j=n-1; j>i; j--)
			{
				if(numbers[j-1]>numbers[j])
				{
					int number = (int) numbers[j-1];
					numbers[j-1] = numbers[j];
					numbers[j] = number;
				}
			}	
		}				
	}
}

