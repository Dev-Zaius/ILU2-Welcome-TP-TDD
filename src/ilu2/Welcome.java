package ilu2;

public class Welcome {

	public static String welcome(String input) {
		String[] noms = input.split(",");
		StringBuilder s = new StringBuilder("Hello, ");
		if (input.trim().length() > 0) {
			if (noms.length > 1)
				appellerPlusieursNoms(s, noms);
			else if (noms[0].equals(noms[0].toUpperCase())){
				s.replace(0, s.length(), "HELLO, ");
				crierNom(s,noms[0], true);
			} else {
				appelerNom(s, noms[0],true);
			}
		} else {
			s.append("my friend");
		}
		System.out.println(s);
		return s.toString();
	}
	
	private static void appellerPlusieursNoms(StringBuilder s , String[] noms) {
		StringBuilder nomsAAppeler = new StringBuilder();
		StringBuilder nomsACrier = new StringBuilder();
		for (int i = 0 ; i < noms.length ; i++) {
			if (noms[i].equals(noms[i].toUpperCase())) {
				crierNom(nomsACrier,noms[i],false);
			} else {
				appelerNom(nomsAAppeler,noms[i],false);
			}
		}
		construirePhraseEntiere(nomsAAppeler,nomsACrier,s);
	}
	
	private static void construirePhraseEntiere(StringBuilder nomsAAppeler,StringBuilder nomsACrier,StringBuilder s) {
		if (nomsAAppeler.length() > 0) {
			s.append(nomsAAppeler);
			s.delete(s.length()-2,s.length());
		}
		if (nomsACrier.length() > 0) {
			if (nomsAAppeler.length() == 0) {
				s.replace(0, s.length(), "HELLO, ");
			} else {
				s.append(". AND HELLO, ");
			}
			s.append(nomsACrier);
			s.replace(s.length()-2, s.length()," !");
		}
	}

	private static void crierNom(StringBuilder s,String nom,boolean estDernierNom) {
		s.append(nom);
		s.append((estDernierNom ? " !" : ", ") );
	}
	
	private static void appelerNom(StringBuilder s, String nom, boolean estDernierNom) {
		char premierChar = Character.toUpperCase(nom.charAt(0));
		String finNom = nom.substring(1);
		s.append(premierChar);
		s.append(finNom);
		s.append((estDernierNom ? "" : ", ") );
	}
}