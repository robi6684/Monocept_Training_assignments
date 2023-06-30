package com.monocept.unittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CellTest {

	Cell cell;
	@BeforeEach
	void init() {
		cell = new Cell();
	}
	
	
	@Test
	void testIsEmpty() {
		//cell.setMark(MarkType.X);
		assertTrue(cell.isEmpty());
	}

	@Test
	void testGetMark() {
		
		assertEquals(MarkType.EMPTY,cell.getMark());
	}

	@Test
	void testSetMark() {
		cell.setMark(MarkType.X);
		assertEquals(MarkType.X,cell.getMark());
	}

}
