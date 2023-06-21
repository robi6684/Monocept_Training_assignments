package com.monocept.tictactoe;

public class TestTicTacToe {

	public static void main(String[] args) {
		
		Board board = new Board();
		
		System.out.println(board.isBoardFull());
		try {
		board.setCellMark(0, 0, MarkType.X);
		board.setCellMark(0, 1, MarkType.X);
		board.setCellMark(0, 2, MarkType.O);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
