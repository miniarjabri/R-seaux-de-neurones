package LotEchantillon;
public class youtube {
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.List;
	import java.util.Random;

	public class NeuralNetwork {
	    private int numLayers;
	    private int[] sizes;
	    private List<double[]> biases;
	    private List<double[][]> weights;
	    private Random random = new Random();

	    // Constructeur pour initialiser le réseau neuronal avec des tailles spécifiées pour chaque couche
	    public NeuralNetwork(int[] sizes) {
	        this.numLayers = sizes.length;
	        this.sizes = sizes;
	        this.biases = new ArrayList<>();
	        this.weights = new ArrayList<>();

	        // Initialisation des biais avec des valeurs aléatoires
	        for (int i = 1; i < sizes.length; i++) {
	            double[] bias = new double[sizes[i]];
	            for (int j = 0; j < sizes[i]; j++) {
	                bias[j] = random.nextGaussian();
	            }
	            this.biases.add(bias);
	        }

	        // Initialisation des poids avec des valeurs aléatoires
	        for (int i = 0; i < sizes.length - 1; i++) {
	            double[][] weight = new double[sizes[i + 1]][sizes[i]];
	            for (int j = 0; j < sizes[i + 1]; j++) {
	                for (int k = 0; k < sizes[i]; k++) {
	                    weight[j][k] = random.nextGaussian();
	                }
	            }
	            this.weights.add(weight);
	        }
	    }

	    // Méthode pour mettre à jour les mini-lots en utilisant la rétropropagation
	    public void updateMiniBatch(List<DataPoint> miniBatch, double eta) {
	        List<double[]> nablaB = new ArrayList<>();
	        List<double[][]> nablaW = new ArrayList<>();

	        for (double[] b : biases) {
	            nablaB.add(new double[b.length]);
	        }
	        for (double[][] w : weights) {
	            nablaW.add(new double[w.length][w[0].length]);
	        }

	        for (DataPoint point : miniBatch) {
	            Tuple<List<double[]>, List<double[][]>> deltaNabla = backprop(point.input, point.output);
	            List<double[]> deltaNablaB = deltaNabla.x;
	            List<double[][]> deltaNablaW = deltaNabla.y;

	            for (int i = 0; i < nablaB.size(); i++) {
	                double[] nb = nablaB.get(i);
	                double[] dnb = deltaNablaB.get(i);
	                for (int j = 0; j < nb.length; j++) {
	                    nb[j] += dnb[j];
	                }
	            }

	            for (int i = 0; i < nablaW.size(); i++) {
	                double[][] nw = nablaW.get(i);
	                double[][] dnw = deltaNablaW.get(i);
	                for (int j = 0; j < nw.length; j++) {
	                    for (int k = 0; k < nw[0].length; k++) {
	                        nw[j][k] += dnw[j][k];
	                    }
	                }
	            }
	        }

	        for (int i = 0; i < weights.size(); i++) {
	            double[][] w = weights.get(i);
	            double[][] nw = nablaW.get(i);
	            for (int j = 0; j < w.length; j++) {
	                for (int k = 0; k < w[0].length; k++) {
	                    w[j][k] -= eta / miniBatch.size() * nw[j][k];
	                }
	            }
	        }

	        for (int i = 0; i < biases.size(); i++) {
	            double[] b = biases.get(i);
	            double[] nb = nablaB.get(i);
	            for (int j = 0; j < b.length; j++) {
	                b[j] -= eta / miniBatch.size() * nb[j];
	            }
	        }
	    }

	    // Méthode de rétropropagation pour calculer les gradients
	    public Tuple<List<double[]>, List<double[][]>> backprop(double[] x, double[] y) {
	        List<double[]> nablaB = new ArrayList<>();
	        List<double[][]> nablaW = new ArrayList<>();

	        for (double[] b : biases) {
	            nablaB.add(new double[b.length]);
	        }
	        for (double[][] w : weights) {
	            nablaW.add(new double[w.length][w[0].length]);
	        }

	        double[] activation = x;
	        List<double[]> activations = new ArrayList<>();
	        activations.add(x);
	        List<double[]> zs = new ArrayList<>();

	        // Passage en avant
	        for (int i = 0; i < biases.size(); i++) {
	            double[] b = biases.get(i);
	            double[][] w = weights.get(i);
	            double[] z = new double[b.length];
	            for (int j = 0; j < b.length; j++) {
	                z[j] = dotProduct(w[j], activation) + b[j];
	            }
	            zs.add(z);
	            activation = sigmoid(z);
	            activations.add(activation);
	        }

	        // Passage en arrière
	        double[] delta = costDerivative(activations.get(activations.size() - 1), y);
	        double[] lastZ = zs.get(zs.size() - 1);
	        double[] sp = sigmoidPrime(lastZ);
	        for (int i = 0; i < delta.length; i++) {
	            delta[i] *= sp[i];
	        }

	        nablaB.set(nablaB.size() - 1, delta);
	        nablaW.set(nablaW.size() - 1, outerProduct(delta, activations.get(activations.size() - 2)));

	        for (int l = 2; l < numLayers; l++) {
	            double[] z = zs.get(zs.size() - l);
	            sp = sigmoidPrime(z);
	            double[][] transposedWeights = transpose(weights.get(weights.size() - l + 1));
	            delta = matrixVectorProduct(transposedWeights, delta);
	            for (int i = 0; i < delta.length; i++) {
	                delta[i] *= sp[i];
	            }
	            nablaB.set(nablaB.size() - l, delta);
	            nablaW.set(nablaW.size() - l, outerProduct(delta, activations.get(activations.size() - l - 1)));
	        }

	        return new Tuple<>(nablaB, nablaW);
	    }

	    // Méthode pour entraîner le réseau neuronal en utilisant la descente de gradient stochastique par mini-lots
	    public void SGD(List<DataPoint> trainingData, int epochs, int miniBatchSize, double eta, List<DataPoint> testData) {
	        int n = trainingData.size();
	        int nTest = testData != null ? testData.size() : 0;

	        for (int j = 0; j < epochs; j++) {
	            Collections.shuffle(trainingData);
	            List<List<DataPoint>> miniBatches = new ArrayList<>();
	            for (int k = 0; k < n; k += miniBatchSize) {
	                miniBatches.add(trainingData.subList(k, Math.min(k + miniBatchSize, n)));
	            }

	            for (List<DataPoint> miniBatch : miniBatches) {
	                updateMiniBatch(miniBatch, eta);
	            }

	            if (testData != null) {
	                System.out.printf("Epoch %d: %d / %d%n", j, evaluate(testData), nTest);
	            } else {
	                System.out.printf("Epoch %d complete%n", j);
	            }
	        }
	    }

	    // Méthode d'évaluation pour tester les performances du réseau sur les données de test
	    public int evaluate(List<DataPoint> testData) {
	        int correct = 0;
	        for (DataPoint point : testData) {
	            double[] output = feedforward(point.input);
	            int predicted = argMax(output);
	            int actual = argMax(point.output);
	            if (predicted == actual) {
	                correct++;
	            }
	        }
	        return correct;
	    }

	    // Méthode de propagation avant
	    public double[] feedforward(double[] x) {
	        double[] activation = x;
	        for (int i = 0; i < biases.size(); i++) {
	            double[] b = biases.get(i);
	            double[][] w = weights.get(i);
	            double[] z = new double[b.length];
	            for (int j = 0; j < b.length; j++) {
	                z[j] = dotProduct(w[j], activation) + b[j];
	            }
	            activation = sigmoid(z);
	        }
	        return activation;
	    }

	    // Fonction d'activation sigmoid
	    public double[] sigmoid(double[] z) {
	        double[] result = new double[z.length];
	        for (int i = 0; i < z.length; i++) {
	            result[i] = 1.0 / (1.0 + Math.exp(-z[i]));
	        }
	        return result;
	    }

	    // Dérivée de la fonction sigmoid
	    public double[] sigmoidPrime(double[] z) {
	        double[] sig = sigmoid(z);
	        double[] result = new double[z.length];
	        for (int i = 0; i < z.length; i++) {
	            result[i] = sig[i] * (1 - sig[i]);
	        }
	        return result;
	    }

	    // Fonction pour calculer la dérivée du coût
	    public double[] costDerivative(double[] outputActivations, double[] y) {
	        double[] result = new double[outputActivations.length];
	        for (int i = 0; i < outputActivations.length; i++) {
	            result[i] = outputActivations[i] - y[i];
	        }
	        return result;
	    }

	    // Fonction pour calculer le produit scalaire
	    public double dotProduct(double[] a, double[] b) {
	        double result = 0;
	        for (int i = 0; i < a.length; i++) {
	            result += a[i] * b[i];
	        }
	        return result;
	    }

	    // Fonction pour calculer le produit extérieur
	    public double[][] outerProduct(double[] a, double[] b) {
	        double[][] result = new double[a.length][b.length];
	        for (int i = 0; i < a.length; i++) {
	            for (int j = 0; j < b.length; j++) {
	                result[i][j] = a[i] * b[j];
	            }
	        }
	        return result;
	    }

	    // Fonction pour calculer le produit matrice-vecteur
	    public double[] matrixVectorProduct(double[][] matrix, double[] vector) {
	        double[] result = new double[matrix.length];
	        for (int i = 0; i < matrix.length; i++) {
	            result[i] = dotProduct(matrix[i], vector);
	        }
	        return result;
	    }

	    // Fonction pour transposer une matrice
	    public double[][] transpose(double[][] matrix) {
	        double[][] result = new double[matrix[0].length][matrix.length];
	        for (int i = 0; i < matrix.length; i++) {
	            for (int j = 0; j < matrix[0].length; j++) {
	                result[j][i] = matrix[i][j];
	            }
	        }
	        return result;
	    }

	    // Fonction pour trouver l'indice du maximum dans un tableau
	    public int argMax(double[] array) {
	        int maxIndex = 0;
	        for (int i = 1; i < array.length; i++) {
	            if (array[i] > array[maxIndex]) {
	                maxIndex = i;
	            }
	        }
	        return maxIndex;
	    }

	    // Classe pour représenter un point de données (entrée et sortie)
	    public static class DataPoint {
	        public double[] input;
	        public double[] output;

	        public DataPoint(double[] input, double[] output) {
	            this.input = input;
	            this.output = output;
	        }
	    }

	    // Classe générique pour représenter un tuple
	    public static class Tuple<X, Y> {
	        public final X x;
	        public final Y y;

	        public Tuple(X x, Y y) {
	            this.x = x;
	            this.y = y;
	        }
	    }

	    public static void main(String[] args) {
	        // Exemple d'utilisation du réseau neuronal
	        int[] sizes = {784, 30, 10}; // Exemple pour un réseau avec 784 entrées, une couche cachée de 30, et 10 sorties
	        NeuralNetwork nn = new NeuralNetwork(sizes);

	        // Exemple de création de données d'entraînement et de test
	        List<DataPoint> trainingData = new ArrayList<>();
	        List<DataPoint> testData = new ArrayList<>();

	        // Remplir les données d'entraînement et de test (à adapter selon les données réelles)

	        // Entraîner le réseau
	        nn.SGD(trainingData, 30, 10, 3.0, testData);
	    }
	}

}
