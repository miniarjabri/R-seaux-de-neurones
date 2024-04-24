package ET;

import ReseauxDeNeurones.ReseauNeurone;

public class Echantillon  {
    private float[] input;
    private float[] output;
    private ReseauNeurone reseau; 

    public Echantillon(float[] input, float[] output) {
        this.input = input;
        this.output = output;
        ReseauNeurone reseau = new ReseauNeurone (input, output);
    }

    public float[] getInput() {
        return input;
    }

    public float[] getOutput() {
        return output;
    }
     
}
