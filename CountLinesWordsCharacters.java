package com.monocept.filehandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountLinesWordsCharacters {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter location of file");
		String fileLocation = scanner.nextLine();
		File file = new File(fileLocation);
		Scanner scanner1 = new Scanner(new FileInputStream(file));
		Scanner scanner2 = new Scanner(new FileInputStream(file));
		
		System.out.println("Characters count = " + file.length());
		
		int count_words = 0;
		
		while(scanner1.hasNext())
		{
			scanner1.next();
			count_words++;
		}
		
		System.out.println("Words Count = " + count_words);
		
		
		int count_lines = 0;
		
		while(scanner2.hasNextLine())
		{
			scanner2.nextLine();
			count_lines++;
		}
		
		System.out.println("Lines Count = " + count_lines);
	
		scanner.close();

	}

}
