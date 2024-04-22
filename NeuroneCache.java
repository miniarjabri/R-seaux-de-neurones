package réseaux_de_neurones;

import java.util.Random;

public class NeuroneCachee extends Neurone {
	private int tailleEntree;
	private double[] poids;
	private double seuil;
	
    // Constructeur
    public NeuroneCachee(int tailleEntree) {
        this.tailleEntree=tailleEntree;
        initialiserSeuilAleatoirement();
    }

    @Override
    public double calculerSortie(double[] entrees) {
        // Fonction qui calcule les valeurs à envoyer à chaque neurone de la couche suivante
        double sommePonderee = 0;
        for (int i = 0; i < poids.length; i++) {
            sommePonderee += poids[i] * entrees[i];
        }
        // Appliquer une fonction d'activation si nécessaire
        return fonctionActivation(sommePonderee + seuil);
    }

    // Méthode pour la fonction d'activation (à implémenter)
    private double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    private double fonctionActivation(double sommePonderee) {
        // Utiliser la fonction sigmoïde comme fonction d'activation
        return sigmoid(sommePonderee);
    }
    

    // Méthode pour initialiser le seuil aléatoirement
    private void initialiserSeuilAleatoirement() {
        Random random = new Random();
        seuil = random.nextDouble(); // Initialise le seuil avec un nombre aléatoire entre 0 (inclus) et 1 (exclus)
    }
}

