
public class MergeSort implements NumbersArraySorter
{
	@Override
	public void sort(double[] numbers) 
	{
		mergeSort(numbers, 0, numbers.length-1);
	}
	
	public void mergeSort(double[] array, int first, int last)
	{		
		if(first == last) return;
		
		int m = (first + last) / 2;
		
		mergeSort(array, first, m);
		mergeSort(array, m+1, last);
		mergeSortedArrays(array, first, m, last);
	}
	
	public void mergeSortedArrays(double[] pArray, int firstG1, int lastG1, int lastG2)
	{
		double[] mergeSet = new double[pArray.length];
		
		int i = firstG1;
		int j = lastG1+1;
		
		int counter = 0;
		
		while(i<=lastG1 && j<=lastG2)
		{			
			if (pArray[i]<pArray[j]) 
			{
				mergeSet[counter] = pArray[i];
				i++;
			}
		
			if (pArray[i]>=pArray[j]) 
			{ 
				mergeSet[counter] = pArray[i];
				j++;
			}
			
			counter++;
		}
		
		for(;i<=lastG1;i++)
		{
			mergeSet[counter] = pArray[i];
			counter++;
		}
		
		for(;j<=lastG2;j++)
		{
			mergeSet[counter] = pArray[j];
			counter++;
		}
	}
}
