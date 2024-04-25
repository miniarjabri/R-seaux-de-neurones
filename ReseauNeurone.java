package ReseauxDeNeurones;

import LesCouches.Couche;
import java.util.ArrayList;
import java.util.List;

public class ReseauNeurone {
	private Couche[] couches; // Liste des couches du réseau
    private int nombreCouches; // Nombre total de couches dans le réseau
    private int[] nbre_neurone_couche; // Un tableau contenant le nombre de neurones dans chaque couche
    private double[] input; // Données d'entrée
    private double output; // Sortie attendue
    private double[] expectedoutput; // Sortie attendue

    // Constructeur
    public ReseauNeurone(int nombreCouches, int[] nbre_neurone_couche, double[] input, double[] output) {
        // Initialiser le tableau de couches
        couches = new Couche[nombreCouches];
        
        // Créer la couche d'entrée
        couches[0] = new CoucheEntree(input, nbre_neurone_couche[0]);

        // Créer les couches cachées
        for (int i = 1; i < nombreCouches - 1; i++) {
            // Création d'une couche cachée avec le nombre de neurones spécifié et la fonction d'activation
            couches[i] = new CoucheCachee(nbre_neurone_couche[i], typeFonction, couches[i - 1].getNeurones(), nbre_neurone_couche[i + 1]);
        }
        
        // Créer la couche de sortie
        couches[nombreCouches - 1] = new CoucheSortie(nbre_neurone_couche[nombreCouches - 1]);
       
       this.output = output;
       expectedOutput = couches[nombreCouches - 1].getSortie(); 
    }

    // Entraînement du réseau
    public void entrainer(double[][] inputs, double[][] outputs, int epochs, double learningRate) {
        for (int epoch = 0; epoch < epochs; epoch++) {
            double totalError = 0.0;
            for (int i = 0; i < inputs.length; i++) {
                setInput(inputs[i]);
                setOutput(outputs[i]);

                propager();
                totalError += fonctionCout();
                retropropager();
            }
            System.out.println("Epoch " + (epoch + 1) + " - Erreur totale : " + totalError);
        }
    }

    // Méthode pour définir les données d'entrée
    private void setInput(double[] input) {
        if (input.length != this.input.length) {
            throw new IllegalArgumentException("Taille d'entrée invalide");
        }
        System.arraycopy(input, 0, this.input, 0, input.length);
    }

    // Méthode pour définir la sortie attendue
    private void setOutput(double[] output) {
        if (output.length != this.output.length) {
            throw new IllegalArgumentException("Taille de sortie invalide");
        }
        System.arraycopy(output, 0, this.output, 0, output.length);
    }

    // Calcul de l'erreur
    public double fonctionCout() {
        double error = 0.0;
        double[] sortiesActuelles = couches[couches.length - 1].getSortie();

        for (int k = 0; k < sortiesActuelles.length; k++) {
            error += Math.pow(sortiesActuelles[k] - output[k], 2);
        }

        return 0.5 * error;
    }

    // Rétropropagation
    public void retropropager() {
        for (int i = couches.length - 1; i > 0; i--) {
            couches[i].calculerGradient(expectedOutput, i == couches.length - 1);
            couches[i].mettreAJourPoids();
        }
    }

}
