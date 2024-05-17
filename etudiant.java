package etape3;

import java.util.HashMap;
import java.util.Map;

public class etudiant {
    private String nom;
    private Map<String, Epreuve> notes;

    public etudiant(String nom) {
        this.nom = nom;
        notes = new HashMap<>();
    }

    public String getNom() {
        return nom;
    }

    public Map<String, Epreuve> getNotes() {
        return notes;
    }

    public void addNote(String nomEpreuve, double note, int coefficient) {
        notes.put(nomEpreuve, new Epreuve(nomEpreuve, note, coefficient));
    }

    public void setNote(String nomEpreuve, double note) {
        Epreuve epreuve = notes.get(nomEpreuve);
        if (epreuve != null) {
            epreuve.setNote(note);
        }
    }
}
