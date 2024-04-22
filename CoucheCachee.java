package LesCouches;

import LesNeurones.*;
import java.util.ArrayList;
import java.util.List;

public class CoucheCachee implements Couche<NeuroneCachee> {
    private List<Neurone> neurones;

    // Constructor that takes a list of neurons
    public CoucheCachee(List<NeuroneCachee> neurones) {
        this.neurones = new ArrayList<>(neurones); 
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
