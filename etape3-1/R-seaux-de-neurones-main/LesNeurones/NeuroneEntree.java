package LesNeurones;

import java.util.Arrays;
import java.util.Random;

public class NeuroneEntree {

    private double[] poids; // Les poids des connexions entre ce neurone et les neurones de la couche suivante
    private double firstActivation; // L'activation initiale de ce neurone
    private final double agregation = 0; // L'agrégation est toujours 0 pour les neurones d'entrée

    // Constructeur qui initialise le neurone d'entrée avec une activation initiale et le nombre de neurones dans la couche suivante
    public NeuroneEntree(double firstActivation, int nbNeuronneCoucheSuivante) {
        this.firstActivation = firstActivation; // Activation initiale du neurone d'entrée
        this.poids = new double[nbNeuronneCoucheSuivante]; // Initialisation du tableau de poids

        // Initialisation aléatoire des poids
        Random random = new Random();
        for (int i = 0; i < nbNeuronneCoucheSuivante; i++) {
            poids[i] = random.nextDouble(); // Chaque poids est un nombre aléatoire
        }
    }

    // Méthode pour définir les poids du neurone
    public void setPoids(double[] poids) {
        this.poids = Arrays.copyOf(poids, poids.length); // Copie des poids passés en argument dans le tableau de poids du neurone
    }

    // Méthode pour obtenir les poids du neurone
    public double[] getPoids() {
        return Arrays.copyOf(poids, poids.length); // Retourne une copie du tableau de poids pour éviter les modifications extérieures
    }
    
    // Méthode pour obtenir le biais du neurone (toujours 0 pour les neurones d'entrée)
    public double getBiais() {
        return 0; // Les neurones d'entrée n'ont pas de biais
    }
    
    // Méthode pour obtenir la somme pondérée des entrées (toujours 0 pour les neurones d'entrée)
    public double getZ() {
        return 0; // Les neurones d'entrée n'ont pas de somme pondérée d'entrées
    }
    
    // Méthode pour obtenir l'activation du neurone
    public double Factivation() {
        return firstActivation; // Retourne l'activation initiale du neurone
    }

    // Méthode pour définir l'activation du neurone
    public void setActivation(double activation) {
        this.firstActivation = activation; // Met à jour l'activation initiale du neurone
    }
}
