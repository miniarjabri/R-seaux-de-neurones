package etape3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ReseauNeuronesBAC {
    private List<etudiant> etudiants;

    public ReseauNeuronesBAC() {
        etudiants = new ArrayList<>();
    }

    public void ajouterEtudiant(etudiant etudiant) {
        etudiants.add(etudiant);
    }

    public boolean reussiteBAC(etudiant etudiant) {
        double sommeNotes = 0;
        int sommeCoefficients = 0;
        for (Epreuve epreuve : etudiant.getNotes().values()) {
            sommeNotes += epreuve.getNote() * epreuve.getCoefficient();
            sommeCoefficients += epreuve.getCoefficient();
        }
        double moyenne = sommeNotes / sommeCoefficients;
        return moyenne > 10;
    }

    public String mentionBAC(etudiant etudiant) {
        double sommeNotes = 0;
        int sommeCoefficients = 0;
        for (Epreuve epreuve : etudiant.getNotes().values()) {
            sommeNotes += epreuve.getNote() * epreuve.getCoefficient();
            sommeCoefficients += epreuve.getCoefficient();
        }
        double moyenne = sommeNotes / sommeCoefficients;
        if (moyenne >= 16) {
            return "TB";
        } else if (moyenne >= 14) {
            return "B";
        } else if (moyenne >= 12) {
            return "AB";
        } else if (moyenne >= 10) {
            return "P"; //P pour "passable"
        }
        else {
        	return"R";// R pour "Redoublement"
        }
    }

    public double fonctionCout() {
        double coutTotal = 0;
        for (etudiant etudiant : etudiants) {
            boolean reussi = reussiteBAC(etudiant);
            String mention = mentionBAC(etudiant);
            if (reussi && !mention.equals("R")) {
                coutTotal += 0; // Coût nul si réussi avec mention
            } else {
                coutTotal += 1; // Coût de 1 pour chaque échec ou absence de mention
            }
        }
        return coutTotal / etudiants.size(); // Coût moyen par étudiant
    }

    public List<etudiant> getEtudiants() {
        return etudiants;
    }

}