package LesNeurones;

import java.util.Arrays;
import java.util.Random;

public class NeuroneSortie {

    private double[] poids; // Les poids des connexions entre ce neurone et les neurones de la couche précédente
    private double biais; // Le biais (seuil) du neurone
    private int position; // La position du neurone dans la couche
    private String typeFonction; // Le type de fonction d'activation utilisée par le neurone
    private double agregation; // La somme pondérée des entrées du neurone
    private double activation; // La sortie du neurone après l'application de la fonction d'activation

    // Constructeur pour initialiser le neurone avec ses poids, son biais et sa position
    public NeuroneSortie(String typeFonction, Neuronne[] n, int position) {
        Random random = new Random();
        biais = random.nextDouble(); // Initialisation aléatoire du biais

        this.position = position; // Position du neurone dans la couche

        // Calcul de l'agrégation du neurone
        agregation = sommePonderee(n, position) + biais;

        // Calcul de l'activation du neurone
        activation = Factivation(agregation, typeFonction);
    }

    // Méthode pour calculer la somme pondérée des entrées
    double sommePonderee(Neuronne[] n, int pos) {
        double somme = 0.0;
        for (int i = 0; i < pos; i++) {
            somme += n[i].getPoids()[pos] * n[i].getActivation();
        }
        return somme;
    }

    // Méthodes setter et getter pour les poids
    public void setPoids(double[] poids) {
        this.poids = Arrays.copyOf(poids, poids.length);
    }

    public double[] getPoids() {
        return this.poids;
    }

    // Méthodes setter et getter pour le biais
    public void setBiais(double biais) {
        this.biais = biais;
    }

    public double getBiais() {
        return this.biais;
    }

    // Méthodes setter et getter pour la position du neurone dans la couche
    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    // Méthode pour l'activation du neurone
    public double Factivation(double z, String TypeFonction) {
        if (TypeFonction.equals("sigmoide")) {
            return 1 / (1 + Math.exp(-z));
        }
        return 0; // Par défaut, retourne 0 si le type de fonction d'activation n'est pas reconnu
    }

    // Méthode pour obtenir la sortie du neurone
    double getSortie() {
        return activation;
    }
}
