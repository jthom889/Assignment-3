package mru.tsc.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mru.tsc.model.Figures;

class FiguresTest {

	@Test
	void test() {
		Figures classFigureTest = new Figures("0123456789", "Actina", "BG", 12.0, 100, 7, "Action");
		String test = classFigureTest.toString();
		assertEquals("Figure = SN:0123456789, Name:Victor Alli, Brand:BG, Price:12.0, Available:100, Age Group:7, classification:A",test);
	}

}
