package LotEchantillon;

import java.util.ArrayList;
import java.util.List;

import echantillon.Echantillon_note;

public class LotEchantillon_note {
	
    private List<Echantillon_note> echantillons;

    public LotEchantillon_note() {
        echantillons = new ArrayList<>();
    }

    public void ajouterEchantillon(Echantillon_note echantillon) {
        echantillons.add(echantillon);
    }

    public List<Echantillon_note> getEchantillons() {
        return echantillons;
    }

    public int nombreEchantillons() {
        return echantillons.size();
    }
}
