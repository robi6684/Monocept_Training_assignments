package com.monocept.array;

public class BookCricketGame {

	public static void main(String[] args) {
		
		
		System.out.println("Player1 turns");
		
		int page_number = (int)(Math.random()*300)+1;
		System.out.print(page_number + " ");
		
		int player1_score = 0;
		int player1_turn = 0;
		int player2_score = 0;
		int player2_turn = 0;
		
		
		while((page_number % 7) != 0)
		{
			
			player1_score += (page_number%7);
			player1_turn++;
			page_number = (int)(Math.random()*300)+1;
			System.out.print(page_number + " ");
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Player2 turns");
		
		page_number = (int)(Math.random()*300)+1;
		System.out.print(page_number + " ");
		
		while((page_number % 7) != 0)
		{
			
			player2_score += (page_number%7);
			player2_turn++;
			page_number = (int)(Math.random()*300)+1;
			System.out.print(page_number + " ");
		}
		
		System.out.println();
		System.out.println();
		
		if(player1_score > player2_score)
		{
			System.out.println("Player1 score = " + player1_score);
			System.out.println("Player2 score = " + player2_score);
			System.out.println("Player1 wins");
		}
		
		else if(player1_score < player2_score)
		{
			System.out.println("Player1 score = " + player1_score);
			System.out.println("Player2 score = " + player2_score);
			System.out.println("Player2 wins");
		}
		else
		{
			if(player1_turn <= player2_turn)
			{
				System.out.println("Player1 score = " + player1_score);
				System.out.println("Player2 score = " + player2_score);
				System.out.println("Player1 wins");
			}
			else
			{
				System.out.println("Player1 score = " + player1_score);
				System.out.println("Player2 score = " + player2_score);
				System.out.println("Player2 wins");
			}
				
		}
		
		
		

	}

}
