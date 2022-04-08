package mru.tsc.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mru.tsc.model.Puzzles;

class PuzzlesTest {

	@Test
	void test() {
		Puzzles classPuzzleTest = new Puzzles("4123456789", "Ultimate", "BG", 150.0, 20, 12, "T");
		String test = classPuzzleTest.toString();
		assertEquals("Puzzle = SN:4123456789, Name:Ultimate, Brand:BG, Price:150.0, Available:20, Age Group:12, puzzleType:T",test);
		
	}

}
