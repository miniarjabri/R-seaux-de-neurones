package LesCouches;

import LesNeurones.*;
import java.util.ArrayList;
import java.util.List;

// Classe représentant une couche de sortie dans un réseau de neurones
public class CoucheSortie implements Couche<NeuroneSortie> {
    private NeuroneSortie[] neurones; // Tableau des neurones de la couche de sortie
    private int nbNeurone; // Nombre de neurones dans la couche de sortie
    private double[] lesSeuils; // Tableau des seuils (biais) des neurones
    private double[][] lesPoids; // Tableau des poids des connexions des neurones

    // Constructeur prenant en paramètres le nombre de neurones et un tableau de neurones de la couche précédente (NeuroneCache)
    public CoucheSortie(int nbNeuronne, NeuroneCache[] n) {
        this.nbNeurone = nbNeuronne;
        this.neurones = new NeuroneSortie[nbNeuronne]; // Initialisation du tableau de neurones
        this.lesSeuils = new double[nbNeuronne];
        this.lesPoids = new double[nbNeuronne][];
        
        // Initialisation des neurones de la couche de sortie avec les paramètres fournis
        for (int i = 0; i < nbNeuronne; i++) {
            neurones[i] = new NeuroneSortie(n, i);
        }
    }

    // Constructeur prenant en paramètres le nombre de neurones et un tableau de neurones de la couche précédente (NeuroneEntree)
    public CoucheSortie(int nbNeuronne, NeuroneEntree[] n) {
        this.nbNeurone = nbNeuronne;
        this.neurones = new NeuroneSortie[nbNeuronne]; // Initialisation du tableau de neurones
        this.lesSeuils = new double[nbNeuronne];
        this.lesPoids = new double[nbNeuronne][];
        
        // Initialisation des neurones de la couche de sortie avec les paramètres fournis
        for (int i = 0; i < nbNeuronne; i++) {
            neurones[i] = new NeuroneSortie(n, i);
        }
    }

    // Méthode pour obtenir le nombre de neurones dans la couche
    @Override
    public int getNombreNeurones() {
        return neurones.length; // Retourne le nombre de neurones dans la couche
    }

    // Méthode pour obtenir la liste des neurones de la couche de sortie
    @Override
    public NeuroneSortie[] getNeurones() {
        return neurones; // Retourne la liste des neurones de la couche de sortie
    }

    // Méthode pour définir les neurones de la couche de sortie
    public void setNeurones(List<NeuroneSortie> neurones) {
        this.neurones = neurones.toArray(new NeuroneSortie[0]); // Réinitialise la liste des neurones avec une nouvelle liste
    }

    // Méthode pour obtenir les biais des neurones de la couche de sortie
    public double[] getBiaises() {
        for (int i = 0; i < neurones.length; i++) {
            lesSeuils[i] = neurones[i].getBiais();
        }
        return lesSeuils; // Retourne les biais des neurones
    }

    // Méthode pour obtenir les poids des connexions des neurones de la couche de sortie
    public double[][] getPoids() {
        double[][] s = new double[neurones.length][];
        for (int i = 0; i < neurones.length; i++) {
            s[i] = neurones[i].getPoids();
        }
        return s; // Retourne les poids des connexions
    }

    // Méthode pour calculer la sortie des neurones de la couche de sortie
    public double[] sortie(double[] activations) {
        double[] sorties = new double[neurones.length];
        for (int i = 0; i < neurones.length; i++) {
            sorties[i] = neurones[i].Factivation(); // Calcule la sortie de chaque neurone après application de la fonction d'activation
        }
        return sorties; // Retourne les sorties des neurones
    }

    // Méthode pour mettre à jour les biais et les poids des neurones de la couche de sortie
    public void updateBiasesAndWeights(double[] nablaB, double[][] nablaW) {
        for (int i = 0; i < neurones.length; i++) {
            neurones[i].setBiais(nablaB[i]); // Met à jour le biais de chaque neurone
            neurones[i].setPoids(nablaW[i]); // Met à jour les poids de chaque neurone
        }
    }

    // Méthode pour obtenir les valeurs z des neurones de la couche de sortie
    public double[] getZ() {
        double[] z = new double[neurones.length];
        for (int i = 0; i < neurones.length; i++) {
            z[i] = neurones[i].getSomme(); // Récupère les valeurs z de chaque neurone
        }
        return z; // Retourne les valeurs z
    }

    // Méthode pour calculer l'activation des neurones de la couche de sortie
    public double[] activation() {
        double[] LesDeriveesActivations = new double[neurones.length];
        for (int i = 0; i < neurones.length; i++) {
            LesDeriveesActivations[i] = neurones[i].DeriveeActivation(); // Calcule la dérivée de l'activation de chaque neurone
        }
        return LesDeriveesActivations; // Retourne les dérivées de l'activation
    }

    // Méthode pour calculer l'activation prime (dérivée de la fonction d'activation)
    public double[] activationPrime(double[] z) {
        double[] result = new double[z.length];
        for (int i = 0; i < z.length; i++) {
            double sigmoid = 1.0 / (1.0 + Math.exp(-z[i]));
            result[i] = sigmoid * (1 - sigmoid); // Calcule la dérivée de la fonction sigmoïde
        }
        return result; // Retourne les valeurs de l'activation prime
    }

    // Méthode pour obtenir le type de la couche (ici, couche de sortie)
    @Override
    public String getTypeCouche() {
        return "Sortie";
    }

    // Méthode pour obtenir la sortie des neurones de la couche de sortie
    @Override
    public double[] getSortie() {
        double[] s = new double[nbNeurone];
        for (int i = 0; i < nbNeurone; i++) {
            s[i] = neurones[i].Factivation(); // Calcule la sortie de chaque neurone après application de la fonction d'activation
        }
        return s; // Retourne les sorties des neurones
    }

    // Méthode pour obtenir les valeurs z des neurones de la couche de sortie en fonction des activations
    @Override
    public double[] getZ(double[] activations) {
        double[] z = new double[neurones.length];
        for (int i = 0; i < neurones.length; i++) {
            z[i] = neurones[i].getZ(); // Récupère les valeurs z de chaque neurone
        }
        return z; // Retourne les valeurs z
    }
}
