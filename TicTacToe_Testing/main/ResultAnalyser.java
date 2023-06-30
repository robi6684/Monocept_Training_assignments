package com.monocept.tictactoe;

public class ResultAnalyser {
	
	public boolean checkWinPlayer1(Cell[][] cell) {
		if(cell[0][0].getMark() == MarkType.O && cell[1][1].getMark() == MarkType.O 
				&& cell[2][2].getMark() == MarkType.O) return true;
		else if(cell[0][2].getMark() == MarkType.O && cell[1][1].getMark() == MarkType.O 
				&& cell[2][0].getMark() == MarkType.O) return true;
		else if(cell[0][0].getMark() == MarkType.O && cell[1][0].getMark() == MarkType.O 
				&& cell[2][0].getMark() == MarkType.O) return true;
		else if(cell[0][1].getMark() == MarkType.O && cell[1][1].getMark() == MarkType.O 
				&& cell[2][1].getMark() == MarkType.O) return true;
		else if(cell[0][2].getMark() == MarkType.O && cell[1][2].getMark() == MarkType.O 
				&& cell[2][2].getMark() == MarkType.O) return true;
		else if(cell[0][0].getMark() == MarkType.O && cell[0][1].getMark() == MarkType.O 
				&& cell[0][2].getMark() == MarkType.O) return true;
		else if(cell[1][0].getMark() == MarkType.O && cell[1][1].getMark() == MarkType.O 
				&& cell[1][2].getMark() == MarkType.O) return true;
		else if(cell[2][0].getMark() == MarkType.O && cell[2][1].getMark() == MarkType.O 
				&& cell[2][2].getMark() == MarkType.O) return true;
		
		return false;		
	}
	
	public boolean checkWinPlayer2(Cell[][] cell) {
		if(cell[0][0].getMark() == MarkType.X && cell[1][1].getMark() == MarkType.X 
				&& cell[2][2].getMark() == MarkType.X) return true;
		else if(cell[0][2].getMark() == MarkType.X && cell[1][1].getMark() == MarkType.X 
				&& cell[2][0].getMark() == MarkType.X) return true;
		else if(cell[0][0].getMark() == MarkType.X && cell[1][0].getMark() == MarkType.X
				&& cell[2][0].getMark() == MarkType.X) return true;
		else if(cell[0][1].getMark() == MarkType.X && cell[1][1].getMark() == MarkType.X
				&& cell[2][1].getMark() == MarkType.X) return true;
		else if(cell[0][2].getMark() == MarkType.X && cell[1][2].getMark() == MarkType.X 
				&& cell[2][2].getMark() == MarkType.X) return true;
		else if(cell[0][0].getMark() == MarkType.X && cell[0][1].getMark() == MarkType.X
				&& cell[0][2].getMark() == MarkType.X) return true;
		else if(cell[1][0].getMark() == MarkType.X && cell[1][1].getMark() == MarkType.X 
				&& cell[1][2].getMark() == MarkType.X) return true;
		else if(cell[2][0].getMark() == MarkType.X && cell[2][1].getMark() == MarkType.X 
				&& cell[2][2].getMark() == MarkType.X) return true;
		
		return false;		
	}

}
