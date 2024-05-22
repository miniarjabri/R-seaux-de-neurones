package ReseauxDeNeurones;

import LesCouches.*;

import java.util.ArrayList;
import java.util.List;

public class ReseauNeurone {
    private Couche[] couches; // Liste des couches du réseau
    private int nombreCouches; // Nombre total de couches dans le réseau
    private int[] nbre_neurone_couche; // Un tableau contenant le nombre de neurones dans chaque couche
    private double[] input; // Données d'entrée
    private double[] output; // Sortie attendue
    private double[] expectedOutput; // Sortie attendue

    // Constructeur
    public ReseauNeurone(int nombreCouches, int[] nbre_neurone_couche, double[] input, double[][] output) {
        // Initialiser le tableau de couches
        
    	couches = new Couche[nombreCouches];

        // Initialiser les tableaux input et output
        this.input = new double[input.length];
        System.arraycopy(input, 0, this.input, 0, input.length);

        this.output = new double[output.length];
        for (int i = 0; i < output.length; i++) {
            this.output[i] = output[i][0]; // Supposons que la sortie est un seul nombre pour chaque échantillon
        }

        // Initialiser le tableau expectedOutput
        expectedOutput = new double[nbre_neurone_couche[nombreCouches - 1]];

        // Créer la couche d'entrée
        couches[0] = new CoucheEntree(input, nbre_neurone_couche[0],nbre_neurone_couche[1]);

        // Créer les couches cachées
        for (int i = 1; i < nombreCouches - 1; i++) {
            // Création d'une couche cachée avec le nombre de neurones spécifié et la fonction d'activation
            couches[i] = new CoucheCachee(nbre_neurone_couche[i], couches[i - 1].getNeurones(), nbre_neurone_couche[i + 1]);
        }

        // Créer la couche de sortie
        couches[nombreCouches - 1] = new CoucheSortie(nbre_neurone_couche[nombreCouches - 1],couches[nombreCouches - 1].getNeurones());

        expectedOutput = couches[nombreCouches - 1].getSortie();
    }

    // Méthode pour le passage en avant
    public double[] feedforward(double[] input) {
        double[] activations = input;
        for (int i = 0; i < nombreCouches; i++) {
            activations = couches[i].sortie(activations);
        }
        return activations;
    }

    // Méthode de rétropropagation pour ajuster les poids et les biais
    public void backpropagation(double[] input, double[] expectedOutput) {
        // Initialisation des gradients
        List<double[]> nablaB = new ArrayList<>();
        List<double[][]> nablaW = new ArrayList<>();

        // Initialiser les biais et les poids à zéro
        for (Couche couche : couches) {
            nablaB.add(new double[couche.getNombreNeurones()]);
            nablaW.add(new double[couche.getNombreNeurones()][couche.getNombreNeurones()]); // Simplification pour exemple
        }

        // Passage en avant
        double[] activation = input;
        List<double[]> activations = new ArrayList<>();
        activations.add(input);
        List<double[]> zs = new ArrayList<>();

        for (Couche couche : couches) {
            double[] z = couche.getZ(activation);
            zs.add(z);
            activation = couche.activation(z);
            activations.add(activation);
        }

        // Passage en arrière
        double[] delta = costDerivative(activations.get(activations.size() - 1), expectedOutput);
        //delta = hadamardProduct(delta, couches[nombreCouches - 1].activationPrime(zs.get(zs.size() - 1)));
      //delta = hadamardProduct(delta, couches[nombreCouches - 1].activationPrime(zs.get(zs.size() - 1)));

        
        nablaB.set(nablaB.size() - 1, delta);
        nablaW.set(nablaW.size() - 1, outerProduct(delta, activations.get(activations.size() - 2)));

        for (int l = 2; l < nombreCouches; l++) {
            double[] z = zs.get(zs.size() - l);
            double[] sp = couches[nombreCouches - l].activationPrime();
            double[][] transposedWeights = transpose(couches[nombreCouches - l + 1].getPoids());
            delta = matrixVectorProduct(transposedWeights, delta);
            delta = hadamardProduct(delta, sp);

            nablaB.set(nablaB.size() - l, delta);
            nablaW.set(nablaW.size() - l, outerProduct(delta, activations.get(activations.size() - l - 1)));
        }

        // Mise à jour des poids et des biais
        for (int i = 0; i < couches.length; i++) {
            couches[i].updateBiasesAndWeights(nablaB.get(i), nablaW.get(i));
        }
    }

    // Méthode pour entraîner le réseau neuronal
    public void train(int epochs, double learningRate) {
        for (int epoch = 0; epoch < epochs; epoch++) {
            for (int i = 0; i < input.length; i++) {
                backpropagation(input, output[i]);
            }
            System.out.println("Epoch " + epoch + " completed.");
        }
    }

    // Fonctions auxiliaires pour les opérations mathématiques
    private double[] costDerivative(double[] outputActivations, double[] y) {
        double[] result = new double[outputActivations.length];
        for (int i = 0; i < outputActivations.length; i++) {
            result[i] = outputActivations[i] - y[i];
        }
        return result;
    }

    private double[][] outerProduct(double[] a, double[] b) {
        double[][] result = new double[a.length][b.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                result[i][j] = a[i] * b[j];
            }
        }
        return result;
    }

    private double[] hadamardProduct(double[] a, double[] b) {
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] * b[i];
        }
        return result;
    }

    private double[][] transpose(double[][] matrix) {
        double[][] result = new double[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    private double[] matrixVectorProduct(double[][] matrix, double[] vector) {
        double[] result = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            result[i] = dotProduct(matrix[i], vector);
        }
        return result;
    }

    private double dotProduct(double[] a, double[] b) {
        double result = 0;
        for (int i = 0; i < a.length; i++) {
            result += a[i] * b[i];
        }
        return result;
    }
}
