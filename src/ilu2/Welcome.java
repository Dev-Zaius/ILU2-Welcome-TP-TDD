package ilu2;

public class Welcome {

	public static String welcome(String input) {
		String[] noms = input.split(",");
		StringBuilder s = new StringBuilder();
		if (noms.length > 1) {
			appellerPlusieursNoms(s, noms);
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
	
	private static void appellerPlusieursNoms(StringBuilder s , String[] noms) {
		s.append("Hello, ");
		for (int i = 0 ; i < noms.length ; i++) {
			s.append(Character.toUpperCase(noms[i].charAt(0)));
			s.append(noms[i].substring(1));
			if (i != noms.length - 1)
				s.append(", ");
		}
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