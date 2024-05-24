package LesCouches;

import LesNeurones.NeuroneEntree;
import java.util.List;

// Classe représentant une couche d'entrée dans un réseau de neurones
public class CoucheEntree implements Couche<NeuroneEntree> {
    private NeuroneEntree[] neuronnes; // Tableau des neurones d'entrée
    private int nbNeuronnes; // Nombre de neurones dans la couche d'entrée
    private double[][] lesPoids; // Tableau des poids des connexions des neurones

    // Constructeur qui prend en paramètre un tableau d'entrées et le nombre de neurones dans la couche suivante
    public CoucheEntree(double input, int nbNeuronnes, int nbNeuronneCoucheSuivante) {
        this.nbNeuronnes = nbNeuronnes;
        this.neuronnes = new NeuroneEntree[nbNeuronnes]; // Initialisation du tableau de neurones

        // Initialisation des neurones d'entrée avec les valeurs d'entrée fournies
        for (int i = 0; i < nbNeuronnes; i++) {
            neuronnes[i] = new NeuroneEntree(input, nbNeuronneCoucheSuivante);
        }
    }

    // Méthode pour obtenir le nombre de neurones dans la couche
    @Override
    public int getNombreNeurones() {
        return nbNeuronnes;
    }

    // Méthode pour obtenir la liste des neurones d'entrée
    @Override
    public NeuroneEntree[] getNeurones() {
        return neuronnes; // Retourne la liste des neurones d'entrée
    }

    // Méthode pour définir les neurones de la couche
    public void setNeurones(List<NeuroneEntree> neurones) {
        this.neuronnes = neurones.toArray(new NeuroneEntree[0]); // Réinitialise la liste des neurones avec une nouvelle liste
    }

    // Méthode pour obtenir les poids des connexions des neurones de la couche d'entrée
    public double[][] getPoids() {
        lesPoids = new double[neuronnes.length][];
        for (int i = 0; i < neuronnes.length; i++) {
            lesPoids[i] = neuronnes[i].getPoids();
        }
        return lesPoids;
    }

    // Méthode pour calculer l'activation prime (dérivée de la fonction d'activation)
    public double[] activationPrime(double[] z) {
        double[] primes = new double[neuronnes.length];
        for (int i = 0; i < neuronnes.length; i++) {
            primes[i] = 1; // La dérivée de l'activation pour les neurones d'entrée est constante (1)
        }
        return primes;
    }

    // Méthode pour obtenir le type de la couche (ici, couche d'entrée)
    @Override
    public String getTypeCouche() {
        return "Entree";
    }

    // Méthode pour calculer la sortie des neurones de la couche d'entrée
    @Override
    public double[] sortie(double[] activations) {
        double[] sorties = new double[neuronnes.length];
        for (int i = 0; i < neuronnes.length; i++) {
            sorties[i] = neuronnes[i].Factivation(); // Calcule la sortie de chaque neurone
        }
        return sorties;
    }

    // Méthode pour mettre à jour les poids des neurones de la couche d'entrée
    @Override
    public void updateBiasesAndWeights(double[] nablaB, double[][] nablaW) {
        for (int i = 0; i < neuronnes.length; i++) {
            neuronnes[i].setPoids(nablaW[i]); // Met à jour les poids de chaque neurone
        }
    }

    // Méthode pour obtenir la sortie des neurones de la couche d'entrée
    @Override
    public double[] getSortie() {
        double[] sorties = new double[neuronnes.length];
        for (int i = 0; i < neuronnes.length; i++) {
            sorties[i] = neuronnes[i].Factivation(); // Calcule la sortie de chaque neurone après application de la fonction d'activation
        }
        return sorties;
    }

    // Méthode pour calculer les activations des neurones de la couche d'entrée
    @Override
    public double[] activation() {
        double[] activations = new double[neuronnes.length];
        for (int i = 0; i < neuronnes.length; i++) {
            activations[i] = neuronnes[i].Factivation(); // Calcule l'activation de chaque neurone
        }
        return activations;
    }

    // Méthode pour obtenir les valeurs z des neurones de la couche d'entrée en fonction des activations
    @Override
    public double[] getZ(double[] activation) {
        double[] zs = new double[neuronnes.length];
        for (int i = 0; i < neuronnes.length; i++) {
            zs[i] = neuronnes[i].getZ(); // Récupère les valeurs z de chaque neurone
        }
        return zs;
    }
}
