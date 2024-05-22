package echantillon;

	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.List;

	public class Train {
	    private List<double[]> images;
	    private List<Integer> labels;

	    public Train(double[][] images, int[] labels) {
	        this.images = new ArrayList<>();
	        this.labels = new ArrayList<>();
	        for (int i = 0; i < images.length; i++) {
	            this.images.add(images[i]);
	            this.labels.add(labels[i]);
	        }
	    }

	    public List<MiniBatch> createMiniBatches(int miniBatchSize) {
	        List<MiniBatch> miniBatches = new ArrayList<>();
	        List<Integer> indices = new ArrayList<>();
	        for (int i = 0; i < images.size(); i++) {
	            indices.add(i);
	        }
	        Collections.shuffle(indices);

	        for (int i = 0; i < images.size(); i += miniBatchSize) {
	            List<double[]> miniBatchImages = new ArrayList<>();
	            List<Integer> miniBatchLabels = new ArrayList<>();
	            for (int j = 0; j < miniBatchSize && i + j < images.size(); j++) {
	                miniBatchImages.add(images.get(indices.get(i + j)));
	                miniBatchLabels.add(labels.get(indices.get(i + j)));
	            }
	            miniBatches.add(new MiniBatch(miniBatchImages, miniBatchLabels));
	        }
	        
	        return miniBatches;
	    }

	    public static class MiniBatch {
	        public List<double[]> images;
	        public List<Integer> labels;

	        public MiniBatch(List<double[]> images, List<Integer> labels) {
	            this.images = images;
	            this.labels = labels;
	        }
	    }
public  static void main(String[] args) throws IOException {
	        int inputLayerSize = 784; // 28 * 28 pixels
	        int hiddenLayerSize = 100; // Choisissez une taille appropriée
	        int outputLayerSize = 10; // 10 classes pour les chiffres 0-9

	        double learningRate = 0.01;
	        double momentum = 0.9;

	        NeuralNetwork nn = new NeuralNetwork(inputLayerSize, hiddenLayerSize, outputLayerSize, learningRate, momentum);

	        // Charger les données MNIST
	        double[][] trainingData = MNISTLoader.loadImages("train-images.idx3-ubyte");
	        int[] trainingLabels = MNISTLoader.loadLabels("train-labels.idx1-ubyte");

	        LotEchantillons lotEchantillons = new LotEchantillons(trainingData, trainingLabels);

	        int epochs = 10;
	        int miniBatchSize = 10;

	        // Entraîner le réseau de neurones
	        for (int epoch = 0; epoch < epochs; epoch++) {
	            List<LotEchantillons.MiniBatch> miniBatches = lotEchantillons.createMiniBatches(miniBatchSize);
	            for (LotEchantillons.MiniBatch miniBatch : miniBatches) {
	                nn.updateMiniBatch(miniBatch.images, miniBatch.labels);
	            }
	            System.out.println("Epoch " + epoch + " complete");
	        }

	        // Évaluation du réseau de neurones
	        double[][] testData = MNISTLoader.loadImages("t10k-images.idx3-ubyte");
	        int[] testLabels = MNISTLoader.loadLabels("t10k-labels.idx1-ubyte");

	        int correct = 0;
	        for (int i = 0; i < testData.length; i++) {
	            double[] output = nn.forward(testData[i]);
	            int predictedLabel = argMax(output);
	            if (predictedLabel == testLabels[i]) {
	                correct++;
	            }
	        }

	        double accuracy = (double) correct / testData.length;
	        System.out.println("Accuracy: " + accuracy);
	    }

	    private static int argMax(double[] array) {
	        int maxIndex = 0;
	        for (int i = 1; i < array.length; i++) {
	            if (array[i] > array[maxIndex]) {
	                maxIndex = i;
	            }
	        }
	        return maxIndex;
	    }
	}

