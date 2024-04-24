package LesCouches;

import LesNeurones.*;
import java.util.ArrayList;
import java.util.List;

public class CoucheSortie implements Couche<NeuroneSortie> {
    private NeuronneSortie [] neurones;

    // Constructor that takes a list of neurons
        public  CoucheSortie( int nbNeuronne, String typeFonction, Neuronne[] n ) {
        	this.nbNeuronne=nbNeuronne;
            for (int i=0  ; i<nbNeuronne ; i++)
            {
            	neurones[i]=new NeruonneCachee(typeFonction , n ,i);
            }
        }

    @Override
    public int getNombreNeurones() {
        return neurones.size(); 
    }

    @Override
    public List<NeuroneSortie> getNeurones() {
        return neurones; // Return the list of neurons
    }


    @Override
    public void setNeurones(List<NeuroneSortie> neurones) {
        this.neurones = new ArrayList<>(neurones); // Reset the neuron list with a new list
    }

    @Override
    public String getTypeCouche() {
        return "Sortie";
    }
}
