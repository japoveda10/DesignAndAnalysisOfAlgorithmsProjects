
/**
 * Class that implements MergeSort
 * Based on http://www.java2novice.com/java-sorting-algorithms/merge-sort/
 * @author David Cortes and Julio Poveda
 */
public class MergeSort implements NumbersArraySorter
{
	//Sorted array
	private double[] array;
	
	//Auxiliary array
	private double[] tempArray;
	
	@Override
	public void sort(double[] numbers) 
	{
		array = numbers;
		tempArray = new double[numbers.length];
		
		mergeSort(0, numbers.length-1);
	}
	
	/**
	 * Sorts array from lowerIndex to higherIndex
	 * @param lowerIndex Lower index of the array to sort
	 * @param higherIndex Higher index of the array to sort
	 */
	public void mergeSort(int lowerIndex, int higherIndex)
	{
		if (lowerIndex < higherIndex)
		{
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			
			//Sort first half
			mergeSort(lowerIndex, middle);
			
			//Sort second half
			mergeSort(middle + 1, higherIndex);
			
			//Merge both halves
			mergeSortedArrays(lowerIndex, middle, higherIndex);
		}
	}
	
	/**
	 * Merge sorted halves to finish sorting array
	 * @param lowerIndex Lower index of the array
	 * @param middle Middle of the array
	 * @param higherIndex Higher index of the array
	 */
	public void mergeSortedArrays(int lowerIndex, int middle, int higherIndex)
	{
		for (int i = lowerIndex; i <= higherIndex; i++)
		{
			tempArray[i] = array[i];
		}
		
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		
		while (i <= middle && j <= higherIndex)
		{
			if (tempArray[i] <= tempArray[j])
			{
				array[k] = tempArray[i];
				i++;
			}
			else
			{
				array[k] = tempArray[j];
				j++;
			}
			
			k++;
		}
		
		while (i <= middle)
		{
			array[k] = tempArray[i];
			k++;
			i++;
		}
	}
}
