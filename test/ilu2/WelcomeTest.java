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
		//assertEquals(Welcome.welcome("amy,bob"),"Hello, Amy, Bob");
		//assertEquals(Welcome.welcome("amy,Léo"),"Hello, Amy, Léo");
		//assertEquals(Welcome.welcome("léo,Amy"),"Hello, Léo, Amy");
	}
	@Test
	void testExigence5() {
		//assertEquals(Welcome.welcome("amy,bob,Jerry"),"Hello, Amy, Bob, Jerry");
		//assertEquals(Welcome.welcome("amy,bob,Jerry,paul,lucas"),"Hello, Amy, Bob, Jerry, Paul, Lucas");
		//assertEquals(Welcome.welcome("amy,Jerry,rené,lucas"),"Hello, Amy, Jerry, René, Lucas");
	}
	@Test
	void testExigence6() {
		//assertEquals(Welcome.welcome("Amy,BOB,Jerry"),"Hello, Amy, Jerry. AND HELLO, BOB !");
		//assertEquals(Welcome.welcome("AMY,BOB,Jerry,joe"),"Hello, Jerry, Joe. AND HELLO, AMY, BOB !");
		//assertEquals(Welcome.welcome("AMY,jerry,joe,LUCAS"),"Hello, Jerry, Joe. AND HELLO, AMY, LUCAS !");
		// Mais aussi
		//assertEquals(Welcome.welcome("AMY,JERRY,JOE,LUCAS"),"HELLO, AMY, JERRY, JOE, LUCAS !");
		//assertEquals(Welcome.welcome("AMY,JERRY"),"HELLO, AMY, JERRY !");
	}
	@Test 
	void testExigence7(){
		// L'intersection entre les tests qui passent pour les exigences 4,5,6 et 7 étant nulle
		// j'ai décidé de commenter les exigences des tests 4,5,6 et 7
		assertEquals(Welcome.welcome("amy,bob"),"Hello, Amy and Bob");
		assertEquals(Welcome.welcome("amy,GEORGES"),"Hello, Amy. AND HELLO, GEORGES !");
		assertEquals(Welcome.welcome("Amy,BOB,Jerry"),"Hello, Amy and Jerry. AND HELLO, BOB !");
		assertEquals(Welcome.welcome("AMY,BOB,Jerry,joe"),"Hello, Jerry and Joe. AND HELLO, AMY AND BOB !");
		assertEquals(Welcome.welcome("AMY,jerry,joe,LUCAS"),"Hello, Jerry and Joe. AND HELLO, AMY AND LUCAS !");
		assertEquals(Welcome.welcome("AMY,JERRY,JOE,LUCAS"),"HELLO, AMY, JERRY, JOE AND LUCAS !");
		assertEquals(Welcome.welcome("AMY,JERRY"),"HELLO, AMY AND JERRY !");
		assertEquals(Welcome.welcome("AMY,JERRY,Perry,MAX,LEO"),"Hello, Perry. AND HELLO, AMY, JERRY, MAX AND LEO !");
	}
	@Test 
	void testExigence8(){
		// Espaces inutiles
		assertEquals(Welcome.welcome("   amy  , bob   "),"Hello, Amy and Bob");
		assertEquals(Welcome.welcome("amy,  GEORGES   "),"Hello, Amy. AND HELLO, GEORGES !");
		assertEquals(Welcome.welcome(" Amy   ,    BOB  ,  Jerry     "),"Hello, Amy and Jerry. AND HELLO, BOB !");
		assertEquals(Welcome.welcome("   AMY  ,BOB,Jerry,    joe "),"Hello, Jerry and Joe. AND HELLO, AMY AND BOB !");
		assertEquals(Welcome.welcome("      AMY,     jerry,     joe,LUCAS      "),"Hello, Jerry and Joe. AND HELLO, AMY AND LUCAS !");
		assertEquals(Welcome.welcome("     AMY ,    JERRY,JOE,LUCAS"),"HELLO, AMY, JERRY, JOE AND LUCAS !");
		assertEquals(Welcome.welcome("AMY  ,       JERRY"),"HELLO, AMY AND JERRY !");
		assertEquals(Welcome.welcome(" AMY ,  JERRY  , Perry , MAX ,  LEO"),"Hello, Perry. AND HELLO, AMY, JERRY, MAX AND LEO !");
	}
	@Test 
	void testExigence9(){
		// Espaces inutiles
		// Je pars du principe que si un nom est d'abord appelé ou d'abord crié alors il sera regroupé par sa première appelation 
		assertEquals(Welcome.welcome("   amy  , bob  , bob,bob "),"Hello, Amy and Bob (x3)");
		assertEquals(Welcome.welcome("amy,  GEORGES , amy,GEORGES,Georges,georges  "),"Hello, Amy (x2). AND HELLO, GEORGES (x4) !");
		assertEquals(Welcome.welcome(" Amy ,AMY,bob , BOB  ,Jerry,jerry   "),"Hello, Amy (x2), Bob (x2) and Jerry (x2)");
		assertEquals(Welcome.welcome("   amy  ,Bob,Jerry,Amy,Jerry ,joe "),"Hello, Amy (x2), Bob, Jerry (x2) and Joe");
		assertEquals(Welcome.welcome("      AMY,     jerry,     joe,lucas,amy,amy,LUCAS      "),"Hello, Jerry, Joe and Lucas (x2). AND HELLO, AMY (x3) !");
	}
}