package LesCouches;

import LesNeurones.*;
import java.util.ArrayList;
import java.util.List;

public class CoucheCachee implements Couche<NeuroneCachee> {
    private NeuroneCachee  [] neuronnes;
    private int nbNeuronne;

    // Constructor that takes a list of neurons
    public CoucheCachee( int nbNeuronne, String typeFonction, Neuronne[] n, int nbreNeuronneCoucheSuivante ) {
    	this.nbNeuronne=nbNeuronne;
        for (int i=0  ; i<nbNeuronne ; i++)
        {
        	neuronnes[i]=new NeuronneCachee(typeFonction , n ,i, nbreNeuronneCoucheSuivante );
        }
    }

    @Override
    public int getNombreNeurones() {
        return neurones.size(); 
    }

    @Override
    public List<NeuroneCachee> getNeurones() {
        return neurones; // Return the list of neurons
    }


    @Override
    public void setNeurones (List<NeuroneCachee> neurones) {
        this.neurones = new ArrayList<>(neurones); // Reset the neuron list with a new list
    }

    @Override
    public String getTypeCouche() {
        return "Cachee";
    }
}
