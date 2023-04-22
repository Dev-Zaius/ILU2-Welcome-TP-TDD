package ilu2;

public class Welcome {

	public static String welcome(String input) {
		String[] noms = input.split(",");
		StringBuilder s = new StringBuilder();
		if (noms.length > 1) {
			appellerDeuxNoms(s, noms);
		} else {
			noms[0] = noms[0].trim();
			if (noms[0].length() > 0) {
				if (noms[0].equals(noms[0].toUpperCase())) {
					crierNom(s,noms[0]);
				} else {
					appelerNom(s,noms[0]);
				}
			} else {
				s.append("Hello, my friend");
			}
		}
		System.out.println(s);
		return s.toString();
	}
	
	private static void appellerDeuxNoms(StringBuilder s , String[] noms) {
		s.append("Hello, ");
		char premierChar = Character.toUpperCase(noms[0].charAt(0));
		s.append(premierChar);
		s.append(noms[0].substring(1));
		s.append(", ");
		s.append(Character.toUpperCase(noms[1].charAt(0)));
		s.append(noms[1].substring(1));
	}

	private static void crierNom(StringBuilder s,String noms) {
		s.append("HELLO, ");
		s.append(noms);
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