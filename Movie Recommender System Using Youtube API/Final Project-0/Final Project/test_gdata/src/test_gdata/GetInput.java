package test_gdata;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

/**
 * This class extracts the 'username' from one file to another and also removes any duplicates if present
 * 
 */
public class GetInput {
	

	public static void main(String[] args) {

		try {
			FileInputStream fstream = new FileInputStream("C:\\Users\\USER\\workspace\\test_gdata\\input.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String username;
			LinkedHashSet<String> output = new LinkedHashSet<String>();
			while ((username = br.readLine()) != null) {
			output.add(username);
			}
			in.close();
			
			Iterator<String> itr = output.iterator();
			String []outputArray = new String[output.size()];
			output.toArray(outputArray);
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\USER\\workspace\\test_gdata\\output.txt"));
			for( int i = 0;i<outputArray.length;i++)
			{
				
				String str = outputArray[i];
				writer.write(str);
				writer.newLine();
				
				}
			writer.flush();
			writer.close();
			}
		catch(Exception e)
		{
			
		}
	
		
	}
		
}
		

