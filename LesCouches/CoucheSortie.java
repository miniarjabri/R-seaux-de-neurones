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
    public CoucheSortie(int nbNeuronne, Object[] objects) {
        this.nbNeurone = nbNeuronne;
        this.neurones = new NeuroneSortie[nbNeuronne]; // Initialize the neuron array

        // Initialisation des neurones de la couche de sortie avec les paramètres fournis
        for (int i = 0; i < nbNeuronne; i++) {
            neurones[i] = new NeuroneSortie( (Neuronne[]) objects, i);
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
    public NeuroneSortie [] getNeurones() {
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
    public double[] activationPrime() {
        double[] LesDeriveesActivations=new double[neurones.length];
        for (int i = 0; i < neurones.length; i++) {
             LesDeriveesActivations[i] = neurones[i].DeriveeActivation();
        }
        return LesDeriveesActivations;
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
}