
public class MergeSort implements NumbersArraySorter
{
	private double[] array;
	private double[] tempArray;
	
	@Override
	public void sort(double[] numbers) 
	{
		array = numbers;
		tempArray = new double[numbers.length];
		
		mergeSort(0, numbers.length-1);
	}
	
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
