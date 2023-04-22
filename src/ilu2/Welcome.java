package ilu2;

public class Welcome {
	public static String welcome(String input) {
		String nom = input.trim();
		StringBuilder s = new StringBuilder();
		s.append("Hello, ");
		if (nom.length() > 0) {
			char premierChar = Character.toUpperCase(nom.charAt(0));
			String finNom = nom.substring(1);
			s.append(premierChar);
			s.append(finNom);
		} else {
			s.append("my friend");
		}
		return s.toString();
	}
}