package LesCouches;

import LesNeurones.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoucheEntree implements Couche<NeuroneEntree>{
    private NeuroneEntree[] neuronnes; // Tableau des neurones d'entrée
    private int nbNeuronnes; // Nombre de neurones dans la couche d'entrée
    private double [][] lesPoids;


    // Constructeur qui prend en paramètre un tableau d'entrées et le nombre de neurones dans la couche suivante
    public CoucheEntree(double[] input, int nbNeuronnes, int nbNeuronneCoucheSuivante) {
        this.nbNeuronnes = nbNeuronnes;

        // Initialisation des neurones d'entrée avec les valeurs d'entrée fournies
        for (int i = 0; i < nbNeuronnes; i++) {
            neuronnes[i] = new NeuroneEntree(input[i], nbNeuronneCoucheSuivante);
        }
    }

    // Méthode pour obtenir le nombre de neurones dans la couche
    @Override
    public int getNombreNeurones() {
        return nbNeuronnes;
    }

    // Méthode pour obtenir la liste des neurones d'entrée
    public NeuroneEntree [] getNeurones() {
        return neuronnes; // Retourne la liste des neurones d'entrée
    }

    // Méthode pour définir les neurones de la couche
    public void setNeurones(List<NeuroneEntree> neurones) {
        this.neuronnes = neurones.toArray(new NeuroneEntree[0]); // Réinitialise la liste des neurones avec une nouvelle liste
    }
    public double[][] getPoids()
    {int i=0;
    	for (NeuroneEntree n:neuronnes)
    	{
    		lesPoids[i]=n.getPoids();
    		i++;
    		
    	}
    	return lesPoids;
    }

    // Méthode pour obtenir le type de la couche (ici, couche d'entrée)
    @Override
    public String getTypeCouche() {
        return "Entree";
    }
    public double[] sortie(double[] activations) {
        double[] sorties = new double[neuronnes.length];
        for (int i = 0; i < neuronnes.length; i++) {
            sorties[i] = neuronnes[i].Factivation();
        }
        return sorties;
    }
    public void updateBiasesAndWeights(double[] nablaB, double[][] nablaW) {
        for (int i = 0; i < neuronnes.length; i++) {
            neuronnes[i].setPoids(nablaW[i]);
        }
    }
    @Override
    public double[] getSortie() {
    double [] s=null;
    s[0]=0;
    return s;
}
    @Override
    public double[] activationPrime() 
    {double [] s=null;
    s[0]=0;
    return s;
}
}
