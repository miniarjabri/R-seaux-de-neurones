package LesNeurones;

import java.util.Arrays;
import java.util.Random;

public class NeuroneCache {
    private double[] poids; // Les poids des connexions entre ce neurone et les neurones de la couche suivante
    private double biais; // Le biais (seuil) du neurone
    private int position; // La position du neurone dans la couche
    private String typeFonction; // Le type de fonction d'activation utilisée par le neurone
    private double agregation; // La somme pondérée des entrées du neurone
    private double activation; // La sortie du neurone après l'application de la fonction d'activation

    // Constructeur pour initialiser le neurone avec ses poids, son biais et sa position
    public NeuroneCache(String typeFonction, Neurone[] n, int position, int nbNeuronneCoucheSuivante) {
        // Initialisation aléatoire du biais (seuil)
        Random random = new Random();
        biais = random.nextDouble();

        // Initialisation aléatoire des poids
        poids = new double[nbNeuronneCoucheSuivante];
        for (int i = 0; i < nbNeuronneCoucheSuivante; i++) {
            poids[i] = random.nextDouble();
        }

        // Position du neurone dans la couche
        this.position = position;

        // Calcul de l'agrégation du neurone
        agregation = sommePonderee(n, position) + biais;

        // Calcul de l'activation du neurone
        this.activation = Factivation(agregation, typeFonction);
    }

    // Méthode pour calculer la somme pondérée des entrées
    double sommePonderee(Neurone[] n, int pos) {
        double somme = 0.0;
        for (int i = 0; i < pos; i++) {
            somme += n[i].getPoids()[pos - 1] * n[i].getActivation();
        }
        return somme;
    }

    // Méthodes setter et getter pour les poids et le biais
    public void setPoids(double[] poids) {
        this.poids = Arrays.copyOf(poids, poids.length);
    }

    public double[] getPoids() {
        return this.poids;
    }

    public void setBiais(double biais) {
        this.biais = biais;
    }

    public double getBiais() {
        return this.biais;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }


 // Méthode pour l'activation du neurone
    @override
    public double Factivation(double z, String typeFonction) {
        if (typeFonction.equals("sigmoide")) {
            return 1 / (1 + Math.exp(-z));
        } else if (typeFonction.equals("identite")) {
            return z;
        } else if (typeFonction.equals("heaviside")) {
            return z < 0 ? 0 : 1;
        } else {
            return 0; // Par défaut, retourne 0 si le type de fonction d'activation n'est pas reconnu
        }
    }

}
