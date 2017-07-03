
/**
 * Class that implements QuickSort
 * @author David Cortes and Julio Poveda
 */
public class QuickSort implements NumbersArraySorter
{
	private double array[];
    
	@Override
	public void sort(double[] numbers)
	{
		if (numbers.length == 0)
		{
            return;
        }
		
        array = numbers;
        quickSort(0, numbers.length - 1);
	}

	public void quickSort(int lowerIndex, int higherIndex)
	{
		int i = lowerIndex;
		int j = higherIndex;
		
		//Pivot is defined as the middle element index
		int pivot = (int) array[lowerIndex + (higherIndex - lowerIndex) / 2];
		
		while (i <= j)
		{
			while (array[i] < pivot)
			{
				i++;
			}

			while (array[j] > pivot)
			{
				j--;
			}

			//If there is an element in the left half of the array greater than the pivot
			// and an element in the right half of the array less than the pivot we proceed
			// to swap them
			if (i <= j)
			{
				//Swap elements of the array
				double temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				
				i++;
				j--;
			}
		}
		
		if (lowerIndex < j)
		{
			quickSort(lowerIndex, j);
		}
			
		if (i < higherIndex)
		{
			quickSort(i, higherIndex);
		}
	}
}
