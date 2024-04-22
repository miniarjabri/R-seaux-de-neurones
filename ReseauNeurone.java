package ReseauxDeNeurones;

import LesCouches.Couche;
import java.util.ArrayList;
import java.util.List;

public class ReseauNeurone {
    private List<Couche<?>> couches; // Liste des couches du réseau

    public ReseauNeurone() {
        this.couches = new ArrayList<>();
    }

    // Ajouter une couche au réseau
    public void ajouterCouche(Couche<?> couche) {
        couches.add(couche);
    }

    // Propagation avant pour obtenir la sortie du réseau à partir d'une entrée donnée
    public double[] propagerAvant(double[] entrees) {
        double[] activations = entrees;

        for (Couche<?> couche : couches) {
            activations = couche.propagerAvant(activations);
        }

        return activations; // La sortie du réseau après propagation à travers toutes les couches
    }

    // Entraînement du réseau
    public void entrainer(double[] entrees, double[] sortiesAttendues) {
        double[] resultats = propagerAvant(entrees);
        // Rétropropagation pour ajuster les poids basés sur l'erreur (à implémenter)
    }

    // Implémenter la rétropropagation ici (exemple simplifié)
    public void retropropager(double[] sortiesAttendues, double[] sortiesActuelles) {
        // Logique de rétropropagation pour ajuster les poids (à développer)
    }

    // Sauvegarder l'état du réseau (optionnel)
    public void sauvegarderEtat(String chemin) {
        // Code pour sauvegarder l'état du réseau
    }

    // Charger un état du réseau (optionnel)
    public void chargerEtat(String chemin) {
        // Code pour charger l'état du réseau
    }
}
