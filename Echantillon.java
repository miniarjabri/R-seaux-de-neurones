package ET;

public class Echantillon extends ReseauNeurone {
    private float[] input;
    private float[] output;

    public Echantillon(float[] input, float[] output) {
        this.input = input;
        this.output = output;
    }

    public float[] getInput() {
        return input;
    }

    public float[] getOutput() {
        return output;
    }
}
