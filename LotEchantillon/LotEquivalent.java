package LotEchantillon;


import java.util.HashMap;
import java.util.Map;

import echantillon.Equivalent;

public class LotEquivalent {
	    private final Equivalent equivalent;
	    private final Map<String, Integer> sorties;

	    public LotEquivalent(int poidsX, int poidsY, int seuil) {
	        equivalent = new Equivalent(poidsX, poidsY, seuil);
	        sorties = new HashMap<>();
	        remplirSorties();
	    }

	    private void remplirSorties() {
	    	sorties.put("(0=>0)", equivalent.evaluer(0, 0));
	        sorties.put("(0=>1)", equivalent.evaluer(0, 1));
	        sorties.put("(1=>0)", equivalent.evaluer(1, 0));
	        sorties.put("(1=>1)", equivalent.evaluer(1, 1));
	    }

	    public Map<String, Integer> getSorties() {
	        return sorties;
	    }

	    public static void main(String[] args) {
	        int poidsX = 1;
	        int poidsY = 2;
	        int seuil = 1;

	        LotEquivalent lotEquivalent = new LotEquivalent(poidsX, poidsY, seuil);
	        Map<String, Integer> sorties = lotEquivalent.getSorties();

	        System.out.println("Sorties de la fonction Equivalent pour les entrées (0,0), (0,1), (1,0), (1,1) :");
	        sorties.forEach((entree, sortie) -> System.out.println(entree + " = " + sortie));
	    }
	}
