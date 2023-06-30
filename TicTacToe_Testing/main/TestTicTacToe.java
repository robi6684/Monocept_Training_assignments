package com.monocept.tictactoe;

import java.util.Scanner;

public class TestTicTacToe {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Player player1 = new Player();
		Player player2 = new Player();
		Board board = new Board();
		ResultAnalyser result = new ResultAnalyser();
		Game game = new Game();
		
		int i = 0;
		
		while(!board.isBoardFull()) {
			
			if(i%2 == 0)
			{
				System.out.println("Player1:");
				if(game.playGame(scanner,player1,board,result,MarkType.O) == 1)
					continue;
			}
			else {
				System.out.println("Player2:");
				if(game.playGame(scanner,player2,board,result,MarkType.X) == 1)
					continue;
			}
			
			i++;
				
		}
		
		System.out.println("No one won! Game Draw");
		
		scanner.close();
	
	}

}
