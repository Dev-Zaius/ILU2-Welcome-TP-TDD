package ilu2;

public class Welcome {

	public static String welcome(String input) {
		String[] noms = input.replaceAll("\\s", "").split(",");
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
		return s.toString();
	}
	
	private static void appellerPlusieursNoms(StringBuilder s , String[] noms) {
		StringBuilder nomsAAppeler = new StringBuilder();
		StringBuilder nomsACrier = new StringBuilder();
		int tailleDernierCrier = 0;
		int tailleDernierAppeler = 0;
		for (int i = 0 ; i < noms.length ; i++) {
			if (noms[i].equals(noms[i].toUpperCase())) {
				crierNom(nomsACrier,noms[i],false);
				tailleDernierCrier = noms[i].length();
			} else {
				appelerNom(nomsAAppeler,noms[i],false);
				tailleDernierAppeler = noms[i].length();
			}
		}
		construirePhraseEntiere(nomsAAppeler,nomsACrier,s,tailleDernierCrier,tailleDernierAppeler);
	}
	
	private static void construirePhraseEntiere(StringBuilder nomsAAppeler,StringBuilder nomsACrier,StringBuilder s,int tailleDernierCrier,int tailleDernierAppeler) {
		if (nomsAAppeler.length() > 0) {
			formatterPlusieursNoms(s, nomsAAppeler, tailleDernierAppeler, false);
		}
		if (nomsACrier.length() > 0) {
			if (nomsAAppeler.length() == 0) {
				s.replace(0, s.length(), "HELLO, ");
			} else {
				s.append(". AND HELLO, ");
			}
			formatterPlusieursNoms(s, nomsACrier, tailleDernierCrier, true);
			s.append(" !");
		}
	}
	
	private static void formatterPlusieursNoms(StringBuilder s, StringBuilder noms , int tailleDernierNom, boolean crier) {
		if (noms.length() == tailleDernierNom + 2) {
			s.append(noms);
		} else {
				s.append(noms.subSequence(0, noms.length() - 4 - tailleDernierNom));
				s.append((crier ? " AND " : " and "));
				s.append(noms.subSequence(noms.length() - 2 - tailleDernierNom, noms.length()));
		}
		s.delete(s.length()-2,s.length());
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