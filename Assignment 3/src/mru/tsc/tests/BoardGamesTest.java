package mru.tsc.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mru.tsc.model.BoardGames;

class BoardGamesTest {

	@Test
	void test() {
		BoardGames classBoardGamecTest = new BoardGames("9123456789", "BG", "BGgames", 120.0, 4, 18, "2-7", "Victor Alli");
		String test = classBoardGamecTest.toString();
		assertEquals("BoardGame = SN:9123456789, Name:BG, Brand:BGgames, Price:120.0, Available:4, Age Group:18, players:2-7, designers:Victor Alli",test);

	}
}