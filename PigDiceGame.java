package com.monocept.array;

import java.util.Scanner;

public class PigDiceGame {
	
	
	public static int pigDiceGame(int turns,int total_points)
	{
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		int turn_points = 0;
		
		System.out.println("");
		System.out.println("!!----TURN " + turns +"----!!");
		
		while(true)
		{
			System.out.println("Roll or Hold? (r/h)");
			char choice = scanner.next().charAt(0);
			
			
			if(choice == 'r')
			{
				int die_number = (int) (Math.random()*6)+1;
				System.out.println("Die : " + die_number);
				
				if(die_number == 1)
				{
					turn_points = 0;
					System.out.println("Turn Over! No Score");
					break;
				}
					
				turn_points += die_number;
				
			}
			else
			{
				System.out.println("Score for turn : " + turn_points);
				System.out.println("Total Score : " + (total_points + turn_points));
				break;
			}
			
		}
		
		
		return turn_points;
		
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to PIG Dice Game");
		
		int total_points = 0;
		int turns = 0;
		
		while(total_points < 20)
		{
			turns++;
			
			int value = pigDiceGame(turns,total_points);
			total_points += value;

		}
		System.out.println("");
		System.out.println("You finished in " + turns + " turns");
		System.out.println("! Game Over !");

	}

}
