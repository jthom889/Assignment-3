package mru.tsc.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mru.tsc.model.Animals;

class AnimalsTests {

	@Test
	void test() {
		Animals classAnimalTest = new Animals("2123456789", "Horse", "Anima", 15.0, 16, 5, "Cotton", "S");
		String test = classAnimalTest.toString();
		assertEquals("Animal = SN:2123456789, Name:Horse, Brand:Anima, Price:15.0, Available:16, Age Group:5, Material:Cotton, Size:S",test);

	}
}