package LesCouches;

import LesNeurones.*;

import java.util.List;

public class CoucheCachee implements Couche<NeuroneCache> {
    private NeuroneCache[] neuronnes; // Tableau des neurones de la couche cachée
    private int nbNeuronne; // Nombre de neurones dans la couche cachée
    private double[] lesSeuils;
    private double[][] lesPoids;
    private double[] z;

    // Constructeur prenant en paramètres le nombre de neurones, le type de fonction, une liste de neurones et le nombre de neurones dans la couche suivante
    /*public CoucheCachee(int nbNeuronne, Object[] objects, int nbreNeuronneCoucheSuivante) {
        this.nbNeuronne = nbNeuronne;
        this.neuronnes = new NeuroneCache[nbNeuronne]; // Initialize the neuron array

        // Initialisation des neurones de la couche cachée avec les paramètres fournis
        for (int i = 0; i < nbNeuronne; i++) {
        	if (i==1) {
            neuronnes[i] = new NeuroneCache((NeuroneEntree[]) objects, i, nbreNeuronneCoucheSuivante);
        }
        	else {
            neuronnes[i] = new NeuroneCache((NeuroneCache[]) objects, i, nbreNeuronneCoucheSuivante);}
        }
    }*/
 // Constructeur prenant en paramètres le nombre de neurones, le type de fonction, une liste de neurones et le nombre de neurones dans la couche suivante
    public CoucheCachee(int nbNeuronne,NeuroneCache[] n , int nbreNeuronneCoucheSuivante) {
        this.nbNeuronne = nbNeuronne;
        this.neuronnes = new NeuroneCache[nbNeuronne]; // Initialize the neuron array
        this.lesSeuils = new double[nbNeuronne];
        this.lesPoids = new double[nbNeuronne][];
        // Initialisation des neurones de la couche cachée avec les paramètres fournis
        for (int i = 0; i < nbNeuronne; i++) {
            neuronnes[i] = new NeuroneCache(n, i, nbreNeuronneCoucheSuivante);
        }
    }
    public CoucheCachee(int nbNeuronne,NeuroneEntree[] n , int nbreNeuronneCoucheSuivante) {
        this.nbNeuronne = nbNeuronne;
        this.neuronnes = new NeuroneCache[nbNeuronne]; // Initialize the neuron array
        this.lesSeuils = new double[nbNeuronne];
        this.lesPoids = new double[nbNeuronne][];
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

    public double[] getBiaises() {
        for (int i = 0; i < neuronnes.length; i++) {
            lesSeuils[i] = neuronnes[i].getBiais();
        }
        return lesSeuils;
    }

    public double[][] getPoids() {
        for (int i = 0; i < neuronnes.length; i++) {
            lesPoids[i] = neuronnes[i].getPoids();
        }
        return lesPoids;
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
            neuronnes[i].setBiais(nablaB[i]);
            neuronnes[i].setPoids(nablaW[i]);
        }
    }

    public double[] getZ() {
        double[] z = new double[neuronnes.length];
        for (int i = 0; i < neuronnes.length; i++) {
            z[i] = neuronnes[i].getSomme();
        }
        return z;
    }

    public double[] activation() {
        double[] LesDeriveesActivations = new double[neuronnes.length];
        for (int i = 0; i < neuronnes.length; i++) {
            LesDeriveesActivations[i] = neuronnes[i].DeriveeActivation();
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

    @Override
    public double[] getZ(double[] activations) {
        double[] z = new double[neuronnes.length];
        for (int i = 0; i < neuronnes.length; i++) {
            z[i] = neuronnes[i].getZ();
        }
        return z;
    }

    // Méthode pour obtenir le type de la couche (ici, couche cachée)
    @Override
    public String getTypeCouche() {
        return "Cachee";
    }

    @Override
    public double[] getSortie() {
        double[] s = new double[neuronnes.length];
        for (int i = 0; i < neuronnes.length; i++) {
            s[i] = neuronnes[i].Factivation();
        }
        return s;
    }
}

/*package LesCouches;

import LesNeurones.*;

import java.util.List;

public class CoucheCachee implements Couche <NeuroneCache>{
    private NeuroneCache[] neuronnes; // Tableau des neurones de la couche cachée
    private int nbNeuronne; // Nombre de neurones dans la couche cachée
    private double [] lesSeuils;
    private double [][] lesPoids;
    private double [] z;

    // Constructeur prenant en paramètres le nombre de neurones, le type de fonction, une liste de neurones et le nombre de neurones dans la couche suivante
    public CoucheCachee(int nbNeuronne, Object[] objects, int nbreNeuronneCoucheSuivante) {
        this.nbNeuronne = nbNeuronne;
        this.neuronnes = new NeuroneCache[nbNeuronne]; // Initialize the neuron array

        // Initialisation des neurones de la couche cachée avec les paramètres fournis
        for (int i = 0; i < nbNeuronne; i++) {
            neuronnes[i] = new NeuroneCache((Neuronne[]) objects, i, nbreNeuronneCoucheSuivante);
        }
    }

	// Méthode pour obtenir le nombre de neurones dans la couche
    @Override
    public int getNombreNeurones() {
        return nbNeuronne;
    }
    @Override
    // Méthode pour obtenir la liste des neurones de la couche cachée
    public NeuroneCache [] getNeurones() {
        return neuronnes; // Retourne la liste des neurones de la couche cachée
    }

    // Méthode pour définir les neurones de la couche cachée
    public void setNeurones(List<NeuroneCache> neurones) {
        this.neuronnes = neurones.toArray(new NeuroneCache[0]); // Réinitialise la liste des neurones avec une nouvelle liste
    }
    public double[] getBiaises()
    {int i=0;
    	for (NeuroneCache n:neuronnes)
    	{
    		lesSeuils[i]=n.getBiais();
    		i++;
    		
    	}
    	return lesSeuils;
    }
    public double[][] getPoids()
    {int i=0;
    	for (NeuroneCache n:neuronnes)
    	{
    		lesPoids[i]=n.getPoids();
    		i++;
    		
    	}
    	return lesPoids;
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
            neuronnes[i].setBiais(nablaB[i]);
            neuronnes[i].setPoids(nablaW[i]);
        }
    }
    public double [] getZ()
    {double []z=new double[neuronnes.length];
    	 for (int i = 0; i < neuronnes.length; i++) {
    	z[i]=neuronnes[i].getSomme();
    }
    	 return z;
    }
    public double[] activation() {
        double[] LesDeriveesActivations=new double[neuronnes.length];
        for (int i = 0; i < neuronnes.length; i++) {
             LesDeriveesActivations[i] = neuronnes[i].DeriveeActivation();
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

    @Override
    public double[] getZ(double[] activations) {
        double[] z = new double[neuronnes.length];
        for (int i = 0; i < neuronnes.length; i++) {
            z[i] = neuronnes[i].getZ();
        }
        return z;
    }
    // Méthode pour obtenir le type de la couche (ici, couche cachée)
    @Override
    public String getTypeCouche() {
        return "Cachee";}
     @Override
     public double[] getSortie( ) {
     double [] s=null;
     s[0]=0;
     return s;
     
}
}*/