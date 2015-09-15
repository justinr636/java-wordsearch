package WordSearch;

import java.util.ArrayList;

public class WordSearch {

	public static void main(String args[])
	{
		String path = "/Users/Justin/Desktop/fun_projects/java/workspace/WordSearch/src/";
		wordlist d = new wordlist();
		grid g = new grid();

		System.out.print("\nReading Wordlist...");

		//d.readDictionaryFromFile(path + "short_wordlist.txt");
		d.readDictionaryFromFile(path + "wordlist.txt");

		System.out.print("Complete!");
		
		System.out.print("\nSorting Dictionary...");

		//Sort.quickSort(d.getDictionary(), 0, 10);
		//Sort.insertionSort(d.getDictionary());
		Sort.mergeSort(d.getDictionary(), 0, d.getDictionarySize()-1);

		System.out.print("Complete!");

		System.out.print("\nReading Word Search Grid...");

		g.readGridFromFile(path + "input15.txt");

		System.out.print("Complete!\n");
		
		findMatches(d, g);
	}
	
	public static void findMatches(wordlist w, grid g)
	{
		ArrayList<ArrayList<Character>> wordSearchGrid = g.getGrid();
		int maxRowColIndex = wordSearchGrid.size();		// Maximum Row and Column index
		int maxWordLength = w.getMaxWordLength();
		int minWordLength = w.getMinWordLength();

		for (int row = 0; row < maxRowColIndex; row++)
		{
			for (int col = 0; col < maxRowColIndex; col++)
			{
				searchRight(row, col, maxRowColIndex, maxWordLength, minWordLength, wordSearchGrid, w);
				searchDownRight(row, col, maxRowColIndex, maxWordLength, minWordLength, wordSearchGrid, w);
				searchDown(row, col, maxRowColIndex, maxWordLength, minWordLength, wordSearchGrid, w);
				searchDownLeft(row, col, maxRowColIndex, maxWordLength, minWordLength, wordSearchGrid, w);
				searchLeft(row, col, maxRowColIndex, maxWordLength, minWordLength, wordSearchGrid, w);
				searchUpLeft(row, col, maxRowColIndex, maxWordLength, minWordLength, wordSearchGrid, w);
				searchUp(row, col, maxRowColIndex, maxWordLength, minWordLength, wordSearchGrid, w);
				searchUpRight(row, col, maxRowColIndex, maxWordLength, minWordLength, wordSearchGrid, w);
			}
		}
	}

	private static void searchRight(int row, int col, int maxGridIndex, int maxWordLength, int minWordLength, ArrayList<ArrayList<Character>> wordSearchGrid, wordlist w) 
	{
		String possibleWord = wordSearchGrid.get(row).get(col).toString();
		int j = col+1;
		
		while (j < maxGridIndex && possibleWord.length() <= maxWordLength)
		{
			possibleWord += wordSearchGrid.get(row).get(j).toString();
			checkWord(possibleWord, minWordLength, w);

			j++;
		}
	}

	private static void searchLeft(int row, int col, int maxGridIndex, int maxWordLength, int minWordLength, ArrayList<ArrayList<Character>> wordSearchGrid, wordlist w) 
	{
		String possibleWord = wordSearchGrid.get(row).get(col).toString();
		int j = col-1;
		
		while (j >= 0 && possibleWord.length() <= maxWordLength)
		{
			possibleWord += wordSearchGrid.get(row).get(j).toString();
			checkWord(possibleWord, minWordLength, w);

			j--;
		}
	}
	
	private static void searchDown(int row, int col, int maxGridIndex, int maxWordLength, int minWordLength, ArrayList<ArrayList<Character>> wordSearchGrid, wordlist w)
	{
		String possibleWord = wordSearchGrid.get(row).get(col).toString();
		int i = row+1;
		
		while (i < maxGridIndex && possibleWord.length() <= maxWordLength)
		{
			possibleWord += wordSearchGrid.get(i).get(col).toString();
			checkWord(possibleWord, minWordLength, w);
			
			i++;
		}
	}

	private static void searchUp(int row, int col, int maxGridIndex, int maxWordLength, int minWordLength, ArrayList<ArrayList<Character>> wordSearchGrid, wordlist w)
	{
		String possibleWord = wordSearchGrid.get(row).get(col).toString();
		int i = row-1;
		
		while (i >= 0 && possibleWord.length() <= maxWordLength)
		{
			possibleWord += wordSearchGrid.get(i).get(col).toString();
			checkWord(possibleWord, minWordLength, w);
			
			i--;
		}
	}

	private static void searchDownRight(int row, int col, int maxGridIndex, int maxWordLength, int minWordLength, ArrayList<ArrayList<Character>> wordSearchGrid, wordlist w)
	{
		String possibleWord = wordSearchGrid.get(row).get(col).toString();
		int i = row+1;
		int j = col+1;
		
		while (i < maxGridIndex && j < maxGridIndex && possibleWord.length() <= maxWordLength)
		{
			possibleWord += wordSearchGrid.get(i).get(j).toString();
			checkWord(possibleWord, minWordLength, w);
			
			i++;
			j++;
		}
	}

	private static void searchDownLeft(int row, int col, int maxGridIndex, int maxWordLength, int minWordLength, ArrayList<ArrayList<Character>> wordSearchGrid, wordlist w) 
	{
		String possibleWord = wordSearchGrid.get(row).get(col).toString();
		int i = row+1;
		int j = col-1;
		
		while (j >= 0 && i < maxGridIndex && possibleWord.length() <= maxWordLength)
		{
			possibleWord += wordSearchGrid.get(i).get(j).toString();
			checkWord(possibleWord, minWordLength, w);

			j--;
			i++;
		}
	}

	private static void searchUpLeft(int row, int col, int maxGridIndex, int maxWordLength, int minWordLength, ArrayList<ArrayList<Character>> wordSearchGrid, wordlist w)
	{
		String possibleWord = wordSearchGrid.get(row).get(col).toString();
		int i = row-1;
		int j = col-1;
		
		while (i >= 0 && j >= 0 && possibleWord.length() <= maxWordLength)
		{
			possibleWord += wordSearchGrid.get(i).get(j).toString();
			checkWord(possibleWord, minWordLength, w);
			
			i--;
			j--;
		}
	}

	private static void searchUpRight(int row, int col, int maxGridIndex, int maxWordLength, int minWordLength, ArrayList<ArrayList<Character>> wordSearchGrid, wordlist w)
	{
		String possibleWord = wordSearchGrid.get(row).get(col).toString();
		int i = row-1;
		int j = col+1;
		
		while (i >= 0 && j < maxGridIndex && possibleWord.length() <= maxWordLength)
		{
			possibleWord += wordSearchGrid.get(i).get(j).toString();
			checkWord(possibleWord, minWordLength, w);
			
			i--;
			j++;
		}
	}
	
	private static void checkWord(String word, int minWordLength, wordlist w)
	{
		if (word.length() >= minWordLength)
		{
			int match = Sort.binarySearch(w.getDictionary(), 0, w.getDictionarySize()-1, word);
			if (match > -1)
				System.out.println("FOUND MATCH for " + word);
		}
	}
}