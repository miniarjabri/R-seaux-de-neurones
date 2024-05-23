package LesNeurones;

import java.util.Arrays;
import java.util.Random;

public class NeuroneSortie {

    private double[] poids; // Les poids des connexions entre ce neurone et les neurones de la couche précédente
    private double biais; // Le biais (seuil) du neurone
    private int position; // La position du neurone dans la couche
    private double agregation; // La somme pondérée des entrées du neurone
    private double activation; // La sortie du neurone après l'application de la fonction d'activation
    private double somme;

    // Constructeur pour initialiser le neurone avec ses poids, son biais et sa position
    public NeuroneSortie( NeuroneCache[] n, int position) {
        Random random = new Random();
        biais = random.nextDouble(); // Initialisation aléatoire du biais

        this.position = position; // Position du neurone dans la couche

        // Calcul de l'agrégation du neurone
        agregation = sommePonderee(n, position) + biais;

        // Calcul de l'activation du neurone
        activation = Factivation( );
    }
    public NeuroneSortie( NeuroneEntree[] n, int position) {
        Random random = new Random();
        biais = random.nextDouble(); // Initialisation aléatoire du biais

        this.position = position; // Position du neurone dans la couche

        // Calcul de l'agrégation du neurone
        agregation = sommePonderee(n, position) + biais;

        // Calcul de l'activation du neurone
        activation = Factivation( );
    }


    // Méthode pour calculer la somme pondérée des entrées
    double sommePonderee(NeuroneCache[] n, int pos) {
        for (int i = 0; i < pos; i++) {
            somme += n[i].getPoids()[pos] * n[i].Factivation();
        }
        return somme;
    }
    double sommePonderee(NeuroneEntree[] n, int pos) {
        for (int i = 0; i < pos; i++) {
            somme += n[i].getPoids()[pos] * n[i].Factivation();
        }
        return somme;
    }
  
    public double getZ() {
    	return somme+biais;
    	}

    // Méthodes setter et getter pour les poids
    public void setPoids(double[] poids) {
        this.poids = Arrays.copyOf(poids, poids.length);
    }

    public double[] getPoids() {
        return this.poids;
    }

    // Méthodes setter et getter pour le biais
    public void setBiais(double biais) {
        this.biais = biais;
    }

    public double getBiais() {
        return this.biais;
    }
    
    public double getSomme() {
    	return somme;
    	}

    // Méthodes setter et getter pour la position du neurone dans la couche
    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    // Méthode pour l'activation du neurone
    public double Factivation( ) {
           return 1 / (1 + Math.exp(-agregation));
 }
    public double DeriveeActivation() {
        return activation * (1 - activation); // Dérivée de sigmoid
    }
 

    // Méthode pour obtenir la sortie du neurone
    double getNeurones() {
        return activation;
    }
}
