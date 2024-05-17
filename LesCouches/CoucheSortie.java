package LesCouches;

import LesNeurones.*;
import java.util.ArrayList;
import java.util.List;

public class CoucheSortie implements Couche<NeuroneSortie> {
    private NeuroneSortie[] neurones; // Tableau des neurones de la couche de sortie
    private int nbNeurone;

    // Constructeur prenant en paramètres le nombre de neurones, le type de fonction et une liste de neurones
    public CoucheSortie(int nbNeuronne, String typeFonction, Object[] objects) {
        this.nbNeurone = nbNeuronne;
        this.neurones = new NeuroneSortie[nbNeuronne]; // Initialize the neuron array

        // Initialisation des neurones de la couche de sortie avec les paramètres fournis
        for (int i = 0; i < nbNeuronne; i++) {
            neurones[i] = new NeuroneSortie(typeFonction, (Neuronne[]) objects, i);
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

    // Méthode pour obtenir le type de la couche (ici, couche de sortie)
    @Override
    public String getTypeCouche() {
        return "Sortie";
    }
    @Override
    public double[] getSortie(String TypeFonction) {
    	double []s=null;
    	for (int i=0;i<nbNeurone;i++)
    	{s[i]=neurones[i].Factivation( TypeFonction);
    }
    	return s;
}
}