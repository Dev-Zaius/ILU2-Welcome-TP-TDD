package ilu2;

public class Welcome {

	public static String welcome(String input) {
		String[] noms = input.replaceAll("\\s", "").split(",");
		StringBuilder s = new StringBuilder();
		if (input.trim().length() > 0) {
			appellerNoms(s, noms);
		} else {
			s.append("Hello, my friend");
		}
		return s.toString();
	}
	
	private static void appellerNoms(StringBuilder s , String[] noms) {
		String[] nomsAAppeler = new String[20];
		String[] nomsACrier = new String[20];
		int[] occurAppel = new int[20];
		int[] occurCri = new int[20];
		int tailleAppels = 0;
		int tailleCris = 0;
		boolean vuPetitYoda = false;
		boolean vuGrandYoda = false;
		for (int i = 0 ; i < noms.length ; i++) {
			if (noms[i].equals(noms[i].toUpperCase())) {
				tailleCris = crierNom(tailleAppels,tailleCris,occurCri,occurAppel,nomsACrier,nomsAAppeler,noms[i]);
				if (noms[i].equals("YODA")) vuGrandYoda = true;
			} else {
				tailleAppels = appelerNom(tailleAppels,tailleCris,occurCri,occurAppel,nomsACrier,nomsAAppeler,noms[i]);
				if (noms[i].equalsIgnoreCase("yoda")) vuPetitYoda = true;
			}
		}
		construirePhraseEntiere(vuPetitYoda,vuGrandYoda,tailleCris,tailleAppels,occurCri,occurAppel,nomsAAppeler,nomsACrier,s);
	}
	
	private static void construirePhraseEntiere(boolean vuPetitYoda,boolean vuGrandYoda,int tailleCris, int tailleAppels,int[] occurCris, int[] occurAppels,String[] nomsAAppeler,String[] nomsACrier,StringBuilder s) {
		if (tailleAppels > 0) {
			if (!vuPetitYoda) s.append("Hello, ");
			formatterPlusieursNoms(tailleAppels,s, nomsAAppeler, occurAppels, false);
			if (vuPetitYoda) s.append(", Hello");
		}
		if (tailleCris > 0) {
			if (tailleAppels == 0 && !vuGrandYoda) {
				s.append("HELLO, ");
			} else {
				s.append(". AND " + (vuGrandYoda ? "" : "HELLO, "));
			}
			formatterPlusieursNoms(tailleCris,s, nomsACrier, occurCris, true);
			if (vuGrandYoda) s.append(" HELLO");
			s.append(" !");
		}
	}
	
	private static void formatterPlusieursNoms(int taille,StringBuilder s, String[] noms , int[] occurences, boolean crier) {
		int i;
		if (taille == 1) {
			s.append(noms[0]);
			if (occurences[0] > 1) s.append(" (x"+occurences[0]+")");
		} else {
			for (i = 0 ; i < taille-1  ; i++) {
				s.append(noms[i] + (occurences[i] > 1 ? " (x" +occurences[i]+"), ":", "));
			}
			s.delete(s.length()-2, s.length());
			s.append((crier ? " AND " : " and ") + noms[taille - 1] + (occurences[taille-1] >1 ? " (x"+occurences[taille-1]+")":"" ));
		}
	}

	private static int crierNom(int tailleAppels,int tailleCris,int[] occurCri, int[] occurAppel,String[] nomsACrier,String[] nomsAAppeler,String nom) {
		boolean DejaCri = regarderSiVu(tailleCris, nom, nomsACrier, occurCri); 
		boolean DejaAppel = regarderSiVu(tailleAppels, nom, nomsAAppeler, occurAppel); 
	
		if (!DejaCri && !DejaAppel) {
			nomsACrier[tailleCris] = nom;
			occurCri[tailleCris]++;
			tailleCris += 1;
		}
		return tailleCris ;
	}
	
	private static int appelerNom(int tailleAppels,int tailleCris,int[] occurCri, int[] occurAppel,String[] nomsACrier,String[] nomsAAppeler,String nom) {
		boolean DejaCri = regarderSiVu(tailleCris, nom, nomsACrier, occurCri); 
		boolean DejaAppel = regarderSiVu(tailleAppels, nom, nomsAAppeler, occurAppel); 
	
		if (!DejaCri && !DejaAppel) {
			nomsAAppeler[tailleAppels] = Character.toUpperCase(nom.charAt(0)) + nom.substring(1);
			occurAppel[tailleAppels]++;
			tailleAppels+=1;
		}
		return tailleAppels;
	}

	private static boolean regarderSiVu(int taille,String nom , String[] noms , int[] occur) {
		for (int i = 0 ; i < taille ; i++ ) {
			if (nom.equalsIgnoreCase(noms[i]) 
					&& !(nom.equalsIgnoreCase("yoda") 
							&& ((noms[i].equals("Yoda") && nom.equals("YODA") )
									|| noms[i].equals("YODA") && (nom.equals("Yoda") || nom.equals("yoda"))))) {
				occur[i]++;
				return true;
			}
		}
		return false;
	}
}