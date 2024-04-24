package LesCouches;

import LesNeurones.*;
import java.util.ArrayList;
import java.util.List;

public class CoucheEntree implements Couche<NeuroneEntree> {
    private NeuroneEntree [] neuronnes;
    private int nbNeuronnes ; 

    // Constructor that takes a list of neurons
    public CoucheEntree(double [] input, int nbNeuronnes,int nbNeuronneCoucheSuivante) {
        this.nbNeuronnes=nbNeuronnes ;
        for (i=0;i<nbNeuronnes ; i++)
        {
    	neruonnes[i] = new NeuronneEntree(input[i], nbNeuronneCoucheSuivante);
    }}

    @Override
    public int getNombreNeurones() {
        return neurones.size(); 
    }

    @Override
    public List<Neurone> getNeurones() {
        return neurones; // Return the list of neurons
    }


    @Override
    public void setNeurones(List<NeuroneEntree> neurones) {
        this.neurones = new ArrayList<>(neurones); // Reset the neuron list with a new list
    }

    @Override
    public String getTypeCouche() {
        return "Entree";
    }
}
