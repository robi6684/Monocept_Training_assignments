package com.monocept.array;

import java.util.Scanner;

public class PigDiceGame2 {
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to PIG Dice Game");
		int totalScore = 0;
		int turns = 0;
		
		playGame(totalScore,turns,0);
		
	}

	private static void playGame(int totalScore, int turns, int turnScore) {
		Scanner scanner = new Scanner(System.in);
		turns++;
		turnScore = 0;
		System.out.println("");
		System.out.println("!!----TURN " + turns + "----!!");
		while(totalScore < 20) {
			
			
			System.out.println("Roll or Hold? (r/h)");
			char choice = scanner.next().charAt(0);
			
			int value = checkChoice(choice,turns,totalScore,turnScore);
			turnScore += value;
			totalScore += value;
		}
		
		scanner.close();
		System.out.println("Total Score : " + totalScore);
		System.out.println("You finished in " + turns + " turns");
		System.out.println("! Game Over !");
		System.exit(0);
		
	}

	private static int checkChoice(char choice, int turns, int totalScore,int turnScore) {
		int score = 0;
		if(choice == 'r') {
			int dieNumber = (int) (Math.random()*6)+1;
			System.out.println("Die : " + dieNumber);
			checkDieNumber(dieNumber,turns,totalScore,turnScore);
			score += dieNumber;
			return score;
		}
		
		if(choice == 'h') {
			System.out.println("Score for turn : " + turnScore);
			System.out.println("Total Score : " + (totalScore));
			playGame(totalScore,turns,turnScore);
		}
		return 0;
	}

	private static void checkDieNumber(int dieNumber, int turns, int totalScore, int turnScore) {
		
		if(dieNumber == 1) {
			System.out.println("Turn Over! No Score");
			playGame(totalScore-turnScore,turns,0);
		}
		
	}

	
	
}