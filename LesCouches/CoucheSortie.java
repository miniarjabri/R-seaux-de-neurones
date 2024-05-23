package LesCouches;

import LesNeurones.*;
import java.util.ArrayList;
import java.util.List;

public class CoucheSortie implements Couche<NeuroneSortie> {
    private NeuroneSortie[] neurones; // Tableau des neurones de la couche de sortie
    private int nbNeurone;
    private double [] lesSeuils;
    private double [][] lesPoids;

    // Constructeur prenant en paramètres le nombre de neurones, le type de fonction et une liste de neurones
    public CoucheSortie(int nbNeuronne, NeuroneCache[] n) {
        this.nbNeurone = nbNeuronne;
        this.neurones = new NeuroneSortie[nbNeuronne]; // Initialize the neuron array
        this.lesSeuils = new double[nbNeuronne];
        this.lesPoids = new double[nbNeuronne][];
        // Initialisation des neurones de la couche de sortie avec les paramètres fournis
        for (int i = 0; i < nbNeuronne; i++) {
            neurones[i] = new NeuroneSortie( n, i);
        }
    }
    public CoucheSortie(int nbNeuronne, NeuroneEntree[] n) {
        this.nbNeurone = nbNeuronne;
        this.neurones = new NeuroneSortie[nbNeuronne]; // Initialize the neuron array
        this.lesSeuils = new double[nbNeuronne];
        this.lesPoids = new double[nbNeuronne][];
        // Initialisation des neurones de la couche de sortie avec les paramètres fournis
        for (int i = 0; i < nbNeuronne; i++) {
            neurones[i] = new NeuroneSortie( n, i);
        }
    }
    // Méthode pour obtenir le nombre de neurones dans la couche
    @Override
    public int getNombreNeurones() {
        return neurones.length; // Return the length of the neuron array
    }

    // Méthode pour obtenir la liste des neurones de la couche de sortie
    // Méthode pour obtenir la liste des neurones d'entrée
    @Override
    public NeuroneSortie[] getNeurones() {
        return neurones; // Retourne la liste des neurones d'entrée
    }

    // Méthode pour définir les neurones de la couche de sortie
    public void setNeurones(List<NeuroneSortie> neurones) {
        this.neurones = neurones.toArray(new NeuroneSortie[0]); // Reinitialize the neuron array with a new list
    }
    public double[] getBiaises()
    {int i=0;
    	for (NeuroneSortie n:neurones)
    	{
    		lesSeuils[i]=n.getBiais();
    		i++;
    		
    	}
    	return lesSeuils;
    }
    public double[][] getPoids()
    {double[][] s=null;
    s[0][0]=0;
    	return s;
    }
    public double[] sortie(double[] activations) {
        double[] sorties = new double[neurones.length];
        for (int i = 0; i < neurones.length; i++) {
            sorties[i] = neurones[i].Factivation();
        }
        return sorties;
    }
    public void updateBiasesAndWeights(double[] nablaB, double[][] nablaW) {
        for (int i = 0; i < neurones.length; i++) {
            neurones[i].setBiais(nablaB[i]);
            neurones[i].setPoids(nablaW[i]);
        }
    }
    public double [] getZ()
    {double []z=new double[neurones.length];
    	 for (int i = 0; i < neurones.length; i++) {
    	z[i]=neurones[i].getSomme();
    }
    	 return z;
    }
    public double[] activation() {
        double[] LesDeriveesActivations=new double[neurones.length];
        for (int i = 0; i < neurones.length; i++) {
             LesDeriveesActivations[i] = neurones[i].DeriveeActivation();
        }
        return LesDeriveesActivations;
    }
 // Cette méthode se trouve également dans la classe Couche ou ses sous-classes.
    public double[] activationPrime(double[] z) {
        // Implémentation dépend de la fonction d'activation spécifique utilisée par la couche
        // Par exemple, pour une fonction d'activation sigmoïde :
        double[] result = new double[z.length];
        for (int i = 0; i < z.length; i++) {
            double sigmoid = 1.0 / (1.0 + Math.exp(-z[i]));
            result[i] = sigmoid * (1 - sigmoid);
        }
        return result;
    }
    

    // Méthode pour obtenir le type de la couche (ici, couche de sortie)
    @Override
    public String getTypeCouche() {
        return "Sortie";
    }
    @Override
    public double[] getSortie() {
    	double []s=null;
    	for (int i=0;i<nbNeurone;i++)
    	{s[i]=neurones[i].Factivation( );
    }
    	return s;
}

    @Override
    public double[] getZ(double[] activations) {
        double[] z = new double[neurones.length];
        for (int i = 0; i < neurones.length; i++) {
            z[i] = neurones[i].getZ();
        }
        return z;
    }
}