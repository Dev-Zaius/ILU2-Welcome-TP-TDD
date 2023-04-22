package ilu2;

public class Welcome {
	public static String welcome(String input) {
		String nom = input.trim();
		StringBuilder s = new StringBuilder();
		if (nom.length() > 0) {
			if (nom.equals(nom.toUpperCase())) {
				crierNom(s,nom);
			} else {
				appelerNom(s,nom);
			}
		} else {
			s.append("Hello, my friend");
		}
		return s.toString();
	}

	private static void crierNom(StringBuilder s,String nom) {
		s.append("HELLO, ");
		s.append(nom);
		s.append(" !");
	}
	
	private static void appelerNom(StringBuilder s, String nom) {
		s.append("Hello, ");
		char premierChar = Character.toUpperCase(nom.charAt(0));
		String finNom = nom.substring(1);
		s.append(premierChar);
		s.append(finNom);
	}
}