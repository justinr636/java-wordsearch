package WordSearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class grid {
	// Properties
	ArrayList<ArrayList<Character>> map;
	
	// Constructors
	public grid()
	{
		map = new ArrayList<ArrayList<Character>>();
	}
	
	// Methods
	public void readGridFromFile(String filename)
	{
		String line;

		try (
			//Scanner s = new Scanner(new File(filename));
			InputStream fis = new FileInputStream(filename);
			InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
			BufferedReader br = new BufferedReader(isr);
		) {

			map.clear();
			
			while ((line = br.readLine()) != null) 
			{
				ArrayList<Character> row = new ArrayList<Character>();
				
				for (int i = 0; i < line.length(); i++)
				{
					char letter = line.charAt(i);

					if (letter == ' ')
					{
						continue;
					}
					else
					{
						row.add(letter);
					}
				}
				
				map.add(row);
			}
			
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printGrid()
	// Prints Grid out to console
	{
		for (int i = 0; i < map.size(); i++)
		{
			String line = "";
			ArrayList<Character> row = map.get(i);

			for (int j = 0; j < row.size(); j++)
			{
				line += row.get(j);
				line += " ";
			}
			
			System.out.println(line);
		}
	}
}