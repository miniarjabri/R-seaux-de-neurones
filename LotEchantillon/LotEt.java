package LotEchantillon;

import echantillon.Et;

import java.util.LinkedHashMap;
import java.util.Map;

public class LotEt {
    private Map<String, Integer> sorties;

    public LotEt() {
        sorties = new LinkedHashMap<>();
        remplirSorties();
    }

    private void remplirSorties() {
        sorties.put("(0 ET 0)", new Et(0, 0).getSortie());
        sorties.put("(1 ET 0)", new Et(1, 0).getSortie());
        sorties.put("(0 ET 1)", new Et(0, 1).getSortie());
        sorties.put("(1 ET 1)", new Et(1, 1).getSortie());
    }

    public Map<String, Integer> getSorties() {
        return sorties;
    }

    public static void main(String[] args) {
        LotEt lotEt = new LotEt();
        Map<String, Integer> sorties = lotEt.getSorties();
        System.out.println("Sorties de la fonction ET pour les entrées (0,0), (1,0), (0,1), (1,1) :");
        sorties.forEach((entree, sortie) -> System.out.println(entree + " = " + sortie));
    }
}
