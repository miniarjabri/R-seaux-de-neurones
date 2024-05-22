package echantillon;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class MNISTLoader {
    public static double[][] loadImages(String path) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(path));
        
        int magicNumber = dis.readInt();
        if (magicNumber != 2051) {
            throw new IOException("Invalid magic number: " + magicNumber);
        }
        
        int numberOfImages = dis.readInt();
        int rows = dis.readInt();
        int columns = dis.readInt();
        
        double[][] images = new double[numberOfImages][rows * columns];
        for (int i = 0; i < numberOfImages; i++) {
            for (int j = 0; j < rows * columns; j++) {
                images[i][j] = dis.readUnsignedByte() / 255.0;
            }
        }
        
        dis.close();
        return images;
    }

    public static int[] loadLabels(String path) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(path));
        
        int magicNumber = dis.readInt();
        if (magicNumber != 2049) {
            throw new IOException("Invalid magic number: " + magicNumber);
        }
        
        int numberOfLabels = dis.readInt();
        
        int[] labels = new int[numberOfLabels];
        for (int i = 0; i < numberOfLabels; i++) {
            labels[i] = dis.readUnsignedByte();
        }
        
        dis.close();
        return labels;
    }
}

