package LesNeurones;

import java.util.Arrays;
import java.util.Random;

public class NeuroneEntree {

    private double[] poids; // Les poids des connexions entre ce neurone et les neurones de la couche suivante
    private double firstActivation; // L'activation initiale de ce neurone
    private final double agregation = 0; // L'agrégation est toujours 0 pour les neurones d'entrée

    // Constructeur
    public NeuroneEntree(double firstActivation, int nbNeuronneCoucheSuivante) {
        this.firstActivation = firstActivation;
        this.poids = new double[nbNeuronneCoucheSuivante]; // Initialisation du tableau de poids
        
        // Initialisation aléatoire des poids
        for (int i = 0; i < nbNeuronneCoucheSuivante; i++) {
            Random random = new Random();
            poids[i] = random.nextDouble();
        }
    }

    // Méthode pour définir les poids du neurone
    public void setPoids(double[] poids) {
        this.poids = Arrays.copyOf(poids, poids.length);
    }

    // Méthode pour obtenir les poids du neurone
    public double[] getPoids() {
        return Arrays.copyOf(poids, poids.length);
    }

    // Méthode pour obtenir le biais du neurone (toujours 0 pour les neurones d'entrée)
    public double getBiais() {
        return 0;
    }

    // Méthode pour obtenir l'activation du neurone
    public double activation() {
        return firstActivation;
    }

    // Méthode pour définir l'activation du neurone
    public void setActivation(double activation) {
        this.firstActivation = activation;
    }
}
