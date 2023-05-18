package com.monocept.iterations;

import java.util.Scanner;

public class NumberGuessingGame {
	
	public static void numberGuessingGame()
	{
		Scanner scanner = new Scanner(System.in);
		
		int min = 1, max = 100;
		int random_number = (int)(Math.random()*(max-min+1)+min); 
		
		int guess_count = 1;
		
		System.out.println("Choose a number between 1 and 100 in 10 attempts");
		
		while(guess_count <= 10)
		{
			System.out.println("Please guess a number");
			int guess_number = scanner.nextInt();
			
			if(guess_number == random_number)
			{
				System.out.println("Congratulations, You Win!");
				System.out.println("You took " + guess_count + " attempts");
				System.out.println("Press 1 to play again or 2 to exit");
				int choice = scanner.nextInt();
				
				if(choice == 1)
					numberGuessingGame();
				else
					System.exit(0);
			}
			
			else if(guess_number < random_number)
			{
				System.out.println("!!! Sorry, Too Low !!!");
			}
			
			else if(guess_number > random_number)
			{
				System.out.println("!!! Sorry, Too High !!!");
			}
			
			guess_count++;
				
		}
		
		System.out.println("Oops, You Lost !!!");
		System.out.println("You have reached maximum number of attempts");
		System.out.println("Press 1 to play again or 2 to exit");
		int choice = scanner.nextInt();
		
		if(choice == 1)
			numberGuessingGame();
		else
			System.exit(0);
		
		scanner.close();
	}

	public static void main(String[] args) {
		
		numberGuessingGame();
		

	}

}
