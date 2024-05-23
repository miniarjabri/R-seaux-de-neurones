package LesNeurones;

public abstract class Neuronne {
    protected double[] poids; // Les poids des connexions vers ce neurone
    protected double biais; // Le biais du neurone
    protected double activation; // L'activation du neurone

    // Constructeur pour initialiser les poids et le biais
    public Neuronne(int nombreConnexions) {
        this.poids = new double[nombreConnexions];
        this.biais = Math.random(); // Initialisation aléatoire du biais
    }

    // Méthode abstraite pour calculer l'activation du neurone
    public abstract void calculerActivation(double[] entrees);

    // Méthode pour obtenir les poids des connexions vers ce neurone
    public double[] getPoids() {
        return poids;
    }

    // Méthode pour obtenir le biais du neurone
    public double getBiais() {
        return biais;
    }

    // Méthode pour obtenir l'activation du neurone
    public double getActivation() {
        return activation;
    }
}
