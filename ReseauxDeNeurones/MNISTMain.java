package ReseauxDeNeurones;

import java.io.IOException;
import java.util.List;

public class MNISTMain {
    public static void main(String[] args) throws IOException {
        // Charger les données
        List<double[]> trainImages = MNISTLoader.loadImages("train-images.idx3-ubyte");
        List<double[]> trainLabels = MNISTLoader.loadLabels("train-labels.idx1-ubyte");
        List<double[]> testImages  = MNISTLoader.loadImages("t10k-images.idx3-ubyte");
        List<double[]> testLabels  = MNISTLoader.loadLabels("t10k-labels.idx1-ubyte");

        // Convertir les données d'entraînement en tableaux
        double[][] input = new double[trainImages.size()][];
        double[][] output = new double[trainLabels.size()][];
        for (int i = 0; i < trainImages.size(); i++) {
            input[i] = trainImages.get(i);
            output[i] = trainLabels.get(i);
        }

        // Convertir les données de test en tableaux
        double[][] testInput = new double[testImages.size()][];
        double[][] testOutput = new double[testLabels.size()][];
        for (int i = 0; i < testImages.size(); i++) {
            testInput[i] = testImages.get(i);
            testOutput[i] = testLabels.get(i);
        }

        // Définir la structure du réseau
        int[] nbreNeuroneCouche = {784, 128, 64, 10};

        // Initialiser le réseau de neurones
        ReseauNeurone reseau = new ReseauNeurone(nbreNeuroneCouche.length, nbreNeuroneCouche, input, output);

        // Entraîner le réseau
        reseau.train(10, 0.01); // Par exemple, 10 époques avec un taux d'apprentissage de 0.01

        // Évaluer le réseau
        double accuracy = reseau.evaluate(testInput, testOutput);
        System.out.println("Accuracy: " + accuracy);

        // Évaluation de précision ou autres métriques
        System.out.println("Training completed.");
    }
}

/*
import java.io.IOException;
import java.util.List;
public class MNISTMain {
    public static void main(String[] args) throws IOException {
        // Charger les données
    	List<double[]> trainImages = MNISTLoader.loadImages("train-images.idx3-ubyte");
        List<double[]> trainLabels = MNISTLoader.loadLabels("train-labels.idx1-ubyte");
        List<double[]> testImages  = MNISTLoader.loadImages("mnist/t10k-images.idx3-ubyte");
        List<double[]> testLabels  = MNISTLoader.loadLabels("mnist/t10k-labels.idx1-ubyte");



        // Convertir les données en tableaux
        double[][] input = new double[trainImages.size()][];
        double[][] output = new double[trainLabels.size()][];

        for (int i = 0; i < trainImages.size(); i++) {
            input[i] = trainImages.get(i);
            output[i] = trainLabels.get(i);
        }

        // Définir la structure du réseau
        int[] nbreNeuroneCouche = {784, 128, 64, 10};

        // Initialiser le réseau de neurones
        ReseauNeurone reseau = new ReseauNeurone(nbreNeuroneCouche.length, nbreNeuroneCouche, input, output);

        // Entraîner le réseau
        reseau.train(10, 0.01); // Par exemple, 10 époques avec un taux d'apprentissage de 0.01

  
     // Évaluer le réseau
        double accuracy = reseau.evaluate(testImages, testLabels);
        System.out.println("Accuracy: " + accuracy);
        
        // évaluation de précision ou autres métriques
        System.out.println("Training completed.");
    }
}*/