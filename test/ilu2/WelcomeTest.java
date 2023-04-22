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
	}
	@Test
	void testExigence3() {
		//Ex_3
		assertEquals(Welcome.welcome("MAX"),"HELLO, MAX !");
		assertEquals(Welcome.welcome("max"),"Hello, Max");

		assertEquals(Welcome.welcome("Theo"),"Hello, Theo");
		assertEquals(Welcome.welcome("THEO"),"HELLO, THEO !");

	}
	@Test
	void testExigence4() {
		// Ex_4 : J'avais commencé à gérer les espaces inutiles dans mes tests
		// précédents avant de me rendre compte que c'était l'exigence 8. J'arrêtes de les 
		// gérer à partir d'ici les espaces
		assertEquals(Welcome.welcome("amy,bob"),"Hello, Amy, Bob");
		assertEquals(Welcome.welcome("amy,Léo"),"Hello, Amy, Léo");
		assertEquals(Welcome.welcome("léo,Amy"),"Hello, Léo, Amy");
	}
	@Test
	void testExigence5() {
		assertEquals(Welcome.welcome("amy,bob,Jerry"),"Hello, Amy, Bob, Jerry");
		assertEquals(Welcome.welcome("amy,bob,Jerry,paul,lucas"),"Hello, Amy, Bob, Jerry, Paul, Lucas");
		assertEquals(Welcome.welcome("amy,Jerry,rené,lucas"),"Hello, Amy, Jerry, René, Lucas");
	}
	@Test
	void testExigence6() {
		assertEquals(Welcome.welcome("Amy,BOB,Jerry"),"Hello, Amy, Jerry. AND HELLO, BOB !");
		assertEquals(Welcome.welcome("AMY,BOB,Jerry,joe"),"Hello, Jerry, Joe. AND HELLO, AMY, BOB !");
		assertEquals(Welcome.welcome("AMY,jerry,joe,LUCAS"),"Hello, Jerry, Joe. AND HELLO, AMY, LUCAS !");
		// Mais aussi
		assertEquals(Welcome.welcome("AMY,JERRY,JOE,LUCAS"),"HELLO, AMY, JERRY, JOE, LUCAS !");
		assertEquals(Welcome.welcome("AMY,JERRY"),"HELLO, AMY, JERRY !");
	}
}