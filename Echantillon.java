package ET;

import ReseauxDeNeurones.ReseauNeurone;

public class Echantillon {
    private float[] input; // Les données d'entrée de l'échantillon
    private float[] output; // Les données de sortie attendues de l'échantillon
    private ReseauNeurone reseau; // Le réseau de neurones associé à l'échantillon

    // Constructeur pour initialiser l'échantillon avec les données d'entrée et de sortie
    public Echantillon(float[] input, float[] output) {
        this.input = input;
        this.output = output;
        // Création d'une instance du réseau de neurones associée à cet échantillon
        // REMARQUE : Cela ne semble pas être la bonne approche car vous instanciez un nouveau réseau ici sans utiliser la référence locale
        // Vous devriez plutôt initialiser le réseau à partir d'un paramètre ou d'une référence externe
        ReseauNeurone reseau = new ReseauNeurone(input, output);
    }

    // Méthode pour récupérer les données d'entrée de l'échantillon
    public float[] getInput() {
        return input;
    }

    // Méthode pour récupérer les données de sortie attendues de l'échantillon
    public float[] getOutput() {
        return output;
    }

}
