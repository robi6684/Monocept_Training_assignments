package com.monocept.unittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardTest {
	
	Board board;
	
	@BeforeEach
	void init() {
		board = new Board();
	}

	@Test
	void testIsBoardFull() {
		Cell[][] cells = board.getCell();
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++)
				cells[i][j].setMark(MarkType.X);
		}
		
		assertTrue(board.isBoardFull());
	}

	@Test
	void testSetCellMark() {
		assertThrows(InvalidLocationException.class,()->board.setCellMark(4, 2, MarkType.O));
		
		Cell[][] cells = board.getCell();
		cells[1][2].setMark(MarkType.X);
		assertThrows(CellAlreadyMarkedException.class,()->board.setCellMark(1, 2, MarkType.O));
		
		board.setCellMark(0, 0, MarkType.X);
		assertEquals(MarkType.X,cells[0][0].getMark());
	}

}
