package ET;

public class LotEchantillon {
	private final List<Echantillon> samples;

    public LotEchantillons(List<Echantillon> samples) {
        this.samples = samples;
    }

    public List<Echantillon> getSamples() {
        return samples;
    }

    // Method to display all samples
    public void afficherEchantillons() {
        for (Echantillon sample : samples) {
            System.out.println("X: " + (sample.getX() ? 1 : 0) +
                               ", Y: " + (sample.getY() ? 1 : 0) +
                               ", X.AND.Y: " + (sample.getOutput() ? 1 : 0));
        }
    }
}
