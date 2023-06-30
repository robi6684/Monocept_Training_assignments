package com.monocept.tictactoe;

public class Player {
	
	public int markCell(Board board,int row,int col, MarkType mark) {
		try {
		board.setCellMark(row, col, mark);
		return 0;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return 1;
		}
	}

}
