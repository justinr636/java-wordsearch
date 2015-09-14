package WordSearch;

import java.io.FileNotFoundException;		// Throw Error
import java.util.*;					// Scanner, ArrayList
import java.io.File;				// File

public class wordlist {

	// Properties
	private static ArrayList<String> dictionary;
	private int maxWordLength;
	
	// Constructors
	public wordlist()
	{
		this.dictionary = new ArrayList<String>();
		this.maxWordLength = 0;
	}
	
	// Methods
	public void readDictionaryFromFile(String filename)
	{
		try 
		{
			Scanner s = new Scanner(new File(filename));
			
			dictionary.clear();
			
			while (s.hasNext()) {
				String word = s.next();

				dictionary.add(word);
				
				if (word.length() > maxWordLength)
					maxWordLength = word.length();
			}
			
			s.close();
		}
		catch (FileNotFoundException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	public ArrayList<String> getDictionary() 
	{
		return this.dictionary;
	}
	
	public void printDictionary()
	// Prints out the entire word list line by line
	{
		for (int i = 0; i < dictionary.size(); i++)
		{
			System.out.println(dictionary.get(i));
		}
	}
	
	public int partition(int left, int right)
	{
		int i = left, j = right;
		String temp;
		String pivot = dictionary.get((left+right) / 2);
		
		while (i <= j)
		{
			while (dictionary.get(i).compareToIgnoreCase(pivot) < 0)
				i++;
			while (dictionary.get(j).compareToIgnoreCase(pivot) > 0)
				j--;
			
			if (i <= j) {
				temp = dictionary.get(i);
				dictionary.set(i, dictionary.get(j));
				dictionary.set(j, temp);
				i++;
				j--;
			}
		}
		
		return i;
	}

	public void quickSort(int left, int right) {
		int index = partition(left, right);
		if (left < index-1)
			quickSort(left, index-1);
		if (index < right)
			quickSort(index, right);
	}
}