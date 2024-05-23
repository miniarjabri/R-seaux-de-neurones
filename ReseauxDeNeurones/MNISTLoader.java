package ReseauxDeNeurones;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MNISTLoader {
    private static final int IMAGE_SIZE = 28 * 28; // Each image is 28x28 pixels

    public static List<double[]> loadImages(String path) throws IOException {
        List<double[]> images = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(path))) {
            int magicNumber = dis.readInt();
            int numberOfImages = dis.readInt();
            int numberOfRows = dis.readInt();
            int numberOfColumns = dis.readInt();

            for (int i = 0; i < numberOfImages; i++) {
                double[] image = new double[IMAGE_SIZE];
                for (int j = 0; j < IMAGE_SIZE; j++) {
                    image[j] = dis.readUnsignedByte() / 255.0; // Normalize pixel values
                }
                images.add(image);
            }
        }
        return images;
    }

    public static List<double[]> loadLabels(String path) throws IOException {
        List<double[]> labels = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(path))) {
            int magicNumber = dis.readInt();
            int numberOfLabels = dis.readInt();

            for (int i = 0; i < numberOfLabels; i++) {
                double[] label = new double[10];
                int digit = dis.readUnsignedByte();
                label[digit] = 1.0;
                labels.add(label);
            }
        }
        return labels;
    }
}
