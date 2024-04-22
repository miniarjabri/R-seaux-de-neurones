package LesNeurones;

import java.util.Arrays;

public class NeuroneEntree  {

    private    double[] poids;
    private double firstActivation;  // This should probably be a double, not an int
    private final double agregation = 0;
   
    // Constructor
    public NeuroneEntree(double[] poids, double firstActivation) {
        this.firstActivation = firstActivation;
        this.poids = Arrays.copyOf(poids, poids.length);
    }

    
    public void setPoids(double[] poids) {
        this.poids = Arrays.copyOf(poids, poids.length);
    }

    public double[] getPoids() {
        return Arrays.copyOf(poids, poids.length);
    }

    public double getBiais() {
        return 0;
    }

    public double activation() {
        return firstActivation;  
    }
    
    public void setActivation(double activation) {
        this.firstActivation = activation;
    }
    
}
