package WordSearch;

import java.util.ArrayList;

public class WordSearch {

	public static void main(String args[])
	{
		String path = "/Users/Justin/Desktop/fun_projects/java/workspace/WordSearch/src/";
		wordlist d = new wordlist();
		d.readDictionaryFromFile(path + "short_wordlist.txt");
		
		System.out.println("Dictionary Before Sorting:");
		d.printDictionary();
		
		System.out.println("\nDictionary After Sorting:");

		//Sort.quickSort(d.getDictionary(), 0, 10);
		//Sort.insertionSort(d.getDictionary());
		Sort.mergeSort(d.getDictionary(), 0, 10);

		d.printDictionary();
		
		System.out.println(Sort.binarySearch(d.getDictionary(), 0, 10, "unbelievably"));
		
		//grid g = new grid();
		//g.readGridFromFile(path + "input15.txt");
		//g.printGrid();
	}

}