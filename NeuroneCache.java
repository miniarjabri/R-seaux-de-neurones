package LesNeurones;

import java.util.Arrays;

public class NeuroneCache {
    private double[] poids;
    private double biais;
    private int position;
    
    // Constructor to initialize the neuron with weights, bias, and position
    public NeuroneCache(double[] poids, double biais, int position) {
        this.poids = Arrays.copyOf(poids, poids.length); // Copying the weights to ensure encapsulation
        this.biais = biais;
        this.position = position;
    }


    public void setPoids(double[] poids) {
        this.poids = Arrays.copyOf(poids, poids.length);
    }

    public double[] getPoids() {
        return this.poids;
    }
    public void setBiais(double biais) {
        this.biais = biais;
    }

    public double getBiais() {
        return this.biais;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public double agregation(Object[] n) {
	    double z = biais;
	    for (Object neuron : n) {
	        if (neuron instanceof NeuroneEntree) {
	            NeuroneEntree entree = (NeuroneEntree) neuron;
	            z += entree.getPoids()[position] * entree.activation();  
	        } else if (neuron instanceof NeuroneCachee) {
	            NeuroneCachee cachee = (NeuroneCachee) neuron;
	            z += cachee.getPoids()[position] * cachee.activation();
	        }
	    }
	    return z;
	}

// Placeholder for the activation method to avoid recursion
   public double activation() {
	    return 1 / (1 + Math.exp(-this.agregation(new Object[]{this})));
	}
 }
