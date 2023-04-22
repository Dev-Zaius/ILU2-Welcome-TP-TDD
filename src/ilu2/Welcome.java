package ilu2;

public class Welcome {
	public static String welcome(String input) {
		StringBuilder s = new StringBuilder();
		s.append("Hello, ");
		char premierChar = Character.toUpperCase(input.charAt(0));
		String finNom = input.substring(1);
		s.append(premierChar);
		s.append(finNom);
		return s.toString();
	}
}