package com.monocept.tictactoe;

public class Board {
	private Cell[][] cell = new Cell[3][3];
	
	public Board() {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++)
				cell[i][j] = new Cell();
		}
	}
	
	
	
	public Cell[][] getCell() {
		return cell;
	}



	public void setCell(Cell[][] cell) {
		this.cell = cell;
	}



	public boolean isBoardFull() {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++)
				if(cell[i][j].getMark() == MarkType.EMPTY)
					return false;
		}
		return true;
	}
	
	public void setCellMark(int row, int col, MarkType mark){
		if(!((row >=0 && row <=2) && (col >= 0 && col <= 2)))
			throw new InvalidLocationException();
		if(cell[row][col].getMark() != MarkType.EMPTY)
			throw new CellAlreadyMarkedException();
		
		cell[row][col].setMark(mark);
			
	}
	
	public void displayBoard() {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++)
			{
				if(cell[i][j].getMark() == MarkType.EMPTY)
					System.out.print("_" + " ");
				else
					System.out.print(cell[i][j].getMark() + " ");
			}
			System.out.println();
		}
	
	}
	

}
