package LotEchantillon;

import echantillon.Non;

import java.util.HashMap;
import java.util.Map;

public class LotNon {
    private Map<Integer, Integer> sorties;

    public LotNon() {
        sorties = new HashMap<>();
        remplirSorties();
    }

    private void remplirSorties() {
        sorties.put(0, new Non(0).getSortie());
        sorties.put(1, new Non(1).getSortie());
    }

    public Map<Integer, Integer> getSorties() {
        return sorties;
    }

    public static void main(String[] args) {
        LotNon lotNon = new LotNon();
        Map<Integer, Integer> sorties = lotNon.getSorties();
        System.out.println("Sorties de la fonction NON pour les entrées 0 et 1 :");
        sorties.forEach((entree, sortie) -> System.out.println("NON " + entree + " = " + sortie));
    }
}