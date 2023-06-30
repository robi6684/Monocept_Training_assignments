package com.monocept.tictactoe;

import java.util.Scanner;

public class Game {
	
	public int playGame(Scanner scanner,Player player,Board board, ResultAnalyser result, MarkType mark) {
		System.out.println("Enter row value");
		int row = scanner.nextInt();
		System.out.println("Enter column value");
		int col = scanner.nextInt();
		int flag = player.markCell(board, row, col, mark);
		board.displayBoard();
		if(result.checkWinPlayer1(board.getCell()))
		{
			System.out.println("Player 1 wins");
			System.exit(0);
		}
		if(result.checkWinPlayer2(board.getCell()))
		{
			System.out.println("Player 2 wins");
			System.exit(0);
		}
		
		
		return flag;
	}

}
