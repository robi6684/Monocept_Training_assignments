package com.monocept.controlstructures;

import java.util.Scanner;

public class TreasureHunt {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("!!! Welcome to Treasure Island  !!!");
		System.out.println("Your mission is to find the treasure");
		System.out.println();
		
		System.out.println("Choose Left or Right");
		String choice = scanner.next();
		
		if(!choice.equals("Left"))
		{
			System.out.println("Fall into the hole");
			System.out.println("Game Over");
			System.exit(0);
		}
		
		System.out.println("Choose Swim or Wait");
		choice = scanner.next();
		
		if(!choice.equals("Wait"))
		{
			System.out.println("Attacked by trouts");
			System.out.println("Game Over");
			System.exit(0);
		}
		
		System.out.println("Which Door? - Red, Blue or Yellow");
		choice = scanner.next();
		
		if(choice.equals("Red"))
		{
			System.out.println("Burned by fire");
			System.out.println("Game Over");
		}
		
		else if(choice.equals("Blue"))
		{
			System.out.println("Eaten by beasts");
			System.out.println("Game Over");
		}
		
		else if(choice.equals("Yellow"))
		{
			System.out.println("You Win!");
		}
		
		else
			System.out.println("Game Over");
		
		scanner.close();

	}

}
