package LotEchantillon;

import java.util.LinkedHashMap;
import java.util.Map;

import echantillon.Ou;

public class LotOu {
	  private Map<String, Integer> sorties;

	    public LotOu() {
	        sorties = new LinkedHashMap<>();
	        remplirSorties();
	    }

	    private void remplirSorties() {
	        sorties.put("(0 OU 0)", new Ou(0, 0).getSortie());
	        sorties.put("(1 OU 0)", new Ou(1, 0).getSortie());
	        sorties.put("(0 OU 1)", new Ou(0, 1).getSortie());
	        sorties.put("(1 OU 1)", new Ou(1, 1).getSortie());
	    }

	    public Map<String, Integer> getSorties() {
	        return sorties;
	    }

	    public static void main(String[] args) {
	        LotOu lotOu = new LotOu();
	        Map<String, Integer> sorties = lotOu.getSorties();
	        System.out.println("Sorties de la fonction OU pour les entrées (0,0), (1,0), (0,1), (1,1) :");
	        sorties.forEach((entree, sortie) -> System.out.println(entree + " = " + sortie));
	    }
	}
