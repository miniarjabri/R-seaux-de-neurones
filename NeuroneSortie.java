package réseaux_de_neurones;

import java.util.Random;

public class NeuroneSortie extends Neurone {
	private double seuil;
    // Constructeur
    public NeuroneSortie() {
        initialiserSeuilAleatoirement();
    }

    @Override
    public double calculerSortie(double[] entrees) {
        // Fonction qui calcule les valeurs à envoyer à chaque neurone de la couche suivante
        // Dans le cas du neurone de sortie, il n'y a pas de calcul à faire, car il ne reçoit pas d'entrées de la couche suivante
        return seuil; // Le seuil (biais) est renvoyé en tant que sortie du neurone de sortie
    }

    // Méthode pour initialiser le seuil aléatoirement
    private void initialiserSeuilAleatoirement() {
        Random random = new Random();
        seuil = random.nextDouble(); // Initialise le seuil avec un nombre aléatoire entre 0 (inclus) et 1 (exclus)
    }

// Méthode pour la fonction d'activation (à implémenter)
    private double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    private double fonctionActivation(double sommePonderee) {
        // Utiliser la fonction sigmoïde comme fonction d'activation
        return sigmoid(sommePonderee);
    }

    // Méthode pour afficher le résultat
    public void afficherResultat() {
        System.out.println("Résultat : " + seuil);
    }
}
