package LesCouches;

import LesNeurones.NeuroneEntree;
import java.util.List;

public class CoucheEntree implements Couche<NeuroneEntree> {
    private NeuroneEntree[] neuronnes; // Tableau des neurones d'entrée
    private int nbNeuronnes; // Nombre de neurones dans la couche d'entrée
    private double[][] lesPoids;

    // Constructeur qui prend en paramètre un tableau d'entrées et le nombre de neurones dans la couche suivante
    public CoucheEntree(double[] input, int nbNeuronnes, int nbNeuronneCoucheSuivante) {
        this.nbNeuronnes = nbNeuronnes;
        this.neuronnes = new NeuroneEntree[nbNeuronnes]; // Initialisation du tableau de neurones

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
    @Override
    public NeuroneEntree[] getNeurones() {
        return neuronnes; // Retourne la liste des neurones d'entrée
    }

    // Méthode pour définir les neurones de la couche
    public void setNeurones(List<NeuroneEntree> neurones) {
        this.neuronnes = neurones.toArray(new NeuroneEntree[0]); // Réinitialise la liste des neurones avec une nouvelle liste
    }

    public double[][] getPoids() {
        lesPoids = new double[neuronnes.length][];
        for (int i = 0; i < neuronnes.length; i++) {
            lesPoids[i] = neuronnes[i].getPoids();
        }
        return lesPoids;
    }

    // Méthode pour calculer l'activation prime
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

    @Override
    public double[] sortie(double[] activations) {
        double[] sorties = new double[neuronnes.length];
        for (int i = 0; i < neuronnes.length; i++) {
            sorties[i] = neuronnes[i].Factivation();
        }
        return sorties;
    }

    @Override
    public void updateBiasesAndWeights(double[] nablaB, double[][] nablaW) {
        for (int i = 0; i < neuronnes.length; i++) {
            neuronnes[i].setPoids(nablaW[i]);
        }
    }

    @Override
    public double[] getSortie() {
        double[] sorties = new double[neuronnes.length];
        for (int i = 0; i < neuronnes.length; i++) {
            sorties[i] = neuronnes[i].Factivation();
        }
        return sorties;
    }

    @Override
    public double[] activation() {
        double[] activations = new double[neuronnes.length];
        for (int i = 0; i < neuronnes.length; i++) {
            activations[i] = neuronnes[i].Factivation();
        }
        return activations;
    }

    @Override
    public double[] getZ(double[] activation) {
        double[] zs = new double[neuronnes.length];
        for (int i = 0; i < neuronnes.length; i++) {
            zs[i] = neuronnes[i].getZ();
        }
        return zs;
    }
}

/*package LesCouches;

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
 // Cette méthode se trouve également dans la classe Couche ou ses sous-classes.
    public double[] activationPrime(double[] z) {
        
    	double [] s=null;
        s[0]=0;
        return s;
        		
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
    public double[] activation() 
    {double [] s=null;
    s[0]=0;
    return s;
}

	@Override
	public double[] getZ(double[] activation) {
		// TODO Auto-generated method stub
		return null;
	}
}*/
