package WordSearch;

import java.util.ArrayList;

public class Sort {

	public static int partition(ArrayList<String> arr, int left, int right)
	// Partition function for quickSort
	{
		int i = left, j = right;
		String temp;
		String pivot = arr.get((left+right) / 2);
		
		while (i <= j)
		{
			while (arr.get(i).compareToIgnoreCase(pivot) < 0)
				i++;
			while (arr.get(j).compareToIgnoreCase(pivot) > 0)
				j--;
			
			if (i <= j) {
				temp = arr.get(i);
				arr.set(i, arr.get(j));
				arr.set(j, temp);
				i++;
				j--;
			}
		}
		
		return i;
	}

	public static void quickSort(ArrayList<String> arr, int left, int right) 
	// quickSort for ArrayLists of Strings
	{
		int index = partition(arr, left, right);

		if (left < index-1)
			quickSort(arr, left, index-1);
		if (index < right)
			quickSort(arr, index, right);
	}
	
	public static void insertionSort(ArrayList<String> arr) 
	// insertionSort for ArrayLists of Strings
	{
		int i, j;
		String temp;
		
		for (i = 1; i < arr.size(); i++)
		{
			j = i;
			temp = arr.get(j);

			while (j > 0 && arr.get(j-1).compareToIgnoreCase(temp) > 0)
			{
				arr.set(j, arr.get(j-1));
				arr.set(j-1, temp);
				j--;
			}
		}
	}
}
