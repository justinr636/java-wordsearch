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
	
	public static void merge(ArrayList<String> arr, ArrayList<String> tempArr, int low, int mid, int high)
	// Merge function for mergeSort
	{
		for (int i = low; i <= high; i++)
			tempArr.set(i, arr.get(i));
		
		int i = low, j = mid+1, k = low;
		
		while (i <= mid && j <= high)
		{
			if (tempArr.get(i).compareToIgnoreCase(tempArr.get(j)) <= 0)
			{
				arr.set(k, tempArr.get(i));
				i++;
			}
			else
			{
				arr.set(k, tempArr.get(j));
				j++;
			}
			k++;
		}
		while (i <= mid)
		{
			arr.set(k, tempArr.get(i));
			k++;
			i++;
		}
	}
	
	public static void mergeSort(ArrayList<String> arr, int low, int high)
	// mergeSort for ArrayLists of Strings
	{
		if (low < high) 
		{
			ArrayList<String> tempArr = new ArrayList<String>(arr.size());
			tempArr.addAll(arr);

			int mid = low + (high - low) / 2;

			mergeSort(arr, low, mid);
			mergeSort(arr, mid+1, high);
			merge(arr, tempArr, low, mid, high);
		}
	}
	
	public static int binarySearch(ArrayList<String> arr, int first, int last, String key)
	// binarySearch for ArrayLists of Strings that returns the index of the match
	{
		if (last < first)
			return -1;
		else
		{
			int mid = (first + last) / 2;
			
			if (arr.get(mid).compareToIgnoreCase(key) > 0)
				return binarySearch(arr, first, mid-1, key);
			else if (arr.get(mid).compareToIgnoreCase(key) < 0)
				return binarySearch(arr, mid+1, last, key);
			else
				return mid;
		}
	}
}
