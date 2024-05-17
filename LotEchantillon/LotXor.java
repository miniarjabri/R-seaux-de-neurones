package LotEchantillon;


import java.util.HashMap;
import java.util.Map;

import echantillon.Xor;

public class LotXor {
    private Map<String, Integer> sorties;

    public LotXor() {
        sorties = new HashMap<>();
        remplirSorties();
    }

    private void remplirSorties() {
        sorties.put("(0 XOR 0)", new Xor(0, 0).getSortie());
        sorties.put("(1 XOR 0)", new Xor(1, 0).getSortie());
        sorties.put("(0 XOR 1)", new Xor(0, 1).getSortie());
        sorties.put("(1 XOR 1)", new Xor(1, 1).getSortie());
    }

    public Map<String, Integer> getSorties() {
        return sorties;
    }

    public static void main(String[] args) {
        LotXor lotXor = new LotXor();
        Map<String, Integer> sorties = lotXor.getSorties();
        System.out.println("Sorties de la fonction XOR pour les entrées (0,0), (1,0), (0,1), (1,1) :");
        sorties.forEach((entree, sortie) -> System.out.println(entree + " = " + sortie));
    }
}
