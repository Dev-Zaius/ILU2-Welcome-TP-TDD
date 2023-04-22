package ilu2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WelcomeTest {
	@Test
	void testExigence1() {
		// Ex_1
		assertEquals(Welcome.welcome("Bob"),"Hello, Bob");
		assertEquals(Welcome.welcome("bob"),"Hello, Bob");
		assertEquals(Welcome.welcome("Max"),"Hello, Max");
		assertEquals(Welcome.welcome("max"),"Hello, Max");
		assertEquals(Welcome.welcome("Theo"),"Hello, Theo");
		assertEquals(Welcome.welcome("theo"),"Hello, Theo");
	}
	@Test
	void testExigence2() {
		//Ex_2
		assertEquals(Welcome.welcome("   "),"Hello, my friend");
		assertEquals(Welcome.welcome(""),"Hello, my friend");
		assertEquals(Welcome.welcome("    bob "),"Hello, Bob");
		assertEquals(Welcome.welcome(" Bob    "),"Hello, Bob");
	}
}