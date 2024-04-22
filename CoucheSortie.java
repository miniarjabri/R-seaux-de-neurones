package LesCouches;

import LesNeurones.*;
import java.util.ArrayList;
import java.util.List;

public class CoucheSortie implements Couche<NeuroneSortie> {
    private List<NeuroneSortie> neurones;

    // Constructor that takes a list of neurons
    public CoucheSortie(List<NeuroneSortie> neurones) {
        this.neurones = new ArrayList<>(neurones); 
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
