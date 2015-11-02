package test_gdata;
/*This file extracts the bag of keywords we have to a hashset
 * @author : Janani Neelamekam
 * @author : Shravya Narayan Sharma
 * */

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class ExtractKeyword {
 public	LinkedHashSet<String> finalWords = new LinkedHashSet<String>();

	public void extractWord(ArrayList<String> list) throws IOException {
		
		FileInputStream fstream = new FileInputStream(
				"C:\\Users\\USER\\workspace\\test_gdata\\bagOfWords.txt");
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String input;
		while ((input = br.readLine()) != null) {
			for (String s : list) {
				String a[] = s.split(" ");
				for (int i = 0; i < a.length; i++) {
					if (a[i].equalsIgnoreCase(input)) {
						finalWords.add(input);
						break;
					} 
				}
			}

		}

	}

}
