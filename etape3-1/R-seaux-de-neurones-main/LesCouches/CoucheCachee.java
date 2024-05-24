package LesCouches;

import LesNeurones.*;

import java.util.List;

// Classe représentant une couche cachée dans un réseau de neurones
public class CoucheCachee implements Couche<NeuroneCache> {
    private NeuroneCache[] neuronnes; // Tableau des neurones de la couche cachée
    private int nbNeuronne; // Nombre de neurones dans la couche cachée
    private double[] lesSeuils; // Tableau des biais (seuils) des neurones
    private double[][] lesPoids; // Tableau des poids des connexions des neurones
    private double[] z; // Tableau des valeurs z des neurones (somme pondérée des entrées plus le biais)

    // Constructeur prenant en paramètres le nombre de neurones, la liste des neurones de la couche précédente et le nombre de neurones dans la couche suivante
    public CoucheCachee(int nbNeuronne, NeuroneCache[] n, int nbreNeuronneCoucheSuivante) {
        this.nbNeuronne = nbNeuronne;
        this.neuronnes = new NeuroneCache[nbNeuronne]; // Initialisation du tableau de neurones
        this.lesSeuils = new double[nbNeuronne]; // Initialisation du tableau de biais
        this.lesPoids = new double[nbNeuronne][]; // Initialisation du tableau de poids
        // Initialisation des neurones de la couche cachée avec les paramètres fournis
        for (int i = 0; i < nbNeuronne; i++) {
            neuronnes[i] = new NeuroneCache(n, i, nbreNeuronneCoucheSuivante);
        }
    }

    // Constructeur prenant en paramètres le nombre de neurones, la liste des neurones de la couche d'entrée et le nombre de neurones dans la couche suivante
    public CoucheCachee(int nbNeuronne, NeuroneEntree[] n, int nbreNeuronneCoucheSuivante) {
        this.nbNeuronne = nbNeuronne;
        this.neuronnes = new NeuroneCache[nbNeuronne]; // Initialisation du tableau de neurones
        this.lesSeuils = new double[nbNeuronne]; // Initialisation du tableau de biais
        this.lesPoids = new double[nbNeuronne][]; // Initialisation du tableau de poids
        // Initialisation des neurones de la couche cachée avec les paramètres fournis
        for (int i = 0; i < nbNeuronne; i++) {
            neuronnes[i] = new NeuroneCache(n, i, nbreNeuronneCoucheSuivante);
        }
    }

    // Méthode pour obtenir le nombre de neurones dans la couche
    @Override
    public int getNombreNeurones() {
        return nbNeuronne;
    }

    // Méthode pour obtenir la liste des neurones de la couche cachée
    @Override
    public NeuroneCache[] getNeurones() {
        return neuronnes; // Retourne la liste des neurones de la couche cachée
    }

    // Méthode pour définir les neurones de la couche cachée
    public void setNeurones(List<NeuroneCache> neurones) {
        this.neuronnes = neurones.toArray(new NeuroneCache[0]); // Réinitialise la liste des neurones avec une nouvelle liste
    }

    // Méthode pour obtenir les biais des neurones de la couche cachée
    public double[] getBiaises() {
        for (int i = 0; i < neuronnes.length; i++) {
            lesSeuils[i] = neuronnes[i].getBiais(); // Récupère le biais de chaque neurone
        }
        return lesSeuils;
    }

    // Méthode pour obtenir les poids des connexions des neurones de la couche cachée
    public double[][] getPoids() {
        for (int i = 0; i < neuronnes.length; i++) {
            lesPoids[i] = neuronnes[i].getPoids(); // Récupère les poids de chaque neurone
        }
        return lesPoids;
    }

    // Méthode pour calculer la sortie des neurones de la couche cachée
    public double[] sortie(double[] activations) {
        double[] sorties = new double[neuronnes.length];
        for (int i = 0; i < neuronnes.length; i++) {
            sorties[i] = neuronnes[i].Factivation(); // Calcule la sortie de chaque neurone après application de la fonction d'activation
        }
        return sorties;
    }

    // Méthode pour mettre à jour les biais et les poids des neurones de la couche cachée
    public void updateBiasesAndWeights(double[] nablaB, double[][] nablaW) {
        for (int i = 0; i < neuronnes.length; i++) {
            neuronnes[i].setBiais(nablaB[i]); // Met à jour le biais de chaque neurone
            neuronnes[i].setPoids(nablaW[i]); // Met à jour les poids de chaque neurone
        }
    }

    // Méthode pour obtenir les valeurs z des neurones de la couche cachée
    public double[] getZ() {
        double[] z = new double[neuronnes.length];
        for (int i = 0; i < neuronnes.length; i++) {
            z[i] = neuronnes[i].getSomme(); // Calcule la somme pondérée des entrées plus le biais pour chaque neurone
        }
        return z;
    }

    // Méthode pour calculer les activations des neurones de la couche cachée
    public double[] activation() {
        double[] LesDeriveesActivations = new double[neuronnes.length];
        for (int i = 0; i < neuronnes.length; i++) {
            LesDeriveesActivations[i] = neuronnes[i].DeriveeActivation(); // Calcule la dérivée de la fonction d'activation pour chaque neurone
        }
        return LesDeriveesActivations;
    }

    // Méthode pour calculer la dérivée de la fonction d'activation des neurones de la couche cachée
    public double[] activationPrime(double[] z) {
        // Implémentation dépend de la fonction d'activation spécifique utilisée par la couche
        // Par exemple, pour une fonction d'activation sigmoïde :
        double[] result = new double[z.length];
        for (int i = 0; i < z.length; i++) {
            double sigmoid = 1.0 / (1.0 + Math.exp(-z[i]));
            result[i] = sigmoid * (1 - sigmoid); // Calcule la dérivée de la fonction d'activation sigmoïde
        }
        return result;
    }

    // Méthode pour obtenir les valeurs z des neurones de la couche cachée en fonction des activations
    @Override
    public double[] getZ(double[] activations) {
        double[] z = new double[neuronnes.length];
        for (int i = 0; i < neuronnes.length; i++) {
            z[i] = neuronnes[i].getZ(); // Calcule les valeurs z pour chaque neurone
        }
        return z;
    }

    // Méthode pour obtenir le type de la couche (ici, couche cachée)
    @Override
    public String getTypeCouche() {
        return "Cachee";
    }

    // Méthode pour obtenir la sortie des neurones de la couche cachée
    @Override
    public double[] getSortie() {
        double[] s = new double[neuronnes.length];
        for (int i = 0; i < neuronnes.length; i++) {
            s[i] = neuronnes[i].Factivation(); // Calcule la sortie de chaque neurone après application de la fonction d'activation
        }
        return s;
    }
}
