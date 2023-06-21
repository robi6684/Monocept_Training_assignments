package com.monocept.tictactoe;

public class Board {
	private Cell[][] cell = new Cell[3][3];
	
	public Board() {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++)
				cell[i][j] = new Cell();
		}
	}
	
	public boolean isBoardFull() {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++)
				if(cell[i][j].getMark() == MarkType.EMPTY)
					return false;
		}
		return true;
	}
	
	public void setCellMark(int row, int col, MarkType mark) throws CellAlreadyMarkedException{
		if(cell[row][col].getMark() != MarkType.EMPTY)
			throw new CellAlreadyMarkedException();
		
		cell[row][col].setMark(mark);
			
	}

}
